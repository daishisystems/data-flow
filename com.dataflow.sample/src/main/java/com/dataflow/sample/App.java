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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

import javax.lang.model.util.ElementScanner6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.beam.repackaged.beam_sdks_java_core.net.bytebuddy.implementation.bind.annotation.Default;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Combine;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.Combine.CombineFn;
import org.apache.beam.sdk.transforms.DoFn.ProcessElement;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.transforms.windowing.AfterPane;
import org.apache.beam.sdk.transforms.windowing.AfterProcessingTime;
import org.apache.beam.sdk.transforms.windowing.AfterWatermark;
import org.apache.beam.sdk.transforms.windowing.Repeatedly;
import org.apache.beam.sdk.transforms.windowing.Sessions;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.joda.time.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;

/**
 * An example that counts words in Shakespeare.
 *
 * <p>
 * This class, {@link App}, is the first in a series of four successively more
 * detailed 'word count' examples. Here, for simplicity, we don't show any
 * error-checking or argument processing, and focus on construction of the
 * pipeline, which chains together the application of core transforms.
 *
 * <p>
 * Next, see the {@link WordCount} pipeline, then the
 * {@link DebuggingWordCount}, and finally the {@link WindowedWordCount}
 * pipeline, for more detailed examples that introduce additional concepts.
 *
 * <p>
 * Concepts:
 *
 * <pre>
 *   1. Reading data from text files
 *   2. Specifying 'inline' transforms
 *   3. Counting items in a PCollection
 *   4. Writing data to text files
 * </pre>
 *
 * <p>
 * No arguments are required to run this pipeline. It will be executed with the
 * DirectRunner. You can see the results in the output files in your current
 * working directory, with names like "wordcounts-00001-of-00005. When running
 * on a distributed service, you would use an appropriate file service.
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().create();
        Pipeline p = Pipeline.create(options);
        LOG.info("PIPELINE CREATED.");

        PCollection<String> pubSubOutput = p.apply("ReadPubSub", PubsubIO.readStrings()
                .fromTopic("projects/eshop-bigdata/topics/orders-beam-input").withTimestampAttribute("EventTimestamp"));
        LOG.info("RECEIVING DATA ...");

        PCollection<KV<String, Order>> keyvalues = pubSubOutput.apply("To Key-valuePairs",
                ParDo.of(new ParseOrderToKVFn()));

        // PCollection<KV<String, Order>> window = keyvalues.apply("To Session window",
        // Window.<KV<String,
        // Order>>into(Sessions.withGapDuration(Duration.standardSeconds(20)))
        // .triggering(Repeatedly.forever(AfterProcessingTime.pastFirstElementInPane()))
        // .withAllowedLateness(Duration.ZERO).discardingFiredPanes());

        // PCollection<KV<String, Order>> window = keyvalues.apply("To Session window",
        // Window.<KV<String,
        // Order>>into(Sessions.withGapDuration(Duration.standardSeconds(25))).withAllowedLateness(Duration.standardMinutes(10)));
        // todo: Replace with above
        PCollection<KV<String, Order>> window = keyvalues.apply("To Session window",
                Window.<KV<String, Order>>into(Sessions.withGapDuration(Duration.standardSeconds(20))));

        LOG.info("Session window loaded ...");

        PCollection<KV<String, Integer>> orderStatus = window.apply("Get Order Status",
                ParDo.of(new ExtractOrderStatus()));

        PCollection<KV<String, Integer>> totals = orderStatus.apply(Combine.perKey(Sum.ofIntegers()));

        PCollection<String> serialised = totals.apply("Serialise Order Status", ParDo.of(new SerialiseOrderStatus()));

        // PCollection<String> orders = window.apply("Serialise Order", ParDo.of(new
        // SerialiseOrder()));

        // PCollection<String> orderStatuses = window.apply(GroupByKey.<String,
        // Order>create()).apply("Get Order Status",
        // ParDo.of(new FlattenOrdersSimple()));

        serialised.apply(PubsubIO.writeStrings().to("projects/eshop-bigdata/topics/dataflow-test-out"));

        // window.apply(GroupByKey.<String, Order>create()).apply("Get Order Status",
        // ParDo.of(new FlattenOrders()))
        // .apply("Serialise Order Status", ParDo.of(new
        // OrderStatusToString())).apply("Send to Pub/Sub",
        // PubsubIO.writeStrings().to("projects/eshop-bigdata/topics/dataflow-test-out"));

        // pubSubOutput.apply(PubsubIO.writeStrings().to("projects/eshop-bigdata/topics/dataflow-test-out"));

        p.run().waitUntilFinish();
    }

    static class ExtractOrderStatus extends DoFn<KV<String, Order>, KV<String, Integer>> {
        private static final long serialVersionUID = 1L;
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
            LOG.info("Extracting Order-status ...");

            Order order = c.element().getValue();
            Integer orderStatus = 0;
            if (order.getEventName().equals(COMPLETE_EVENT_NAME)) {
                orderStatus = 1;
            }
            c.output(KV.of(order.getCorrelationId(), orderStatus));
        }
    }

    static class FlattenOrders extends DoFn<KV<String, Iterable<Order>>, OrderStatus> {
        private static final long serialVersionUID = -180397528519989000L;
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
            LOG.info("Flattening Order ...");
            String correlationId = c.element().getKey();
            Iterable<Order> orders = c.element().getValue();
            boolean complete = false;
            boolean recurringVarsSet = false;
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.correlationId = correlationId;

            do {
                Order order = orders.iterator().next();
                if (!recurringVarsSet) {
                    orderStatus.setNumber(order.getNumber());
                    orderStatus.setTimestamp(order.getTimestamp());
                    recurringVarsSet = true;
                }
                if (order.getEventName().equals(COMPLETE_EVENT_NAME)) {
                    complete = true;
                    orderStatus.setComplete(complete);
                }
            } while (complete == false && orders.iterator().hasNext());
            c.output(orderStatus);
            LOG.info("Order complete: " + complete);
        }
    }

    static class FlattenOrdersSimple extends DoFn<KV<String, Iterable<Order>>, String> {
        private static final long serialVersionUID = -180397528519989000L;
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
            LOG.info("Flattening Order ...");
            String correlationId = c.element().getKey();
            Iterable<Order> orders = c.element().getValue();
            boolean complete = false;
            boolean recurringVarsSet = false;
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.correlationId = correlationId;

            do {
                Order order = orders.iterator().next();
                if (!recurringVarsSet) {
                    orderStatus.setNumber(order.getNumber());
                    orderStatus.setTimestamp(order.getTimestamp());
                    recurringVarsSet = true;
                }
                if (order.getEventName().equals(COMPLETE_EVENT_NAME)) {
                    complete = true;
                    orderStatus.setComplete(complete);
                }
            } while (complete == false && orders.iterator().hasNext());

            if (complete) {
                c.output("Complete");
            } else {
                c.output("NOT complete");
            }

            LOG.info("Order complete: " + complete);
        }
    }

    static class OrderStatusToString extends DoFn<OrderStatus, String> {
        private static final long serialVersionUID = 1L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper(); // todo: to Singleton
            OrderStatus orderStatus = c.element();
            c.output(mapper.writeValueAsString(orderStatus));
        }
    }

    static class ParseOrderFn extends DoFn<String, Order> {
        private static final long serialVersionUID = 3474615155967967054L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper(); // todo: to Singleton
            String json = c.element();
            Order order = null;

            if (isArray(json)) {
                Order[] orders = mapper.readValue(json, Order[].class);
                order = orders[0];
            } else {
                order = mapper.readValue(json, Order.class);
            }

            c.output(order);
        }
    }

    static class SerialiseOrder extends DoFn<KV<String, Order>, String> {

        private static final long serialVersionUID = 1L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper(); // todo: to Singleton
            Order order = c.element().getValue();
            c.output(mapper.writeValueAsString(order));
        }
    }

    static class SerialiseOrderStatus extends DoFn<KV<String, Integer>, String> {
        private static final long serialVersionUID = 1L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            LOG.info("Serialising ...");
            ObjectMapper mapper = new ObjectMapper();
            KV<String, Integer> orderStatus = c.element();
            c.output(mapper.writeValueAsString(orderStatus));
        }
    }

    static class ParseOrderToKVFn extends DoFn<String, KV<String, Order>> {
        private static final long serialVersionUID = 5412656073192665168L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                String json = c.element();
                Order order = null;

                LOG.info("Splitting order to key-value pair ...");

                if (isArray(json)) {
                    Order[] orders = mapper.readValue(json, Order[].class);
                    order = orders[0];
                } else {
                    order = mapper.readValue(json, Order.class);
                }
                LOG.info("Order " + order.getNumber() + " key-valued.");
                c.output(KV.of(order.correlationId, order));
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
    }

    static boolean isArray(String Json) {
        try {
            new JSONObject(Json);
            return false;
        } catch (JSONException ex) {
            try {
                new JSONArray(Json);
                return true;
            } catch (JSONException ex1) {
                throw new JSONException(ex1);
            }
        }
    }
}