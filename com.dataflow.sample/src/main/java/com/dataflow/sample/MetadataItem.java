package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Name", "Value" })
@DefaultCoder(SerializableCoder.class)
public class MetadataItem implements Serializable {

    private static final long serialVersionUID = 8132491353935288479L;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private String value;

    @JsonProperty("Value")
    public String getValue() {
        return this.value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("Name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }
}