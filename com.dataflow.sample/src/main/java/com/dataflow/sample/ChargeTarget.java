
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Name", "TargetValue" })
@DefaultCoder(SerializableCoder.class)
public class ChargeTarget implements Serializable {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("TargetValue")
    private TargetValue targetValue;
    private final static long serialVersionUID = 2614436583257061409L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChargeTarget() {
    }

    /**
     * 
     * @param targetValue
     * @param name
     */
    public ChargeTarget(String name, TargetValue targetValue) {
        super();
        this.name = name;
        this.targetValue = targetValue;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("TargetValue")
    public TargetValue getTargetValue() {
        return targetValue;
    }

    @JsonProperty("TargetValue")
    public void setTargetValue(TargetValue targetValue) {
        this.targetValue = targetValue;
    }
}
