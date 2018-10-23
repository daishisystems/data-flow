package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class DeliveryOption implements Serializable {
    private float Option;
    private boolean IsExpressDelivery;

    // Getter Methods

    public float getOption() {
        return Option;
    }

    public boolean getIsExpressDelivery() {
        return IsExpressDelivery;
    }

    // Setter Methods

    public void setOption(float Option) {
        this.Option = Option;
    }

    public void setIsExpressDelivery(boolean IsExpressDelivery) {
        this.IsExpressDelivery = IsExpressDelivery;
    }
}