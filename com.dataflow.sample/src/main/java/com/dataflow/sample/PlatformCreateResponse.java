package com.dataflow.sample;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class PlatformCreateResponse implements Serializable {
    private static final long serialVersionUID = -7559687398949269081L;

    @JsonProperty("StatusCode")
    private Integer statusCode;

    @JsonProperty("StatusCode")
    public Integer getStatuscode() {
        return this.statusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatuscode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("ReasonPhrase")
    private String reasonPhrase;

    @JsonProperty("ReasonPhrase")
    public String getReasonphrase() {
        return this.reasonPhrase;
    }

    @JsonProperty("ReasonPhrase")
    public void setReasonphrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    @JsonProperty("ErrorMessage")
    public String getErrormessage() {
        return this.errorMessage;
    }

    @JsonProperty("ErrorMessage")
    public void setErrormessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}