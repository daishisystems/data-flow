package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * Payment pipeline options, inc. Topic names, etc.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface PaymentPipelineOptions extends PipelineOptions {
    @Description("The input Pub/Sub Topic.")
    String getInputTopic();

    void setInputTopic(String inputTopic);

    @Description("The dead-letter Pub/Sub Topic.")
    String getDeadLetterTopic();

    void setDeadLetterTopic(String deadLetterTopic);

    @Description("The Payment Master Pub/Sub Topic.")
    String getPaymentMasterTopic();

    void setPaymentMasterTopic(String paymentMasterTopic);

    @Description("The Payment archive Pub/Sub Topic.")
    String getArchiveTopic();

    void setArchiveTopic(String archiveTopic);

    String getPaymentsTableName();

    void setPaymentsTableName(String paymentsTableName);
}