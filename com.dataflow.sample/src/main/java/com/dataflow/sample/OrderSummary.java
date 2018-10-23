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
    @Expose
    long startdate;
    @Expose
    long enddate;
    @Expose
    float orderValue;
    @Expose
    String userAgent;
    @Expose
    long totalTime;
    @Expose
    String country;
    @Expose
    int unitsPerOrder;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUnitsPerOrder() {
        return this.unitsPerOrder;
    }

    public void setUnitsPerOrder(int unitsPerOrder) {
        this.unitsPerOrder = unitsPerOrder;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public float getOrderValue() {
        return this.orderValue;
    }

    public void setOrderValue(float orderValue) {
        this.orderValue = orderValue;
    }

    public long getEnddate() {
        return this.enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    public long getStartdate() {
        return this.startdate;
    }

    public void setStartdate(long startDate) {
        this.startdate = startDate;
    }

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
        long startTime = previous.getCreated();
        orderSummary.setStartdate(previous.getCreated());
        if (!iterator.hasNext()) {
            return orderSummary; // todo - process exists here if only 1 entry!!! Return this order ...
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
        orderSummary.setEnddate(current.getCreated()); // Order should have a start and endate in DATETIME format
        orderSummary.setUserAgent(current.getUserAgent());
        orderSummary.setOrderValue(current.getValue());
        long endTime = current.getCreated();
        long totalTime = endTime - startTime;
        orderSummary.setTotalTime(totalTime);
        orderSummary.setCountry(current.getCountry());
        orderSummary.setUnitsPerOrder(current.getUnitsPerOrder());
        return orderSummary;
    }
}