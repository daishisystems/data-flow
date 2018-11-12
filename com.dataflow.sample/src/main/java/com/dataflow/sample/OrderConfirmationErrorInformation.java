package com.dataflow.sample;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class OrderConfirmationErrorInformation implements Serializable {
    private static final long serialVersionUID = -4512471942237891616L;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Message")
    public String getMessage() {
        return this.message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }
}