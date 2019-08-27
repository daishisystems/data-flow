package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class RetailerConfirmation implements Serializable {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("Response")
    private RetailerConfirmationResponse response;
    private final static long serialVersionUID = -3269839451027682757L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetailerConfirmation() {
    }

    /**
     * 
     * @param response
     * @param status
     */
    public RetailerConfirmation(String status, RetailerConfirmationResponse response) {
        super();
        this.status = status;
        this.response = response;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Response")
    public RetailerConfirmationResponse getResponse() {
        return response;
    }

    @JsonProperty("Response")
    public void setResponse(RetailerConfirmationResponse response) {
        this.response = response;
    }
}