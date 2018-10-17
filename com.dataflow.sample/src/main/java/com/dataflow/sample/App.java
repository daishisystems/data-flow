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
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;
import com.google.privacy.dlp.v2.InfoType;

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

        PCollection<String> pubSubOutput = p.apply("Pulling from Pub/Sub",
                PubsubIO.readStrings().fromTopic("projects/eshop-bigdata/topics/apache_beam_input_2")
                        .withTimestampAttribute("EventTimestamp"));

        PCollection<KV<String, Order>> keyvalues = pubSubOutput.apply("Parsing to KV pairs",
                ParDo.of(new ParseOrderToKVFn()));

        PCollection<KV<String, Order>> orders = keyvalues.apply("Creating session window",
                Window.<KV<String, Order>>into(Sessions.withGapDuration(Duration.standardSeconds(20))));

        PCollection<KV<String, Iterable<Order>>> groupedOrders = orders.apply("Grouping orders", GroupByKey.create());

        PCollection<OrderSummary> orderSummaries = groupedOrders.apply("Creating order summaries",
                ParDo.of(new OrderSummaryFn()));

        PCollection<String> serialisedOrders = orderSummaries.apply("Serialising order summaries",
                ParDo.of(new SerialiseOrderSummaryFn()));

        serialisedOrders.apply("Sending order summaries to Pub/Sub",
                PubsubIO.writeStrings().to("projects/eshop-bigdata/topics/dataflow-test-out"));

        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("Min").setType("INT64"));
        fields.add(new TableFieldSchema().setName("Avg").setType("INT64"));
        fields.add(new TableFieldSchema().setName("Max").setType("INT64"));
        fields.add(new TableFieldSchema().setName("MinFirstEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MaxFirstEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MinSecondEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("MaxSecondEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("LastEventName").setType("STRING"));
        fields.add(new TableFieldSchema().setName("Complete").setType("BOOLEAN"));
        TableSchema schema = new TableSchema().setFields(fields);

        orderSummaries.apply("Writing order summaries to BigQuery", new OrderSummariesToTableRows())
                .apply(BigQueryIO.writeTableRows().to("eshop-bigdata:datalake.order_summary_3").withSchema(schema)
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        p.run().waitUntilFinish();
    }

    // todo: 1. Handle single order events
    // todo: 2. Fix MaxSecondEventName NULL
    // todo: 3. Fix complete calc

    static class ExtractOrderStatus extends DoFn<KV<String, Order>, KV<String, Integer>> {
        private static final long serialVersionUID = 1L;
        String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) {
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
        public void processElement(ProcessContext c) throws Exception {
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

            LOG.info("Email address: " + outputOrder.getEmailAddress());
            List<InfoType> infoTypesList = Collections.emptyList();
            try {
                String maskedEmailAddress = DeIdentification.deIdentifyWithMask(outputOrder.getEmailAddress(),
                        infoTypesList, '#', 0, "eshop-bigdata");
                LOG.info(maskedEmailAddress);
                outputOrder.setEmailAddress(maskedEmailAddress);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
            c.output(outputOrder);
        }
    }

    static class OrderSummaryFn extends DoFn<KV<String, Iterable<Order>>, OrderSummary> {
        private static final long serialVersionUID = -3067528732035106582L;
        final String COMPLETE_EVENT_NAME = "COMPLETE";

        @ProcessElement
        public void processElement(ProcessContext c) throws Exception {
            Iterable<Order> orders = c.element().getValue();
            List<Order> sortedOrders = OrderSummary.sortOrders(orders.iterator());
            OrderSummary orderSummary = OrderSummary.orderSummary(sortedOrders, COMPLETE_EVENT_NAME);
            c.output(orderSummary);
        }
    }

    static class SerialiseOrderSummaryFn extends DoFn<OrderSummary, String> {
        private static final long serialVersionUID = 6888807405086595997L;

        @ProcessElement
        public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper mapper = new ObjectMapper();
            OrderSummary orderSummary = c.element();
            c.output(mapper.writeValueAsString(orderSummary));
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
                Order order = mapper.readValue(json, Order.class);
                c.output(KV.of(order.getCorrelationId(), order));
            } catch (Exception e) {
                LOG.error(e.getMessage());
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
            tableRow.set("EmailAddress", c.element().getEmailAddress());
            tableRow.set("UserAgent", c.element().getUserAgent());
            tableRow.set("QueryString", c.element().getQueryString());

            c.output(tableRow);
        }
    }

    static class FormatOrderSummaryAsTableRowFn extends DoFn<OrderSummary, TableRow> {
        private static final long serialVersionUID = 435139917692986619L;

        @ProcessElement
        public void processElement(ProcessContext c) {
            TableRow tableRow = new TableRow();
            OrderSummary orderSummary = c.element();

            tableRow.set("Min", orderSummary.getMin());
            tableRow.set("Avg", orderSummary.getAvg());
            tableRow.set("Max", orderSummary.getMax());
            tableRow.set("MinFirstEventName", orderSummary.getMinFirstEventName());
            tableRow.set("MinSecondEventName", orderSummary.getMinSecondEventName());
            tableRow.set("MaxFirstEventName", orderSummary.getMaxfirstEventName());
            tableRow.set("MaxSecondEventName", orderSummary.getMaxSecondEventName());
            tableRow.set("LastEventName", orderSummary.getLastEventName());
            tableRow.set("Complete", orderSummary.getComplete());
            c.output(tableRow);
        }
    }

    static class OrderSummariesToTableRows extends PTransform<PCollection<OrderSummary>, PCollection<TableRow>> {

        private static final long serialVersionUID = 1L;

        @Override
        public PCollection<TableRow> expand(PCollection<OrderSummary> input) {
            PCollection<TableRow> tableRows = input.apply(ParDo.of(new FormatOrderSummaryAsTableRowFn()));
            return tableRows;
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