/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dataflow.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.Sessions;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.beam.sdk.values.TupleTagList;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        CustomPipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
                .as(CustomPipelineOptions.class);
        Pipeline p = Pipeline.create(options);

        final TupleTag<KV<String, MasterOrder>> validOrdersTupleTag = new TupleTag<KV<String, MasterOrder>>() {
            private static final long serialVersionUID = 5729779425621385553L;
        };
        final TupleTag<String> invalidOrdersTupleTag = new TupleTag<String>() {
            private static final long serialVersionUID = -3414994155123840086L;
        };
        final TupleTag<MasterOrder> completeOrdersTag = new TupleTag<MasterOrder>() {
            private static final long serialVersionUID = -8287090181826227743L;
        };
        final TupleTag<MasterOrder> incompleteOrdersTag = new TupleTag<MasterOrder>() {
            private static final long serialVersionUID = 6238727806361931139L;
        };

        mapper.registerModule(new JodaModule());

        PCollection<String> pubSubOutput = p.apply("Read Input",
                PubsubIO.readStrings().fromTopic(options.getInputTopic()).withTimestampAttribute("EventTimestamp"));

        PCollectionTuple outputTuple = pubSubOutput.apply("Validate",
                ParDo.of(new DoFn<String, KV<String, MasterOrder>>() {
                    private static final long serialVersionUID = 5729779425621385553L;

                    @ProcessElement
                    public void processElement(ProcessContext c) {
                        try {
                            MasterOrder masterOrder = mapper.readValue(c.element(), MasterOrder.class);
                            c.output(KV.of(masterOrder.getCorrelationId(), masterOrder));
                        } catch (Exception e) {
                            LOG.error(e.getMessage());
                            c.output(invalidOrdersTupleTag, c.element());
                        }
                    }
                }).withOutputTags(validOrdersTupleTag, TupleTagList.of(invalidOrdersTupleTag)));

        PCollection<KV<String, Iterable<MasterOrder>>> masterOrders = outputTuple.get(validOrdersTupleTag)
                .apply("Window",
                        Window.<KV<String, MasterOrder>>into(Sessions.withGapDuration(
                                Duration.standardSeconds(Long.parseLong(options.getSessionWindowGapDuration())))))
                .apply("Group", GroupByKey.create());

        outputTuple.get(invalidOrdersTupleTag).apply("Dead Letter Queue",
                PubsubIO.writeStrings().to(options.getDeadLetterTopic()));

        masterOrders.apply("Summarise", ParDo.of(new OrderSummaryFn()))
                .apply("Apply Schema", new OrderSummariesToTableRows()).apply("Save to BQ",
                        BigQueryIO.writeTableRows().to(options.getOrderSummaryTable()).withSchema(getTableSchema())
                                .withMethod(BigQueryIO.Write.Method.STREAMING_INSERTS)
                                .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                                .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        PCollectionTuple processedOrdersTuple = masterOrders.apply("Analyse",
                ParDo.of(new DoFn<KV<String, Iterable<MasterOrder>>, MasterOrder>() {
                    private static final long serialVersionUID = -4644201311299503730L;
                    final String COMPLETE_EVENT_NAME = "CompleteOrder";

                    @ProcessElement
                    public void processElement(ProcessContext c) throws Exception {
                        Iterable<MasterOrder> iterableOrders = c.element().getValue();
                        List<MasterOrder> orders = OrderSummary.sortOrders(iterableOrders);
                        boolean orderIsComplete = OrderSummary.orderIsComplete(orders, COMPLETE_EVENT_NAME);
                        if (orderIsComplete) {
                            for (MasterOrder masterOrder : orders) {
                                c.output(completeOrdersTag, masterOrder);
                            }
                        } else {
                            for (MasterOrder masterOrder : orders) {
                                c.output(incompleteOrdersTag, masterOrder);
                            }
                        }
                    }
                }).withOutputTags(completeOrdersTag, TupleTagList.of(incompleteOrdersTag)));

        PCollection<String> completeOrders = processedOrdersTuple.get(completeOrdersTag).apply("Serialise Complete",
                ParDo.of(new SerialiseMasterOrderFn()));

        completeOrders.apply("Publish Complete", PubsubIO.writeStrings().to(options.getOrderMasterTopic()));
        completeOrders.apply("Archive Complete", PubsubIO.writeStrings().to(options.getArchiveTopic()));

        PCollection<String> incompleteOrders = processedOrdersTuple.get(incompleteOrdersTag)
                .apply("Mask", new MaskOrdersFn())
                .apply("Serialise Incomplete", ParDo.of(new SerialiseMasterOrderFn()));

        incompleteOrders.apply("Publish Incomplete", PubsubIO.writeStrings().to(options.getOrderMasterTopic()));
        incompleteOrders.apply("Archive Incomplete", PubsubIO.writeStrings().to(options.getArchiveTopic()));

        p.run().waitUntilFinish();
    }

    private static TableSchema getTableSchema() {
        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("OrderNumber").setType("STRING"));
        fields.add(new TableFieldSchema().setName("CorrelationId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MinTimeDelay").setType("INT64"));
        fields.add(new TableFieldSchema().setName("AvgTimeDelay").setType("INT64"));
        fields.add(new TableFieldSchema().setName("MaxTimeDelay").setType("INT64"));
        fields.add(new TableFieldSchema().setName("MinFirstEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MaxFirstEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MinSecondEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MaxSecondEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("TotalTime").setType("INT64"));
        fields.add(new TableFieldSchema().setName("LastEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("Complete").setType("BOOLEAN"));
        fields.add(new TableFieldSchema().setName("StartDate").setType("TIMESTAMP"));
        fields.add(new TableFieldSchema().setName("EndDate").setType("TIMESTAMP"));
        fields.add(new TableFieldSchema().setName("OrderValue").setType("NUMERIC"));
        fields.add(new TableFieldSchema().setName("UserAgent").setType("STRING"));
        fields.add(new TableFieldSchema().setName("Country").setType("STRING"));
        fields.add(new TableFieldSchema().setName("UnitsPerOrder").setType("INT64"));
        fields.add(new TableFieldSchema().setName("BrandCode").setType("STRING"));
        return new TableSchema().setFields(fields);
    }

    static class MaskOrderFn extends DoFn<MasterOrder, MasterOrder> {
        private static final long serialVersionUID = -3894610851045133386L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            MasterOrder o = c.element();
            List<DeliveryDetail> deliveryDetails = o.getDeliveryDetails();
            for (DeliveryDetail deliveryDetail : deliveryDetails) {
                String contactDetailsNickname = deliveryDetail.getContactDetailsNickName();
                if (contactDetailsNickname != null && !contactDetailsNickname.isEmpty()) {
                    deliveryDetail.setContactDetailsNickName(Utils.mask(contactDetailsNickname, '#'));
                }
                String address1 = deliveryDetail.getAddress1();
                if (address1 != null && !address1.isEmpty()) {
                    deliveryDetail.setAddress1(Utils.mask(address1, '#'));
                }
                String address2 = deliveryDetail.getAddress2();
                if (address2 != null && !address2.isEmpty()) {
                    deliveryDetail.setAddress2(Utils.mask(address2, '#'));
                }
                String address3 = deliveryDetail.getAddress3();
                if (address3 != null && !address3.isEmpty()) {
                    deliveryDetail.setAddress3(Utils.mask(address3, '#'));
                }
                String postalCode = deliveryDetail.getPostalCode();
                if (postalCode != null && !postalCode.isEmpty()) {
                    deliveryDetail.setPostalCode(Utils.mask(postalCode, '#'));
                }
                String region = deliveryDetail.getRegion();
                if (region != null && !region.isEmpty()) {
                    deliveryDetail.setRegion(Utils.mask(region, '#'));
                }
                String email = deliveryDetail.getEmail();
                if (email != null && !email.isEmpty()) {
                    deliveryDetail.setEmail(Utils.mask(email, '#'));
                }
                String firstName = deliveryDetail.getFirstName();
                if (firstName != null && !firstName.isEmpty()) {
                    deliveryDetail.setFirstName(Utils.mask(firstName, '#'));
                }
                String lastName = deliveryDetail.getLastName();
                if (lastName != null && !lastName.isEmpty()) {
                    deliveryDetail.setLastName(Utils.mask(lastName, '#'));
                }
                deliveryDetail.setGender(-1);
                String telephone = deliveryDetail.getTelephone();
                if (telephone != null && !telephone.isEmpty()) {
                    deliveryDetail.setTelephone(Utils.mask(telephone, '#'));
                }
                String poBox = deliveryDetail.getPoBox();
                if (poBox != null && !poBox.isEmpty()) {
                    deliveryDetail.setPoBox(Utils.mask(poBox, '#'));
                }
            }
            List<PaymentDetail> paymentDetails = o.getPaymentDetails();
            for (PaymentDetail paymentDetail : paymentDetails) {
                String contactDetailsNickname = paymentDetail.getContactDetailsNickName();
                if (contactDetailsNickname != null && !contactDetailsNickname.isEmpty()) {
                    paymentDetail.setContactDetailsNickName(Utils.mask(contactDetailsNickname, '#'));
                }
                String address1 = paymentDetail.getAddress1();
                if (address1 != null && !address1.isEmpty()) {
                    paymentDetail.setAddress1(Utils.mask(address1, '#'));
                }
                String address2 = paymentDetail.getAddress2();
                if (address2 != null && !address2.isEmpty()) {
                    paymentDetail.setAddress2(Utils.mask(address2, '#'));
                }
                String address3 = paymentDetail.getAddress3();
                if (address3 != null && !address3.isEmpty()) {
                    paymentDetail.setAddress3(Utils.mask(address3, '#'));
                }
                String postalCode = paymentDetail.getPostalCode();
                if (postalCode != null && !postalCode.isEmpty()) {
                    paymentDetail.setPostalCode(Utils.mask(postalCode, '#'));
                }
                String region = paymentDetail.getRegion();
                if (region != null && !region.isEmpty()) {
                    paymentDetail.setRegion(Utils.mask(region, '#'));
                }
                String email = paymentDetail.getEmail();
                if (email != null && !email.isEmpty()) {
                    paymentDetail.setEmail(Utils.mask(email, '#'));
                }
                String firstName = paymentDetail.getFirstName();
                if (firstName != null && !firstName.isEmpty()) {
                    paymentDetail.setFirstName(Utils.mask(firstName, '#'));
                }
                String lastName = paymentDetail.getLastName();
                if (lastName != null && !lastName.isEmpty()) {
                    paymentDetail.setLastName(Utils.mask(lastName, '#'));
                }
                paymentDetail.setGender(-1);
                String telephone = paymentDetail.getTelephone();
                if (telephone != null && !telephone.isEmpty()) {
                    paymentDetail.setTelephone(Utils.mask(telephone, '#'));
                }
                String poBox = paymentDetail.getPoBox();
                if (poBox != null && !poBox.isEmpty()) {
                    paymentDetail.setPoBox(Utils.mask(poBox, '#'));
                }
            }
            o.setDeliveryDetails(deliveryDetails);
            c.output(o);
        }
    }

    static class MaskOrdersFn extends PTransform<PCollection<MasterOrder>, PCollection<MasterOrder>> {
        private static final long serialVersionUID = 7336178731649757662L;

        @Override
        public PCollection<MasterOrder> expand(PCollection<MasterOrder> input) {
            PCollection<MasterOrder> maskedOrders = input.apply(ParDo.of(new MaskOrderFn()));
            return maskedOrders;
        }
    }

    static class OrderSummaryFn extends DoFn<KV<String, Iterable<MasterOrder>>, OrderSummary> {
        private static final long serialVersionUID = -3067528732035106582L;
        final String COMPLETE_EVENT_NAME = "CompleteOrder";

        @ProcessElement
        public void processElement(ProcessContext c) throws Exception {
            Iterable<MasterOrder> orders = c.element().getValue();
            List<MasterOrder> sortedOrders = OrderSummary.sortOrders(orders);
            OrderSummary orderSummary = OrderSummary.orderSummary(sortedOrders, COMPLETE_EVENT_NAME);
            c.output(orderSummary);
        }
    }

    static class SerialiseMasterOrderFn extends DoFn<MasterOrder, String> {
        private static final long serialVersionUID = -6115553959647555680L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            MasterOrder masterOrder = c.element();
            c.output(mapper.writeValueAsString(masterOrder));
        }
    }

    static class FormatOrderSummaryAsTableRowFn extends DoFn<OrderSummary, TableRow> {
        private static final long serialVersionUID = 435139917692986619L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();
            OrderSummary orderSummary = c.element();

            tableRow.set("OrderNumber", orderSummary.getNumber());
            tableRow.set("CorrelationId", orderSummary.getCorrelationId());
            tableRow.set("MinTimeDelay", orderSummary.getMinTimeDelay());
            tableRow.set("AvgTimeDelay", orderSummary.getAvgTimedelay());
            tableRow.set("MaxTimeDelay", orderSummary.getMaxTimeDelay());
            tableRow.set("MinFirstEventName", orderSummary.getMinFirstEventName());
            tableRow.set("MinSecondEventName", orderSummary.getMinSecondEventName());
            tableRow.set("MaxFirstEventName", orderSummary.getMaxfirstEventName());
            tableRow.set("MaxSecondEventName", orderSummary.getMaxSecondEventName());
            tableRow.set("TotalTime", orderSummary.getTotalTime());
            tableRow.set("LastEventName", orderSummary.getLastEventName());
            tableRow.set("Complete", orderSummary.getComplete());
            tableRow.set("StartDate", orderSummary.getStartdate());
            tableRow.set("EndDate", orderSummary.getEnddate());
            tableRow.set("OrderValue", orderSummary.getOrderValue());
            tableRow.set("UserAgent", orderSummary.getUserAgent());
            tableRow.set("Country", orderSummary.getCountry());
            tableRow.set("UnitsPerOrder", orderSummary.getUnitsPerOrder());
            tableRow.set("BrandCode", orderSummary.getBrandCode());
            c.output(tableRow);
        }
    }

    static class OrderSummariesToTableRows extends PTransform<PCollection<OrderSummary>, PCollection<TableRow>> {
        private static final long serialVersionUID = -9160884567370640531L;

        @Override
        public PCollection<TableRow> expand(PCollection<OrderSummary> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatOrderSummaryAsTableRowFn()));
            return tableRows;
        }
    }
}