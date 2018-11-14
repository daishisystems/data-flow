package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

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
    String startdate;
    @Expose
    String enddate;
    @Expose
    double orderValue;
    @Expose
    String userAgent;
    @Expose
    long totalTime;
    @Expose
    String country;
    @Expose
    int unitsPerOrder;
    @JsonProperty("BrandCode")
    String brandCode;

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

    public double getOrderValue() {
        return this.orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public String getEnddate() {
        return this.enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String startDate) {
        this.startdate = startDate;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String correlationId) {
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

    @JsonProperty("BrandCode")
    public String getBrandCode() {
        return this.brandCode;
    }

    @JsonProperty("BrandCode")
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof OrderSummary))
            return false;
        if (obj == this)
            return true;

        OrderSummary other = (OrderSummary) obj;
        return this.number.equals(other.getNumber()) && this.correlationId.equals(other.getCorrelationId())
                && this.startdate.equals(other.getStartdate()) && this.enddate.equals(other.getEnddate());
    }

    /**
     * Sorts an iterable collection of orders by created-date.
     * 
     * @param orders orders to sort
     * @return collection of sorted orders
     */
    public static List<MasterOrder> sortOrders(Iterable<MasterOrder> orders) {
        List<MasterOrder> sortedOrders = new ArrayList<>();
        Iterator<MasterOrder> iterator = orders.iterator();
        while (iterator.hasNext()) {
            sortedOrders.add((MasterOrder) iterator.next());
        }
        Collections.sort(sortedOrders, (o1, o2) -> new Long(o1.getCreated()).compareTo(new Long((o2.getCreated()))));
        return sortedOrders;
    }

    // FIXME: Group and sort multiple orders per session
    public static OrderSummary orderSummary(List<MasterOrder> orders, String orderCompleteIdentifier) {
        Iterator<MasterOrder> iterator = orders.iterator();
        OrderSummary orderSummary = new OrderSummary();
        if (!iterator.hasNext()) {
            return orderSummary; // FIXME: Check for null, empty
        }
        MasterOrder previous = iterator.next();
        long startTime = previous.getCreated();
        orderSummary.setStartdate(new DateTime(previous.getCreated()).withZone(DateTimeZone.UTC).toString());
        if (!iterator.hasNext()) {
            orderSummary.setLastEventName(previous.getEventName());
            orderSummary.setNumber(previous.getOrderCode());
            orderSummary.setCorrelationId(previous.getCorrelationId());
            orderSummary.setEnddate(new DateTime(previous.getCreated()).withZone(DateTimeZone.UTC).toString());
            orderSummary.setUserAgent(previous.getUserAgent());
            Double orderValue = calcOrderValue(previous);
            orderSummary.setOrderValue(orderValue);
            Integer numOrderArticles = calcNumOrderArticles(previous);
            orderSummary.setUnitsPerOrder(numOrderArticles);
            long endTime = previous.getCreated();
            long totalTime = endTime - startTime;
            orderSummary.setTotalTime(totalTime);
            orderSummary.setCountry(previous.getDeliveryCountryIso());
            orderSummary.setBrandCode(previous.getBrandCode());
            return orderSummary;
        }
        MasterOrder current;
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
        orderSummary.setNumber(current.getOrderCode());
        orderSummary.setCorrelationId(current.getCorrelationId());
        orderSummary.setEnddate(new DateTime(current.getCreated()).withZone(DateTimeZone.UTC).toString());
        orderSummary.setUserAgent(current.getUserAgent());
        Double orderValue = calcOrderValue(current);
        orderSummary.setOrderValue(orderValue);
        Integer numOrderArticles = calcNumOrderArticles(current);
        orderSummary.setUnitsPerOrder(numOrderArticles);
        long endTime = current.getCreated();
        long totalTime = endTime - startTime;
        orderSummary.setTotalTime(totalTime);
        orderSummary.setCountry(current.getDeliveryCountryIso());
        orderSummary.setBrandCode(previous.getBrandCode());

        return orderSummary;
    }

    public static Boolean orderIsComplete(List<MasterOrder> orders, String orderCompleteEventName) {
        if (orders == null || orders.isEmpty()) {
            return false;
        }
        MasterOrder lastOrder = orders.get(orders.size() - 1);
        return lastOrder.getEventName().equals(orderCompleteEventName);
    }

    private static Double calcOrderValue(MasterOrder masterOrder) {
        Double deliveryCharge = 0d;

        for (OrderItem orderItem : masterOrder.getOrderItems()) {
            for (OrderArticle orderArticle : orderItem.getOrderArticles()) {
                for (Charge charge : orderArticle.getCharges()) {
                    String chargeType = charge.getName();
                    if (chargeType.equals("Delivery") || chargeType.equals("DeliveryDuties")
                            || chargeType.equals("DeliveryTaxes") || chargeType.equals("DeliveryTaxOnDuties")
                            || chargeType.equals("DeliveryTaxOnFees") || chargeType.equals("DeliveryFees")
                            || chargeType.equals("DeliveryFixedFee")) {
                        deliveryCharge += charge.getExactValue().getValue();
                    }
                }
            }
        }

        Double merchandiseCharge = 0d;

        for (OrderItem orderItem : masterOrder.getOrderItems()) {
            for (OrderArticle orderArticle : orderItem.getOrderArticles()) {
                for (Charge charge : orderArticle.getCharges()) {
                    String chargeType = charge.getName();
                    if (chargeType.equals("Items") || chargeType.equals("ItemDuties") || chargeType.equals("ItemTaxes")
                            || chargeType.equals("ItemTaxOnDuties") || chargeType.equals("ItemTaxOnFees")
                            || chargeType.equals("ItemFees") || chargeType.equals("ItemFixedFee")) {
                        merchandiseCharge += charge.getExactValue().getValue();
                    }
                }
            }
        }

        double orderValue = deliveryCharge + merchandiseCharge;
        return Math.round(orderValue * 100.0) / 100.0;
    }

    private static int calcNumOrderArticles(MasterOrder masterOrder) {
        Integer numOrderArticles = 0;
        for (OrderItem orderItem : masterOrder.getOrderItems()) {
            numOrderArticles += orderItem.getQuantity();
        }
        return numOrderArticles;
    }
}