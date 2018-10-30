package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.joda.time.DateTime;

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
    private DateTime estimatedDeliveryDate; // todo: NULLABLE

    @JsonProperty("EstimatedDeliveryDate")
    public DateTime getEstimateddeliverydate() {
        return this.estimatedDeliveryDate;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public void setEstimateddeliverydate(DateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    private PriceInfo retailerCurrencyDeliveryOptionPriceInfo;

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    public PriceInfo getRetailercurrencydeliveryoptionpriceinfo() {
        return this.retailerCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("RetailerCurrencyDeliveryOptionPriceInfo")
    public void setRetailercurrencydeliveryoptionpriceinfo(PriceInfo retailerCurrencyDeliveryOptionPriceInfo) {
        this.retailerCurrencyDeliveryOptionPriceInfo = retailerCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    private PriceInfo shopperCurrencyDeliveryOptionPriceInfo;

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    public PriceInfo getShoppercurrencydeliveryoptionpriceinfo() {
        return this.shopperCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("ShopperCurrencyDeliveryOptionPriceInfo")
    public void setShoppercurrencydeliveryoptionpriceinfo(PriceInfo shopperCurrencyDeliveryOptionPriceInfo) {
        this.shopperCurrencyDeliveryOptionPriceInfo = shopperCurrencyDeliveryOptionPriceInfo;
    }

    @JsonProperty("MetadataItems")
    private List<MetadataItem> metadataItems = new ArrayList<MetadataItem>();

    @JsonProperty("MetadataItems")
    public List<MetadataItem> getMetadataitems() {
        return this.metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataitems(List<MetadataItem> metadataItems) {
        this.metadataItems = metadataItems;
    }
}