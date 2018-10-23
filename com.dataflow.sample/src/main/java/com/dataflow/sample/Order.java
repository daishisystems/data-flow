
package com.dataflow.sample;

import java.io.Serializable;
import java.util.Objects;
import com.google.gson.annotations.Expose;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Order implements Serializable {
    private static final long serialVersionUID = -7348367869296778970L;
    @Expose
    String number;
    @Expose
    float value;
    @Expose
    String brandCode;
    @Expose
    String eventName;
    @Expose
    String correlationId;
    @Expose
    long created;
    @Expose
    boolean complete;
    @Expose
    String emailAddress;
    @Expose
    String userAgent;
    @Expose
    String queryString;
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

    public Order() {

    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getBrandCode() {
        return this.brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public long getCreated() {
        return this.created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(number, order.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}