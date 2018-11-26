package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Order implements Serializable {
    @JsonProperty("OrderRef")
    private String orderRef;
    @JsonProperty("OrderNumber")
    private String orderNumber;
    @JsonProperty("TotalPaymentAmount")
    private Double totalPaymentAmount;
    @JsonProperty("CurrencyIso")
    private String currencyIso;
    @JsonProperty("IsProductLaunchOrder")
    private Boolean isProductLaunchOrder;
    @JsonProperty("HasCustomizedProduct")
    private Boolean hasCustomizedProduct;
    @JsonProperty("HasBackOrderedItems")
    private Boolean hasBackOrderedItems;
    @JsonProperty("MaxEstimatedDeliveryDateInDays")
    private Integer maxEstimatedDeliveryDateInDays;
    @JsonProperty("CustomClientCulture")
    private String customClientCulture;
    @JsonProperty("IpAddress")
    private String ipAddress;
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;
    @JsonProperty("BillingAddress")
    private BillingAddress billingAddress;
    @JsonProperty("OrderItems")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    private final static long serialVersionUID = -3518183751690070434L;

    @JsonProperty("OrderRef")
    public String getOrderRef() {
        return orderRef;
    }

    @JsonProperty("OrderRef")
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    @JsonProperty("OrderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    @JsonProperty("OrderNumber")
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @JsonProperty("TotalPaymentAmount")
    public Double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    @JsonProperty("TotalPaymentAmount")
    public void setTotalPaymentAmount(Double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @JsonProperty("CurrencyIso")
    public String getCurrencyIso() {
        return currencyIso;
    }

    @JsonProperty("CurrencyIso")
    public void setCurrencyIso(String currencyIso) {
        this.currencyIso = currencyIso;
    }

    @JsonProperty("IsProductLaunchOrder")
    public Boolean getIsProductLaunchOrder() {
        return isProductLaunchOrder;
    }

    @JsonProperty("IsProductLaunchOrder")
    public void setIsProductLaunchOrder(Boolean isProductLaunchOrder) {
        this.isProductLaunchOrder = isProductLaunchOrder;
    }

    @JsonProperty("HasCustomizedProduct")
    public Boolean getHasCustomizedProduct() {
        return hasCustomizedProduct;
    }

    @JsonProperty("HasCustomizedProduct")
    public void setHasCustomizedProduct(Boolean hasCustomizedProduct) {
        this.hasCustomizedProduct = hasCustomizedProduct;
    }

    @JsonProperty("HasBackOrderedItems")
    public Boolean getHasBackOrderedItems() {
        return hasBackOrderedItems;
    }

    @JsonProperty("HasBackOrderedItems")
    public void setHasBackOrderedItems(Boolean hasBackOrderedItems) {
        this.hasBackOrderedItems = hasBackOrderedItems;
    }

    @JsonProperty("MaxEstimatedDeliveryDateInDays")
    public Integer getMaxEstimatedDeliveryDateInDays() {
        return maxEstimatedDeliveryDateInDays;
    }

    @JsonProperty("MaxEstimatedDeliveryDateInDays")
    public void setMaxEstimatedDeliveryDateInDays(Integer maxEstimatedDeliveryDateInDays) {
        this.maxEstimatedDeliveryDateInDays = maxEstimatedDeliveryDateInDays;
    }

    @JsonProperty("CustomClientCulture")
    public String getCustomClientCulture() {
        return customClientCulture;
    }

    @JsonProperty("CustomClientCulture")
    public void setCustomClientCulture(String customClientCulture) {
        this.customClientCulture = customClientCulture;
    }

    @JsonProperty("IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("IpAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("ShippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("ShippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("BillingAddress")
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    @JsonProperty("BillingAddress")
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonProperty("OrderItems")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @JsonProperty("OrderItems")
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}