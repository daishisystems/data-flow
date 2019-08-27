
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "InputItem", "InputDelivery" })
@DefaultCoder(SerializableCoder.class)
public class OrderChargeInfos implements Serializable {

    @JsonProperty("InputItem")
    private InputItem inputItem;
    @JsonProperty("InputDelivery")
    private InputDelivery inputDelivery;
    private final static long serialVersionUID = -6502533198626669889L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderChargeInfos() {
    }

    /**
     * 
     * @param inputDelivery
     * @param inputItem
     */
    public OrderChargeInfos(InputItem inputItem, InputDelivery inputDelivery) {
        super();
        this.inputItem = inputItem;
        this.inputDelivery = inputDelivery;
    }

    @JsonProperty("InputItem")
    public InputItem getInputItem() {
        return inputItem;
    }

    @JsonProperty("InputItem")
    public void setInputItem(InputItem inputItem) {
        this.inputItem = inputItem;
    }

    @JsonProperty("InputDelivery")
    public InputDelivery getInputDelivery() {
        return inputDelivery;
    }

    @JsonProperty("InputDelivery")
    public void setInputDelivery(InputDelivery inputDelivery) {
        this.inputDelivery = inputDelivery;
    }
}
