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
    long min;
    @Expose
    long avg;
    @Expose
    long max;
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

    public long getMin() {
        return this.min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getAvg() {
        return this.avg;
    }

    public void setAvg(long avg) {
        this.avg = avg;
    }

    public long getMax() {
        return this.max;
    }

    public void setMax(long max) {
        this.max = max;
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
            if (orderSummary.getMin() == 0) {
                orderSummary.setMin(currentDiff);
                orderSummary.setMinFirstEventName(previous.getEventName());
                orderSummary.setMinSecondEventName(current.getEventName());
            }
            allDiffs.add(currentDiff);
            if (currentDiff > orderSummary.getMax()) {
                orderSummary.setMax(currentDiff);
                orderSummary.setMaxFirstEventName(previous.getEventName());
                orderSummary.setMaxSecondEventName(current.getEventName());
            } else if (currentDiff < orderSummary.getMin()) {
                orderSummary.setMin(currentDiff);
                orderSummary.setMinFirstEventName(previous.getEventName());
                orderSummary.setMinSecondEventName(current.getEventName());
            }
            if (current.getEventName().equals(orderCompleteIdentifier)) {
                orderSummary.setComplete(true);
            }
            previous = current;
        } while (iterator.hasNext());
        double average = allDiffs.stream().mapToLong(Long::longValue).average().orElse(0);
        orderSummary.setAvg((long) average);
        orderSummary.setLastEventName(current.getEventName());
        return orderSummary;
    }
}