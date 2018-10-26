package com.dataflow.sample;

import java.io.Serializable;
import java.util.List;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class MasterOrderMeta implements Serializable {
    private static final long serialVersionUID = -60216768741032084L;

    private boolean complete;
    private List<MasterOrder> masterOrders;

    public List<MasterOrder> getMasterOrders() {
        return this.masterOrders;
    }

    public void setMasterOrders(List<MasterOrder> masterOrders) {
        this.masterOrders = masterOrders;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}