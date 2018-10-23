package com.dataflow.sample;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class OrderDifference implements Serializable {
    @Expose
    Order firstOrder;
    @Expose
    Order secondOrder;
    @Expose
    long createdDifference;

    public Order getFirstOrder() {
        return firstOrder;
    }

    public void setFirstOrder(Order order) {
        this.firstOrder = order;
    }

    public Order getSecondOrder() {
        return secondOrder;
    }

    public void setSecondOrder(Order order) {
        this.secondOrder = order;
    }

    public long getCreatedDifference() {
        return createdDifference;
    }

    public void setCreatedDifference(long createdDifference) {
        this.createdDifference = createdDifference;
    }
}