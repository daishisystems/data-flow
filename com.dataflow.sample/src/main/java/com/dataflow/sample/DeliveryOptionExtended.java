
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @JsonProperty("MetadataItems")
    private List<MetadataItem> metadataItems = new ArrayList<MetadataItem>();
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

    @JsonProperty("MetadataItems")
    public List<MetadataItem> getMetadataItems() {
        return metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataItems(List<MetadataItem> metadataItems) {
        if (metadataItems != null) {
            this.metadataItems = metadataItems; // FIXME Prevent NULL for all arrays, if this works ...
        }
    }
}
