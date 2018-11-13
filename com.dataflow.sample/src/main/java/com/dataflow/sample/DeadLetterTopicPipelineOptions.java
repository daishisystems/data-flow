package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The dead-letter Pub/Sub Topic.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface DeadLetterTopicPipelineOptions extends PipelineOptions {
    @Description("The dead-letter Pub/Sub Topic.")
    String getDeadLetterTopic();

    void setDeadLetterTopic(String deadLetterTopic);
}