package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The input Pub/Sub Topic.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface InputTopicPipelineOptions extends PipelineOptions {
    @Description("The input Pub/Sub Topic.")
    String getInputTopic();

    void setInputTopic(String inputTopic);
}