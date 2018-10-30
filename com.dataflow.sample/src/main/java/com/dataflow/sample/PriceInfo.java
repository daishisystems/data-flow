package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class PriceInfo implements Serializable {
    private static final long serialVersionUID = 4278350131058872300L;
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

    @JsonProperty("Price")
    private Double price;

    @JsonProperty("Price")
    public Double getPrice() {
        return this.price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("DiscountAmount")
    private Double discountAmount;

    @JsonProperty("DiscountAmount")
    public Double getDiscountamount() {
        return this.discountAmount;
    }

    @JsonProperty("DiscountAmount")
    public void setDiscountamount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @JsonProperty("BeforeDiscount")
    private Double beforeDiscount;

    @JsonProperty("BeforeDiscount")
    public Double getBeforediscount() {
        return this.beforeDiscount;
    }

    @JsonProperty("BeforeDiscount")
    public void setBeforediscount(Double beforeDiscount) {
        this.beforeDiscount = beforeDiscount;
    }

    @JsonProperty("DiscountPercentage")
    private Double discountPercentage;

    @JsonProperty("DiscountPercentage")
    public Double getDiscountpercentage() {
        return this.discountPercentage;
    }

    @JsonProperty("DiscountPercentage")
    public void setDiscountpercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}