package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class DeminimisRegion implements Serializable {

    @JsonProperty("UpperBoundary")
    private UpperBoundary upperBoundary;
    @JsonProperty("ChargeTypesUnderDeminimis")
    private List<String> chargeTypesUnderDeminimis = new ArrayList<String>();
    @JsonProperty("AboveAllBoundaries")
    private Boolean aboveAllBoundaries;
    @JsonProperty("DeminimisRegionRate")
    private DeminimisRegionRate deminimisRegionRate;
    @JsonProperty("DeminimisRegionRateForDelivery")
    private DeminimisRegionRateForDelivery deminimisRegionRateForDelivery;
    @JsonProperty("FixFee")
    private FixFee fixFee;
    private final static long serialVersionUID = -3637637920968487718L;

    @JsonProperty("UpperBoundary")
    public UpperBoundary getUpperBoundary() {
        return upperBoundary;
    }

    @JsonProperty("UpperBoundary")
    public void setUpperBoundary(UpperBoundary upperBoundary) {
        this.upperBoundary = upperBoundary;
    }

    @JsonProperty("ChargeTypesUnderDeminimis")
    public List<String> getChargeTypesUnderDeminimis() {
        return chargeTypesUnderDeminimis;
    }

    @JsonProperty("ChargeTypesUnderDeminimis")
    public void setChargeTypesUnderDeminimis(List<String> chargeTypesUnderDeminimis) {
        this.chargeTypesUnderDeminimis = chargeTypesUnderDeminimis;
    }

    @JsonProperty("AboveAllBoundaries")
    public Boolean getAboveAllBoundaries() {
        return aboveAllBoundaries;
    }

    @JsonProperty("AboveAllBoundaries")
    public void setAboveAllBoundaries(Boolean aboveAllBoundaries) {
        this.aboveAllBoundaries = aboveAllBoundaries;
    }

    @JsonProperty("DeminimisRegionRate")
    public DeminimisRegionRate getDeminimisRegionRate() {
        return deminimisRegionRate;
    }

    @JsonProperty("DeminimisRegionRate")
    public void setDeminimisRegionRate(DeminimisRegionRate deminimisRegionRate) {
        this.deminimisRegionRate = deminimisRegionRate;
    }

    @JsonProperty("DeminimisRegionRateForDelivery")
    public DeminimisRegionRateForDelivery getDeminimisRegionRateForDelivery() {
        return deminimisRegionRateForDelivery;
    }

    @JsonProperty("DeminimisRegionRateForDelivery")
    public void setDeminimisRegionRateForDelivery(DeminimisRegionRateForDelivery deminimisRegionRateForDelivery) {
        this.deminimisRegionRateForDelivery = deminimisRegionRateForDelivery;
    }

    @JsonProperty("FixFee")
    public FixFee getFixFee() {
        return fixFee;
    }

    @JsonProperty("FixFee")
    public void setFixFee(FixFee fixFee) {
        this.fixFee = fixFee;
    }

}
