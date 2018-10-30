package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.DateTime;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class GdprAcceptance implements Serializable {

    private static final long serialVersionUID = -3427710201044437503L;

    @JsonProperty("Accepted")
    boolean accepted;
    @JsonProperty("Date")
    DateTime date;

    @JsonProperty("Accepted")
    public boolean getAccepted() {
        return this.accepted;
    }

    @JsonProperty("Accepted")
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @JsonProperty("Date")
    public DateTime getDate() {
        return this.date;
    }

    @JsonProperty("Date")
    public void setDate(DateTime date) {
        this.date = date;
    }

}