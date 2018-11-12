
package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Title", "Description", "Price", "DiscountAmount", "BeforeDiscount", "DiscountPercentage" })
@DefaultCoder(SerializableCoder.class)
public class ShopperCurrencyProductPriceInfo implements Serializable {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private Price price;
    @JsonProperty("DiscountAmount")
    private DiscountAmount discountAmount;
    @JsonProperty("BeforeDiscount")
    private BeforeDiscount beforeDiscount;
    @JsonProperty("DiscountPercentage")
    private Double discountPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5493994861205368742L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShopperCurrencyProductPriceInfo() {
    }

    /**
     * 
     * @param title
     * @param price
     * @param description
     * @param discountPercentage
     * @param beforeDiscount
     * @param discountAmount
     */
    public ShopperCurrencyProductPriceInfo(String title, String description, Price price, DiscountAmount discountAmount,
            BeforeDiscount beforeDiscount, Double discountPercentage) {
        super();
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountAmount = discountAmount;
        this.beforeDiscount = beforeDiscount;
        this.discountPercentage = discountPercentage;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("DiscountAmount")
    public DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    @JsonProperty("DiscountAmount")
    public void setDiscountAmount(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    @JsonProperty("BeforeDiscount")
    public BeforeDiscount getBeforeDiscount() {
        return beforeDiscount;
    }

    @JsonProperty("BeforeDiscount")
    public void setBeforeDiscount(BeforeDiscount beforeDiscount) {
        this.beforeDiscount = beforeDiscount;
    }

    @JsonProperty("DiscountPercentage")
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    @JsonProperty("DiscountPercentage")
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = Utils.round(discountPercentage);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
