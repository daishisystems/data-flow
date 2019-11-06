package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class RetailerDeliveryOption implements Serializable {
    private static final long serialVersionUID = 4922788747114672369L;
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Title")
    public String getTitle() {
        return this.title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Description")
    public String getDescription() {
        return this.description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("EstimatedDeliveryDate")
    private String estimatedDeliveryDate;

    @JsonProperty("EstimatedDeliveryDate")
    public String getEstimateddeliverydate() {
        return this.estimatedDeliveryDate;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public void setEstimateddeliverydate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    private RetailerCurrencyDeliveryOptionPriceInfo retailerCurrencyDeliveryOptionPriceInfo;

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    public RetailerCurrencyDeliveryOptionPriceInfo getRetailercurrencydeliveryoptionpriceinfo() {
        return this.retailerCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    public void setRetailercurrencydeliveryoptionpriceinfo(
            RetailerCurrencyDeliveryOptionPriceInfo retailerCurrencyDeliveryOptionPriceInfo) {
        this.retailerCurrencyDeliveryOptionPriceInfo = retailerCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    private RetailerCurrencyDeliveryOptionPriceInfo shopperCurrencyDeliveryOptionPriceInfo;

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    public RetailerCurrencyDeliveryOptionPriceInfo getShoppercurrencydeliveryoptionpriceinfo() {
        return this.shopperCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    public void setShoppercurrencydeliveryoptionpriceinfo(
            RetailerCurrencyDeliveryOptionPriceInfo shopperCurrencyDeliveryOptionPriceInfo) {
        this.shopperCurrencyDeliveryOptionPriceInfo = shopperCurrencyDeliveryOptionPriceInfo;
    }
}