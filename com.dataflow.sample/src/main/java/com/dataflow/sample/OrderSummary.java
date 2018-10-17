package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.Expose;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class OrderSummary implements Serializable {
    private static final long serialVersionUID = 4849897804088452767L;
    @Expose
    long minTimeDelay;
    @Expose
    long avgTimeDelay;
    @Expose
    long maxTimeDelay;
    @Expose
    String minFirstEventName;
    @Expose
    String minSecondEventName;
    @Expose
    String maxFirstEventName;
    @Expose
    String maxSecondEventName;
    @Expose
    String lastEventName;
    @Expose
    boolean complete;
    @Expose
    String number;
    @Expose
    String correlationId;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCorrelationid() {
        return this.correlationId;
    }

    public void setCorrelationid(String correlationId) {
        this.correlationId = correlationId;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getLastEventName() {
        return this.lastEventName;
    }

    public void setLastEventName(String lastEventName) {
        this.lastEventName = lastEventName;
    }

    public String getMinFirstEventName() {
        return this.minFirstEventName;
    }

    public void setMinFirstEventName(String minFirstEventName) {
        this.minFirstEventName = minFirstEventName;
    }

    public String getMinSecondEventName() {
        return this.minSecondEventName;
    }

    public void setMinSecondEventName(String minSecondEventName) {
        this.minSecondEventName = minSecondEventName;
    }

    public String getMaxfirstEventName() {
        return this.maxFirstEventName;
    }

    public void setMaxFirstEventName(String maxFirstEventName) {
        this.maxFirstEventName = maxFirstEventName;
    }

    public String getMaxSecondEventName() {
        return this.maxSecondEventName;
    }

    public void setMaxSecondEventName(String maxSecondEventName) {
        this.maxSecondEventName = maxSecondEventName;
    }

    public long getMinTimeDelay() {
        return this.minTimeDelay;
    }

    public void setMinTimeDelay(long minTimeDelay) {
        this.minTimeDelay = minTimeDelay;
    }

    public long getAvgTimedelay() {
        return this.avgTimeDelay;
    }

    public void setAvgTimeDelay(long avgTimeDelay) {
        this.avgTimeDelay = avgTimeDelay;
    }

    public long getMaxTimeDelay() {
        return this.maxTimeDelay;
    }

    public void setMaxTimeDelay(long maxTimeDelay) {
        this.maxTimeDelay = maxTimeDelay;
    }

    /**
     * Sorts an iterable collection of orders by created-date.
     * 
     * @param orders orders to sort
     * @return collection of sorted orders
     */
    public static List<Order> sortOrders(Iterator<Order> orders) {
        List<Order> sortedOrders = new ArrayList<>();
        while (orders.hasNext()) {
            sortedOrders.add((Order) orders.next());
        }
        Collections.sort(sortedOrders, (o1, o2) -> new Long(o1.getCreated()).compareTo(new Long((o2.getCreated()))));
        return sortedOrders;
    }

    public static OrderSummary orderSummary(List<Order> orders, String orderCompleteIdentifier) {
        Iterator<Order> iterator = orders.iterator();
        OrderSummary orderSummary = new OrderSummary();
        if (!iterator.hasNext()) {
            return orderSummary;
        }
        Order previous = iterator.next();
        if (!iterator.hasNext()) {
            return orderSummary;
        }
        Order current;
        List<Long> allDiffs = new ArrayList<>();
        do {
            current = iterator.next();
            long currentDiff = current.getCreated() - previous.getCreated();
            if (orderSummary.getMinTimeDelay() == 0) {
                orderSummary.setMinTimeDelay(currentDiff);
                orderSummary.setMinFirstEventName(previous.getEventName());
                orderSummary.setMinSecondEventName(current.getEventName());
            }
            allDiffs.add(currentDiff);
            if (currentDiff > orderSummary.getMaxTimeDelay()) {
                orderSummary.setMaxTimeDelay(currentDiff);
                orderSummary.setMaxFirstEventName(previous.getEventName());
                orderSummary.setMaxSecondEventName(current.getEventName());
            } else if (currentDiff < orderSummary.getMinTimeDelay()) {
                orderSummary.setMinTimeDelay(currentDiff);
                orderSummary.setMinFirstEventName(previous.getEventName());
                orderSummary.setMinSecondEventName(current.getEventName());
            }
            if (current.getEventName().equals(orderCompleteIdentifier)) {
                orderSummary.setComplete(true);
            }
            previous = current;
        } while (iterator.hasNext());
        double average = allDiffs.stream().mapToLong(Long::longValue).average().orElse(0);
        orderSummary.setAvgTimeDelay((long) average);
        orderSummary.setLastEventName(current.getEventName());
        orderSummary.setNumber(current.getNumber());
        orderSummary.setCorrelationid(current.getCorrelationId());
        return orderSummary;
    }
}