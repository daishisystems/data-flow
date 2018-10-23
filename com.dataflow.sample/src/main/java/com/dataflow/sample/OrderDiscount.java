
package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Title", "Description", "RetailerCurrencyOrderDiscountAmount",
        "ShopperCurrencyOrderDiscountAmount" })
public class OrderDiscount implements Serializable {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("RetailerCurrencyOrderDiscountAmount")
    private RetailerCurrencyOrderDiscountAmount retailerCurrencyOrderDiscountAmount;
    @JsonProperty("ShopperCurrencyOrderDiscountAmount")
    private ShopperCurrencyOrderDiscountAmount shopperCurrencyOrderDiscountAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4941659762032320877L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderDiscount() {
    }

    /**
     * 
     * @param title
     * @param description
     * @param shopperCurrencyOrderDiscountAmount
     * @param retailerCurrencyOrderDiscountAmount
     */
    public OrderDiscount(String title, String description,
            RetailerCurrencyOrderDiscountAmount retailerCurrencyOrderDiscountAmount,
            ShopperCurrencyOrderDiscountAmount shopperCurrencyOrderDiscountAmount) {
        super();
        this.title = title;
        this.description = description;
        this.retailerCurrencyOrderDiscountAmount = retailerCurrencyOrderDiscountAmount;
        this.shopperCurrencyOrderDiscountAmount = shopperCurrencyOrderDiscountAmount;
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

    @JsonProperty("RetailerCurrencyOrderDiscountAmount")
    public RetailerCurrencyOrderDiscountAmount getRetailerCurrencyOrderDiscountAmount() {
        return retailerCurrencyOrderDiscountAmount;
    }

    @JsonProperty("RetailerCurrencyOrderDiscountAmount")
    public void setRetailerCurrencyOrderDiscountAmount(
            RetailerCurrencyOrderDiscountAmount retailerCurrencyOrderDiscountAmount) {
        this.retailerCurrencyOrderDiscountAmount = retailerCurrencyOrderDiscountAmount;
    }

    @JsonProperty("ShopperCurrencyOrderDiscountAmount")
    public ShopperCurrencyOrderDiscountAmount getShopperCurrencyOrderDiscountAmount() {
        return shopperCurrencyOrderDiscountAmount;
    }

    @JsonProperty("ShopperCurrencyOrderDiscountAmount")
    public void setShopperCurrencyOrderDiscountAmount(
            ShopperCurrencyOrderDiscountAmount shopperCurrencyOrderDiscountAmount) {
        this.shopperCurrencyOrderDiscountAmount = shopperCurrencyOrderDiscountAmount;
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
