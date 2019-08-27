
package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Name", "ExactValue" })
@DefaultCoder(SerializableCoder.class)
public class Charge implements Serializable {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("ExactValue")
    private ExactValue exactValue;
    private final static long serialVersionUID = 353034813858604939L;
    @JsonProperty("IsCalculatedCharge")
    @JsonIgnore
    private Boolean isCalculatedCharge;

    @JsonProperty("IsCalculatedCharge")
    @JsonIgnore
    public Boolean getIsCalculatedCharge() {
        return this.isCalculatedCharge;
    }

    @JsonProperty("IsCalculatedCharge")
    @JsonIgnore
    public void isIsCalculatedCharge(Boolean isCalculatedCharge) {
        this.isCalculatedCharge = isCalculatedCharge;
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Charge() {
    }

    /**
     * 
     * @param name
     * @param exactValue
     */
    public Charge(String name, ExactValue exactValue) {
        super();
        this.name = name;
        this.exactValue = exactValue;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ExactValue")
    public ExactValue getExactValue() {
        return exactValue;
    }

    @JsonProperty("ExactValue")
    public void setExactValue(ExactValue exactValue) {
        this.exactValue = exactValue;
    }    
}
