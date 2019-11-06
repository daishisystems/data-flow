package com.dataflow.sample;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "orderRef", "orderNumber", "totalPaymentAmount", "currencyIso", "customClientCulture",
        "ipAddress", "paymentShippingAddress", "paymentBillingAddress", "orderItems" })
public class PaymentOrder implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("orderRef")
    private String orderRef;
    @JsonProperty("orderNumber")
    private String orderNumber;
    @JsonProperty("totalPaymentAmount")
    private int totalPaymentAmount;
    @JsonProperty("currencyIso")
    private String currencyIso;
    @JsonProperty("customClientCulture")
    private String customClientCulture;
    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("paymentShippingAddress")
    private PaymentShippingAddress paymentShippingAddress;
    @JsonProperty("paymentBillingAddress")
    private PaymentBillingAddress paymentBillingAddress;
    @JsonProperty("orderItems")
    private List<PaymentOrderItem> orderItems = null;
    @JsonProperty("created")
    private Long created;

    @JsonProperty("created")
    public Long getCreated() {
        return this.created;
    }

    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }

    private final static long serialVersionUID = 7787293727188329470L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("orderRef")
    public String getOrderRef() {
        return orderRef;
    }

    @JsonProperty("orderRef")
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    @JsonProperty("orderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    @JsonProperty("orderNumber")
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @JsonProperty("totalPaymentAmount")
    public int getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    @JsonProperty("totalPaymentAmount")
    public void setTotalPaymentAmount(int totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @JsonProperty("currencyIso")
    public String getCurrencyIso() {
        return currencyIso;
    }

    @JsonProperty("currencyIso")
    public void setCurrencyIso(String currencyIso) {
        this.currencyIso = currencyIso;
    }

    @JsonProperty("customClientCulture")
    public String getCustomClientCulture() {
        return customClientCulture;
    }

    @JsonProperty("customClientCulture")
    public void setCustomClientCulture(String customClientCulture) {
        this.customClientCulture = customClientCulture;
    }

    @JsonProperty("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("paymentShippingAddress")
    public PaymentShippingAddress getPaymentShippingAddress() {
        return paymentShippingAddress;
    }

    @JsonProperty("paymentShippingAddress")
    public void setPaymentShippingAddress(PaymentShippingAddress paymentShippingAddress) {
        this.paymentShippingAddress = paymentShippingAddress;
    }

    @JsonProperty("paymentBillingAddress")
    public PaymentBillingAddress getPaymentBillingAddress() {
        return paymentBillingAddress;
    }

    @JsonProperty("paymentBillingAddress")
    public void setPaymentBillingAddress(PaymentBillingAddress paymentBillingAddress) {
        this.paymentBillingAddress = paymentBillingAddress;
    }

    @JsonProperty("orderItems")
    public List<PaymentOrderItem> getOrderItems() { // fixme: Change to PaymentOrderItem
        return orderItems;
    }

    @JsonProperty("orderItems")
    public void setOrderItems(List<PaymentOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("orderRef", orderRef)
                .append("orderNumber", orderNumber).append("totalPaymentAmount", totalPaymentAmount)
                .append("currencyIso", currencyIso).append("customClientCulture", customClientCulture)
                .append("ipAddress", ipAddress).append("paymentShippingAddress", paymentShippingAddress)
                .append("paymentBillingAddress", paymentBillingAddress).append("orderItems", orderItems).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(customClientCulture).append(currencyIso).append(orderNumber)
                .append(totalPaymentAmount).append(orderRef).append(paymentBillingAddress).append(orderItems)
                .append(paymentShippingAddress).append(ipAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentOrder) == false) {
            return false;
        }
        PaymentOrder rhs = ((PaymentOrder) other);
        return new EqualsBuilder().append(id, rhs.id).append(customClientCulture, rhs.customClientCulture)
                .append(currencyIso, rhs.currencyIso).append(orderNumber, rhs.orderNumber)
                .append(totalPaymentAmount, rhs.totalPaymentAmount).append(orderRef, rhs.orderRef)
                .append(paymentBillingAddress, rhs.paymentBillingAddress).append(orderItems, rhs.orderItems)
                .append(paymentShippingAddress, rhs.paymentShippingAddress).append(ipAddress, rhs.ipAddress).isEquals();
    }

}
