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
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.beam.sdk.values.TupleTagList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Payments {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        final TupleTag<String> validPaymentsTupleTag = new TupleTag<String>() {
            private static final long serialVersionUID = -911529081862788523L;
        };
        final TupleTag<String> invalidPaymentsTupleTag = new TupleTag<String>() {
            private static final long serialVersionUID = 2107437058874392877L;
        };
        final TupleTag<PaymentAttempt2> paymentAttempt2TupleTag = new TupleTag<PaymentAttempt2>() {
            private static final long serialVersionUID = -4515769910419260250L;
        };
        final TupleTag<MasterPayment> masterPaymentTupleTag = new TupleTag<MasterPayment>() {

            private static final long serialVersionUID = -4515769910419260250L;

        };

        final TupleTag<PaymentOrder> paymentOrderTupleTag = new TupleTag<PaymentOrder>() {

            private static final long serialVersionUID = -2258463980385295341L;

        };

        final TupleTag<PaymentMethod> paymentMethodTupleTag = new TupleTag<PaymentMethod>() {

            private static final long serialVersionUID = -7310106054264551637L;

        };

        final TupleTag<PaymentAttempt> paymentAttemptTupleTag = new TupleTag<PaymentAttempt>() {

            private static final long serialVersionUID = 1032082630449438172L;

        };

        PaymentPipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
                .as(PaymentPipelineOptions.class);
        Pipeline p = Pipeline.create(options);

        mapper.registerModule(new JodaModule());

        PCollectionTuple outputTuple = p.apply("Read Input", PubsubIO.readStrings().fromTopic(options.getInputTopic()))
                .apply("Validate", ParDo.of(new DoFn<String, String>() {
                    private static final long serialVersionUID = -4680854998419688341L;

                    @ProcessElement
                    public void processElement(ProcessContext c) {
                        try {
                            PaymentAttempt2 paymentAttempt2 = mapper.readValue(c.element(), PaymentAttempt2.class);
                            c.output(paymentAttempt2TupleTag, paymentAttempt2);
                        } catch (Exception e0) {
                            try {
                                PaymentOrder paymentOrder = mapper.readValue(c.element(), PaymentOrder.class);
                                c.output(paymentOrderTupleTag, paymentOrder);
                            } catch (Exception e1) {
                                try {
                                    PaymentMethod paymentMethod = mapper.readValue(c.element(), PaymentMethod.class);
                                    c.output(paymentMethodTupleTag, paymentMethod);
                                } catch (Exception e2) {
                                    try {
                                        PaymentAttempt paymentAttempt = mapper.readValue(c.element(),
                                                PaymentAttempt.class);
                                        c.output(paymentAttemptTupleTag, paymentAttempt);
                                    } catch (Exception e3) {
                                        LOG.error("Unsupported data type. " + e3.getMessage());
                                        c.output(invalidPaymentsTupleTag, c.element());
                                    }
                                }
                            }

                        }
                    }
                }).withOutputTags(validPaymentsTupleTag,
                        TupleTagList.of(masterPaymentTupleTag).and(paymentOrderTupleTag).and(paymentMethodTupleTag)
                                .and(paymentAttempt2TupleTag).and(paymentAttemptTupleTag)
                                .and(invalidPaymentsTupleTag)));

        outputTuple.get(paymentAttempt2TupleTag).apply("Apply Payment Schema", new PaymentAttempts2ToTableRows()).apply(
                "Save Payment Attempts",
                BigQueryIO.writeTableRows().to(options.getPaymentAttempts2TableName())
                        .withSchema(getPaymentAttempt2TableSchema())
                        .withMethod(BigQueryIO.Write.Method.STREAMING_INSERTS)
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        outputTuple.get(paymentOrderTupleTag).apply("Apply PaymentOrder Schema", new PaymentOrdersToTableRows())
                .apply("Save Payment Orders", BigQueryIO.writeTableRows().to(options.getPaymentOrdersTableName())
                        .withSchema(getPaymentOrdersTableSchema()).withMethod(BigQueryIO.Write.Method.STREAMING_INSERTS)
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        outputTuple.get(invalidPaymentsTupleTag).apply("Dead Letter Queue",
                PubsubIO.writeStrings().to(options.getDeadLetterTopic()));

        p.run().waitUntilFinish();
    }

    static class FormatPaymentAsTableRowFn extends DoFn<MasterPayment, TableRow> {
        private static final long serialVersionUID = -8153317967799323892L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();
            MasterPayment payment = c.element();

            tableRow.set("id", payment.getId());
            tableRow.set("paymentProfileId", payment.getPaymentProfileId());
            tableRow.set("orderRef", payment.getOrderRef());
            tableRow.set("paymentResultUrl", payment.getPaymentResultUrl());
            tableRow.set("authorizationUrl", payment.getAuthorizationUrl());
            tableRow.set("postAuthHandoverUrl", payment.getPostAuthHandoverUrl());
            tableRow.set("created", new DateTime(payment.getCreated()).withZone(DateTimeZone.UTC).toString());
            c.output(tableRow);
        }
    }

    static class FormatPaymentOrderAsTableRowFn extends DoFn<PaymentOrder, TableRow> {

        private static final long serialVersionUID = 5865631802936446417L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();
            PaymentOrder paymentOrder = c.element();

            tableRow.set("id", paymentOrder.getId());
            tableRow.set("orderRef", paymentOrder.getOrderRef());
            tableRow.set("orderNumber", paymentOrder.getOrderNumber());
            tableRow.set("totalPaymentAmount", paymentOrder.getTotalPaymentAmount());
            tableRow.set("currencyIso", paymentOrder.getCurrencyIso());
            tableRow.set("customClientCulture", paymentOrder.getCustomClientCulture());
            tableRow.set("ipAddress", paymentOrder.getIpAddress());
            tableRow.set("paymentShippingAddress", paymentOrder.getPaymentShippingAddress());
            tableRow.set("paymentBillingAddress", paymentOrder.getPaymentBillingAddress());
            tableRow.set("orderItems", paymentOrder.getOrderItems());
            tableRow.set("created", new DateTime(paymentOrder.getCreated()).withZone(DateTimeZone.UTC).toString());
            c.output(tableRow);
        }
    }

    static class FormatPaymentAttempt2sAsTableRowFn extends DoFn<PaymentAttempt2, TableRow> {
        private static final long serialVersionUID = 3651539595485348500L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();
            PaymentAttempt2 paymentAttempt2 = c.element();

            tableRow.set("PaymentAttemptId", paymentAttempt2.getPaymentAttemptId());
            tableRow.set("PaymentAttemptRef", paymentAttempt2.getPaymentAttemptRef());
            tableRow.set("BrandCode", paymentAttempt2.getBrandCode());
            tableRow.set("OrderRef", paymentAttempt2.getOrderRef());
            tableRow.set("CreatedUtc", paymentAttempt2.getCreatedUtc());
            tableRow.set("LastUpdatedUtc", paymentAttempt2.getLastUpdatedUtc());
            tableRow.set("State", paymentAttempt2.getState());
            tableRow.set("PaymentGatewayCode", paymentAttempt2.getPaymentGatewayCode());
            tableRow.set("PaymentMethodCode", paymentAttempt2.getPaymentMethodCode());
            tableRow.set("GatewayTransactionId", paymentAttempt2.getGatewayTransactionId());
            tableRow.set("AuthCode", paymentAttempt2.getAuthCode());
            tableRow.set("eventName", paymentAttempt2.getEventName());
            tableRow.set("correlationId", paymentAttempt2.getCorrelationId());
            tableRow.set("queryString", paymentAttempt2.getQueryString());
            String bqDate = Utils.convertUnixDate(paymentAttempt2.getCreated());
            tableRow.set("created", bqDate);

            c.output(tableRow);
        }
    }

    static class PaymentsToTableRows extends PTransform<PCollection<MasterPayment>, PCollection<TableRow>> {

        private static final long serialVersionUID = 4816190822434155910L;

        @Override
        public PCollection<TableRow> expand(PCollection<MasterPayment> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatPaymentAsTableRowFn()));
            return tableRows;
        }
    }

    static class PaymentOrdersToTableRows extends PTransform<PCollection<PaymentOrder>, PCollection<TableRow>> {

        private static final long serialVersionUID = 4816190822434155910L;

        @Override
        public PCollection<TableRow> expand(PCollection<PaymentOrder> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatPaymentOrderAsTableRowFn()));
            return tableRows;
        }
    }

    static class PaymentAttempts2ToTableRows extends PTransform<PCollection<PaymentAttempt2>, PCollection<TableRow>> {

        private static final long serialVersionUID = 4816190822434155910L;

        @Override
        public PCollection<TableRow> expand(PCollection<PaymentAttempt2> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatPaymentAttempt2sAsTableRowFn()));
            return tableRows;
        }
    }

    private static TableSchema getPaymentsTableSchema() {
        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("id").setType("STRING"));
        fields.add(new TableFieldSchema().setName("paymentProfileId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("orderRef").setType("INT64"));
        fields.add(new TableFieldSchema().setName("paymentResultUrl").setType("INT64"));
        fields.add(new TableFieldSchema().setName("authorizationUrl").setType("INT64"));
        fields.add(new TableFieldSchema().setName("postAuthHandoverUrl").setType("STRING"));
        fields.add(new TableFieldSchema().setName("created").setType("TIMESTAMP"));
        return new TableSchema().setFields(fields);
    }

    private static TableSchema getPaymentAttempt2TableSchema() {
        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("PaymentAttemptId").setType("NUMERIC"));
        fields.add(new TableFieldSchema().setName("PaymentAttemptRef").setType("STRING"));
        fields.add(new TableFieldSchema().setName("OrderRef").setType("STRING"));
        fields.add(new TableFieldSchema().setName("CreatedUtc").setType("STRING"));
        fields.add(new TableFieldSchema().setName("LastUpdatedUtc").setType("STRING"));
        fields.add(new TableFieldSchema().setName("State").setType("INT64"));
        fields.add(new TableFieldSchema().setName("PaymentGatewayCode").setType("STRING"));
        fields.add(new TableFieldSchema().setName("PaymentMethodCode").setType("STRING"));
        fields.add(new TableFieldSchema().setName("GatewayTransactionId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("AuthCode").setType("STRING"));
        fields.add(new TableFieldSchema().setName("brandCode").setType("STRING"));
        fields.add(new TableFieldSchema().setName("eventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("correlationId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("queryString").setType("STRING"));
        fields.add(new TableFieldSchema().setName("created").setType("TIMESTAMP"));
        return new TableSchema().setFields(fields);
    }

    private static TableSchema getPaymentOrdersTableSchema() {
        List<TableFieldSchema> paymentOrderFields = new ArrayList<>();
        paymentOrderFields.add(new TableFieldSchema().setName("id").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("orderRef").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("orderNumber").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("totalPaymentAmount").setType("FLOAT"));
        paymentOrderFields.add(new TableFieldSchema().setName("currencyIso").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("customClientCulture").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("ipAddress").setType("STRING"));
        List<TableFieldSchema> paymentShippingAddressFields = new ArrayList<>();
        paymentShippingAddressFields.add(new TableFieldSchema().setName("firstName").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("lastName").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("fullName").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("addressLine1").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("addressLine2").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("addressLine3").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("city").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("region").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("postalCode").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("countryIso").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("phone").setType("STRING"));
        paymentShippingAddressFields.add(new TableFieldSchema().setName("email").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("paymentShippingAddress").setType("RECORD")
                .setFields(paymentShippingAddressFields));
        List<TableFieldSchema> paymentBillingAddressFields = new ArrayList<>();
        paymentBillingAddressFields.add(new TableFieldSchema().setName("firstName").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("lastName").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("fullName").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("addressLine1").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("addressLine2").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("addressLine3").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("city").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("region").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("postalCode").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("countryIso").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("phone").setType("STRING"));
        paymentBillingAddressFields.add(new TableFieldSchema().setName("email").setType("STRING"));
        paymentOrderFields.add(new TableFieldSchema().setName("paymentBillingAddress").setType("RECORD")
                .setFields(paymentBillingAddressFields));
        List<TableFieldSchema> orderItemsFields = new ArrayList<>();
        orderItemsFields.add(new TableFieldSchema().setName("paymentOrderItemId").setType("FLOAT"));
        orderItemsFields.add(new TableFieldSchema().setName("name").setType("STRING"));
        orderItemsFields.add(new TableFieldSchema().setName("description").setType("STRING"));
        orderItemsFields.add(new TableFieldSchema().setName("sequenceNumber").setType("INT64"));
        orderItemsFields.add(new TableFieldSchema().setName("quantity").setType("INT64"));
        orderItemsFields.add(new TableFieldSchema().setName("productCode").setType("STRING"));
        orderItemsFields.add(new TableFieldSchema().setName("unitPriceExCharges").setType("FLOAT"));
        orderItemsFields.add(new TableFieldSchema().setName("unitShippingCharge").setType("FLOAT"));
        orderItemsFields.add(new TableFieldSchema().setName("unitTaxCharge").setType("FLOAT"));
        paymentOrderFields
                .add(new TableFieldSchema().setName("orderItems").setType("RECORD").setFields(orderItemsFields));
        return new TableSchema().setFields(paymentOrderFields);
    }
}