package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class PlatformCreate implements Serializable {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("Response")
    private PlatformCreateResponse response;
    private final static long serialVersionUID = -3269839451027682757L;

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Response")
    public PlatformCreateResponse getResponse() {
        return response;
    }

    @JsonProperty("Response")
    public void setResponse(PlatformCreateResponse response) {
        this.response = response;
    }
}