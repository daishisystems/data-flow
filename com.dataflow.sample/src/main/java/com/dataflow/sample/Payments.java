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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.beam.sdk.values.TupleTagList;
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
                            mapper.readValue(c.element(), MasterPayment.class);
                            LOG.info("Data is a MasterPayment");
                            c.output(c.element());
                        } catch (Exception e0) {
                            try {
                                mapper.readValue(c.element(), PaymentOrder.class);
                                LOG.info("Data is a PaymentOrder");
                                c.output(c.element());
                            } catch (Exception e1) {
                                try {
                                    mapper.readValue(c.element(), PaymentMethod.class);
                                    LOG.info("Data is a PaymentMethod");
                                    c.output(c.element());
                                } catch (Exception e2) {
                                    try {
                                        mapper.readValue(c.element(), PaymentAttempt.class);
                                        LOG.info("Data is a PaymentAttempt");
                                        c.output(c.element());
                                    } catch (Exception e3) {
                                        LOG.error("Unsupported data type. " + e3.getMessage());
                                        c.output(invalidPaymentsTupleTag, c.element());
                                    }
                                }
                            }

                        }
                    }
                }).withOutputTags(validPaymentsTupleTag, TupleTagList.of(invalidPaymentsTupleTag)));

        outputTuple.get(validPaymentsTupleTag).apply("Master Payment Queue",
                PubsubIO.writeStrings().to(options.getPaymentMasterTopic()));

        outputTuple.get(invalidPaymentsTupleTag).apply("Dead Letter Queue",
                PubsubIO.writeStrings().to(options.getDeadLetterTopic()));

        p.run().waitUntilFinish();
    }
}