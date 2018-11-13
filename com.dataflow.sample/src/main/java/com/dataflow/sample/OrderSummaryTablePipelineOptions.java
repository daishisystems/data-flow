package com.dataflow.sample;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The Order Summary table.
 * 
 * @version 1.0
 * 
 * @author Paul Mooney
 */
public interface OrderSummaryTablePipelineOptions extends PipelineOptions {
    @Description("The Order Summary table.")
    String getOrderSummaryTable();

    void setOrderSummaryTable(String setOrderSummaryTable);
}