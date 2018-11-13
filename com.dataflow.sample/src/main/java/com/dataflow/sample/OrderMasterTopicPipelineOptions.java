package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The Order Master Pub/Sub Topic.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface OrderMasterTopicPipelineOptions extends PipelineOptions {
    @Description("The Order Master Pub/Sub Topic.")
    String getOrderMasterTopic();

    void setOrderMasterTopic(String orderMasterTopic);
}