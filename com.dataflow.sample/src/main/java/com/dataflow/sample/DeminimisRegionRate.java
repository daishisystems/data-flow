
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class DeminimisRegionRate implements Serializable {
    @JsonProperty("DutyRate")
    private Double dutyRate;
    @JsonProperty("VatRate")
    private Double vatRate;
    @JsonProperty("FeeRate")
    private Double feeRate;
    private final static long serialVersionUID = 6777888353451384036L;

    @JsonProperty("DutyRate")
    public Object getDutyRate() {
        return dutyRate;
    }

    @JsonProperty("DutyRate")
    public void setDutyRate(Double dutyRate) {
        this.dutyRate = dutyRate;
    }

    @JsonProperty("VatRate")
    public Object getVatRate() {
        return vatRate;
    }

    @JsonProperty("VatRate")
    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    @JsonProperty("FeeRate")
    public Double getFeeRate() {
        return feeRate;
    }

    @JsonProperty("FeeRate")
    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

}
