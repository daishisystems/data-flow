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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;

import org.apache.beam.repackaged.beam_sdks_java_core.net.bytebuddy.implementation.bind.annotation.Default;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Combine;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Sample;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.Top;
import org.apache.beam.sdk.transforms.Combine.CombineFn;
import org.apache.beam.sdk.transforms.DoFn.ProcessElement;
import org.apache.beam.sdk.transforms.join.CoGbkResult;
import org.apache.beam.sdk.transforms.join.CoGroupByKey;
import org.apache.beam.sdk.transforms.join.KeyedPCollectionTuple;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionView;
import org.apache.beam.sdk.values.TupleTag;
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
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO.Write.CreateDisposition;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO.Write.WriteDisposition;
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

        PCollection<String> pubSubOutput = p.apply("ReadPubSub",
                PubsubIO.readStrings().fromTopic("projects/eshop-bigdata/topics/apache_beam_input_2")
                        .withTimestampAttribute("EventTimestamp"));

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
        PCollection<KV<String, Order>> orders = keyvalues.apply("To Session window",
                Window.<KV<String, Order>>into(Sessions.withGapDuration(Duration.standardSeconds(20))));

        PCollection<KV<String, Iterable<Order>>> groupedOrders = orders.apply("Group Orders", GroupByKey.create());

        PCollection<Order> flattenedOrders = groupedOrders.apply("Flatten Orders", ParDo.of(new FlattenOrdersSimple()));

        PCollection<String> serialisedOrders = flattenedOrders.apply("Serialise Orders",
                ParDo.of(new SerialiseOrderSimple()));

        // PCollection<KV<String, Integer>> orderStatus = orders.apply("Get Order
        // Status",
        // ParDo.of(new ExtractOrderStatus()));

        // PCollection<KV<String, Integer>> totals =
        // orderStatus.apply(Combine.perKey(Sum.ofIntegers()));

        // PCollection<String> orders = window.apply("Serialise Order", ParDo.of(new
        // SerialiseOrder()));

        // PCollection<String> orderStatuses = window.apply(GroupByKey.<String,
        // Order>create()).apply("Get Order Status",
        // ParDo.of(new FlattenOrdersSimple()));

        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("Number").setType("STRING"));
        fields.add(new TableFieldSchema().setName("BrandCode").setType("STRING"));
        fields.add(new TableFieldSchema().setName("EventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("CorrelationId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("Created").setType("TIMESTAMP"));
        fields.add(new TableFieldSchema().setName("Complete").setType("BOOLEAN"));
        TableSchema schema = new TableSchema().setFields(fields);

        flattenedOrders.apply(new OrdersToTableRows())
                .apply(BigQueryIO.writeTableRows().to("eshop-bigdata:datalake.windowed_orders_1").withSchema(schema)
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        serialisedOrders.apply(PubsubIO.writeStrings().to("projects/eshop-bigdata/topics/dataflow-test-out"));

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

    static class FlattenOrders extends DoFn<KV<String, Iterable<Order>>, Order> {
        private static final long serialVersionUID = -180397528519989000L;
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
            Iterable<Order> orders = c.element().getValue();

            boolean sampleSet = false;
            Order sample = null;

            boolean complete = false;
            for (Order order : orders) {
                if (!sampleSet) {
                    sample = order;
                    sampleSet = true;
                }
                if (order.getEventName().equals(COMPLETE_EVENT_NAME)) {
                    complete = true;
                    order.setComplete(complete);
                    c.output(order);
                }
            }
            if (!complete && sampleSet) {
                c.output(sample);
            }
        }
    }

    static class FlattenOrdersSimple extends DoFn<KV<String, Iterable<Order>>, Order> {
        private static final long serialVersionUID = -180397528519989000L;
        String START_EVENT_NAME = "START";
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
            Order currentOrder = null;
            Order outputOrder = null;

            Iterable<Order> orders = c.element().getValue();
            Iterator<Order> iterator = orders.iterator();

            do {
                currentOrder = iterator.next(); // todo: Inner, outer try-catch
                if (currentOrder.getEventName().equals(COMPLETE_EVENT_NAME)) {
                    currentOrder.complete = true;
                    outputOrder = currentOrder;
                } else if (currentOrder.getEventName().equals(START_EVENT_NAME)) { // todo: Handle missing/invalid
                                                                                   // event-names
                    outputOrder = currentOrder;
                } // todo: Handle corner-cases where neither event-name is present
            } while (!currentOrder.complete && iterator.hasNext());

            // todo: Convert the following to a PTransform ...

            Date date = new java.util.Date(outputOrder.getCreated() * 1000L);
            LOG.info("Created: " + outputOrder.getCreated());
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            String formattedDate = sdf.format(date);
            LOG.info("BQ Date: " + formattedDate);
            outputOrder.setBQTimestamp(formattedDate);
            c.output(outputOrder);
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

    static class SerialiseOrderSimple extends DoFn<Order, String> {

        private static final long serialVersionUID = 1L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper(); // todo: to Singleton
            Order order = c.element();
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

    static class FormatAsTableRowFn extends DoFn<Order, TableRow> {
        private static final long serialVersionUID = 1L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();

            tableRow.set("Number", c.element().getNumber());
            tableRow.set("BrandCode", c.element().getBrandCode());
            tableRow.set("EventName", c.element().getEventName());
            tableRow.set("CorrelationId", c.element().getCorrelationId());
            tableRow.set("Created", c.element().getCreated());
            tableRow.set("Complete", c.element().getComplete());

            LOG.info("Timestamp: " + c.element().getBQTimestamp());

            c.output(tableRow);
        }
    }

    static class OrdersToTableRows extends PTransform<PCollection<Order>, PCollection<TableRow>> {

        private static final long serialVersionUID = 1L;

        @Override
        public PCollection<TableRow> expand(PCollection<Order> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatAsTableRowFn()));
            return tableRows;
        }
    }
}