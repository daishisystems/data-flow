package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * Custom pipeline options, inc. Topic names, etc.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface CustomPipelineOptions extends PipelineOptions {
    @Description("The input Pub/Sub Topic.")
    String getInputTopic();

    void setInputTopic(String inputTopic);

    @Description("The dead-letter Pub/Sub Topic.")
    String getDeadLetterTopic();

    void setDeadLetterTopic(String deadLetterTopic);

    @Description("The session window gap duration in seconds.")
    String getSessionWindowGapDuration();

    void setSessionWindowGapDuration(String sessionWindowGapDuration);

    @Description("The Order Summary table.")
    String getOrderSummaryTable();

    void setOrderSummaryTable(String setOrderSummaryTable);

    @Description("The Order Master Pub/Sub Topic.")
    String getOrderMasterTopic();

    void setOrderMasterTopic(String orderMasterTopic);

    @Description("The Order archive Pub/Sub Topic.")
    String getArchiveTopic();

    void setArchiveTopic(String archiveTopic);
}