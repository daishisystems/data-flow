
package com.dataflow.sample;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = -4067384396900205278L;
    @Expose
    String correlationId;
    @Expose
    String number;
    @Expose
    boolean complete;
    @Expose
    long timestamp;

    public OrderStatus() {

    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}