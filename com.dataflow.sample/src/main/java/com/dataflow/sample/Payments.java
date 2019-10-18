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
        final TupleTag<MasterPayment> masterPaymentTupleTag = new TupleTag<MasterPayment>() {

            /**
             *
             */
            private static final long serialVersionUID = -4515769910419260250L;

        };

        final TupleTag<PaymentOrder> paymentOrderTupleTag = new TupleTag<PaymentOrder>() {

            /**
             *
             */
            private static final long serialVersionUID = -2258463980385295341L;

        };

        final TupleTag<PaymentMethod> paymentMethodTupleTag = new TupleTag<PaymentMethod>() {

            /**
             *
             */
            private static final long serialVersionUID = -7310106054264551637L;

        };

        final TupleTag<PaymentAttempt> paymentAttemptTupleTag = new TupleTag<PaymentAttempt>() {

            /**
             *
             */
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
                            MasterPayment masterPayment = mapper.readValue(c.element(), MasterPayment.class);
                            c.output(masterPaymentTupleTag, masterPayment);
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
                                .and(paymentAttemptTupleTag).and(invalidPaymentsTupleTag)));

        outputTuple.get(masterPaymentTupleTag).apply("Apply Payment Schema", new PaymentsToTableRows()).apply(
                "Save Payments",
                BigQueryIO.writeTableRows().to(options.getPaymentsTableName()).withSchema(getTableSchema())
                        .withMethod(BigQueryIO.Write.Method.STREAMING_INSERTS)
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

    static class PaymentsToTableRows extends PTransform<PCollection<MasterPayment>, PCollection<TableRow>> {

        private static final long serialVersionUID = 1L;

        @Override
        public PCollection<TableRow> expand(PCollection<MasterPayment> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatPaymentAsTableRowFn()));
            return tableRows;
        }
    }

    private static TableSchema getTableSchema() {
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
}