package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class OrderChargeInfos implements Serializable {
    InputItem InputItemObject;
    InputDelivery InputDeliveryObject;

    // Getter Methods

    public InputItem getInputItem() {
        return InputItemObject;
    }

    public InputDelivery getInputDelivery() {
        return InputDeliveryObject;
    }

    // Setter Methods

    public void setInputItem(InputItem InputItemObject) {
        this.InputItemObject = InputItemObject;
    }

    public void setInputDelivery(InputDelivery InputDeliveryObject) {
        this.InputDeliveryObject = InputDeliveryObject;
    }
}