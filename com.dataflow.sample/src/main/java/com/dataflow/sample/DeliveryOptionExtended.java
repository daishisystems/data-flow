
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class DeliveryOptionExtended implements Serializable {

    @JsonProperty("DeliveryOption")
    private String deliveryOption;
    @JsonProperty("EstimatedDeliveryDate")
    private String estimatedDeliveryDate;
    @JsonProperty("RetailerCurrencyOveridePriceInfo")
    private RetailerCurrencyOveridePriceInfo retailerCurrencyOveridePriceInfo;
    @JsonProperty("ShopperCurrencyOveridePriceInfo")
    private ShopperCurrencyOveridePriceInfo shopperCurrencyOveridePriceInfo;
    private final static long serialVersionUID = 7878917612146746769L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryOptionExtended() {
    }

    @JsonProperty("DeliveryOption")
    public String getDeliveryOption() {
        return deliveryOption;
    }

    @JsonProperty("DeliveryOption")
    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @JsonProperty("RetailerCurrencyOveridePriceInfo")
    public RetailerCurrencyOveridePriceInfo getRetailerCurrencyOveridePriceInfo() {
        return retailerCurrencyOveridePriceInfo;
    }

    @JsonProperty("RetailerCurrencyOveridePriceInfo")
    public void setRetailerCurrencyOveridePriceInfo(RetailerCurrencyOveridePriceInfo retailerCurrencyOveridePriceInfo) {
        this.retailerCurrencyOveridePriceInfo = retailerCurrencyOveridePriceInfo;
    }

    @JsonProperty("ShopperCurrencyOveridePriceInfo")
    public ShopperCurrencyOveridePriceInfo getShopperCurrencyOveridePriceInfo() {
        return shopperCurrencyOveridePriceInfo;
    }

    @JsonProperty("ShopperCurrencyOveridePriceInfo")
    public void setShopperCurrencyOveridePriceInfo(ShopperCurrencyOveridePriceInfo shopperCurrencyOveridePriceInfo) {
        this.shopperCurrencyOveridePriceInfo = shopperCurrencyOveridePriceInfo;
    }
}
