package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The archive Pub/Sub Topic.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface ArchivePipelineOptions extends PipelineOptions {
    @Description("The archive Pub/Sub Topic.")
    String getArchiveTopic();

    void setArchiveTopic(String archiveTopic);
}