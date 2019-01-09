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

import com.deviceatlas.cloud.deviceidentification.cacheprovider.EhCacheCacheProvider;
import com.deviceatlas.cloud.deviceidentification.client.Client;
import com.deviceatlas.cloud.deviceidentification.client.Properties;
import com.deviceatlas.cloud.deviceidentification.client.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final ObjectMapper mapper = getObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final Client client = getClient();

    static Client getClient() {
        Client client = null;
        try {
            client = Client.getInstance(new EhCacheCacheProvider());
            client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");
            LOG.warn("Client created.");
        } catch (Exception e2) {
            LOG.warn("Could not create new client. " + e2.getMessage());
            try {
                client = Client.getInstance();
                client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");
                LOG.warn("Client retrieved.");
            } catch (Exception e1) {
                LOG.error("Failed to get existing client. " + e1.getMessage());
            }
        }
        return client;
    }

    static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Properties.class, new PropertiesSerialiser());
        mapper.registerModule(module);
        mapper.registerModule(new JodaModule());
        return mapper;
    }

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

        PCollection<String> pubSubOutput = p.apply("Read Input",
                PubsubIO.readStrings().fromTopic(options.getInputTopic())); // FIXME: Read from Subscription!

        PCollectionTuple outputTuple = pubSubOutput.apply("Validate",
                ParDo.of(new DoFn<String, KV<String, MasterOrder>>() {
                    private static final long serialVersionUID = 5729779425621385553L;

                    @ProcessElement
                    public void processElement(ProcessContext c) {
                        try {
                            MasterOrder masterOrder = mapper.readValue(c.element(), MasterOrder.class);
                            c.output(KV.of(masterOrder.getCorrelationId(), masterOrder)); // FIXME: Obfuscate here if
                                                                                          // !complete
                        } catch (Exception e) {
                            LOG.error(e.getMessage());
                            c.output(invalidOrdersTupleTag, c.element());
                        }
                    }
                }).withOutputTags(validOrdersTupleTag, TupleTagList.of(invalidOrdersTupleTag)));

        outputTuple.get(validOrdersTupleTag)
                .apply("Device Atlas GET", ParDo.of(new DoFn<KV<String, MasterOrder>, String>() {
                    private static final long serialVersionUID = 5752210303711482564L;

                    // FIXME: Add ordercode, timestamp, etc.
                    // FIXME: Ignore invalid User Agents
                    @ProcessElement
                    public void processElement(ProcessContext c) {
                        try {
                            MasterOrder masterOrder = c.element().getValue();
                            Result result = client.getResultByUserAgent(masterOrder.getUserAgent());
                            Properties properties = result.getProperties();
                            String serialised = mapper.writeValueAsString(properties);
                            DeviceAtlasProperties deviceAtlasProperties = mapper.readValue(serialised,
                                    DeviceAtlasProperties.class); // FIXME: Adapt, rather than serialise
                            deviceAtlasProperties.setCreated(
                                    new DateTime(masterOrder.getCreated()).withZone(DateTimeZone.UTC).toString());
                            deviceAtlasProperties.setOrdercode(masterOrder.getOrderCode());
                            c.output(mapper.writeValueAsString(deviceAtlasProperties));
                        } catch (Exception e) {
                            LOG.error("Unable to get device properties. " + e.getMessage());
                        }
                    }
                })).apply("Device Atlas Publish", PubsubIO.writeStrings().to(options.getDeviceAtlasTopic()));

        PCollection<KV<String, Iterable<MasterOrder>>> masterOrders = outputTuple.get(validOrdersTupleTag)
                .apply("Window",
                        Window.<KV<String, MasterOrder>>into(Sessions.withGapDuration(
                                Duration.standardSeconds(Long.parseLong(options.getSessionWindowGapDuration())))))
                .apply("Group", GroupByKey.create()); // FIXME: Use triggers to push early!!!

        outputTuple.get(invalidOrdersTupleTag).apply("Dead Letter Queue",
                PubsubIO.writeStrings().to(options.getDeadLetterTopic()));

        PCollection<List<MasterOrder>> groupedOrders = masterOrders.apply("Map", ParDo.of(new GroupOrdersFn()));

        groupedOrders.apply("Summarise", ParDo.of(new OrderSummaryFn()))
                .apply("Apply Schema", new OrderSummariesToTableRows()).apply("Save to BQ",
                        BigQueryIO.writeTableRows().to(options.getOrderSummaryTable()).withSchema(getTableSchema())
                                .withMethod(BigQueryIO.Write.Method.STREAMING_INSERTS)
                                .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                                .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        PCollectionTuple processedOrdersTuple = masterOrders.apply("Analyse", // FIXME: !!!This can occur before
                                                                              // grouping ...
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
        completeOrders.apply("Archive Complete", PubsubIO.writeStrings().to(options.getArchiveTopic())); // FIXME: Use
                                                                                                         // separate DF
                                                                                                         // job.

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
        fields.add(new TableFieldSchema().setName("PrimaryHardwareType").setType("STRING"));
        fields.add(new TableFieldSchema().setName("IsRobot").setType("BOOLEAN"));
        fields.add(new TableFieldSchema().setName("BrowserName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("OsName").setType("STRING"));
        return new TableSchema().setFields(fields);
    }

    static class MaskOrderFn extends DoFn<MasterOrder, MasterOrder> {
        private static final long serialVersionUID = -3894610851045133386L;

        @ProcessElement
        public void processElement(ProcessContext c) throws IOException {
            // FIXME: Obfuscate here and in order-summary flow
            String copy = mapper.writeValueAsString(c.element());
            MasterOrder masterOrder = mapper.readValue(copy, MasterOrder.class);

            List<DeliveryDetail> deliveryDetails = masterOrder.getDeliveryDetails();
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
            List<PaymentDetail> paymentDetails = masterOrder.getPaymentDetails();
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
            if (masterOrder.getCorrelationId() != null && !masterOrder.getCorrelationId().isEmpty()) {
                masterOrder.setCorrelationId(Utils.mask(masterOrder.getCorrelationId(), '#'));
            }

            if (masterOrder.getFingerprintId() != null && !masterOrder.getFingerprintId().isEmpty()) {
                masterOrder.setFingerprintId(Utils.mask(masterOrder.getFingerprintId(), '#'));
            }

            LOG.warn("Loaded order num " + masterOrder.getOrderCode());
            c.output(masterOrder);            
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

    static class OrderSummaryFn extends DoFn<List<MasterOrder>, OrderSummary> {
        private static final long serialVersionUID = -3067528732035106582L;
        final String COMPLETE_EVENT_NAME = "CompleteOrder";

        @ProcessElement
        public void processElement(ProcessContext c) throws Exception {
            List<MasterOrder> sortedOrders = OrderSummary.sortOrders(c.element());
            OrderSummary orderSummary = OrderSummary.orderSummary(sortedOrders, COMPLETE_EVENT_NAME);

            Result result = client.getResultByUserAgent(orderSummary.getUserAgent());
            Properties properties = result.getProperties();

            if (properties.containsKey("primaryHardwareType")) {
                orderSummary.setPrimaryHardwareType(properties.get("primaryHardwareType").asString());
            }
            if (properties.containsKey("isRobot")) {
                orderSummary.setIsRobot(properties.get("isRobot").asBoolean());
            }
            if (properties.containsKey("browserName")) {
                orderSummary.setBrowserName(properties.get("browserName").asString());
            }
            if (properties.containsKey("osName")) {
                orderSummary.setOsName(properties.get("osName").asString());
            }
            c.output(orderSummary);
        }
    }

    static class GroupOrdersFn extends DoFn<KV<String, Iterable<MasterOrder>>, List<MasterOrder>> {

        private static final long serialVersionUID = -8421532686353495449L;

        @ProcessElement
        public void ProcessElement(ProcessContext c) {
            for (List<MasterOrder> masterOrders : Utils.groupOrders(c.element().getValue())) {
                LOG.warn("Orders grouped");
                c.output(masterOrders);
            }
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
            tableRow.set("PrimaryHardwareType", orderSummary.getPrimaryHardwareType());
            tableRow.set("IsRobot", orderSummary.getIsRobot());
            tableRow.set("BrowserName", orderSummary.getBrowserName());
            tableRow.set("OsName", orderSummary.getOsName());
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