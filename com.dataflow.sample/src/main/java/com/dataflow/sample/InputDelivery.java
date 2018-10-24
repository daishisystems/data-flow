
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

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "IncludesMerchandise", "IncludesMerchandiseDuty", "IncludesMerchandiseTax",
        "IncludesMerchandiseFee", "IncludesMerchandiseFixedFee", "IncludesDeliveryItem", "IncludesDeliveryDuty",
        "IncludesDeliveryTax", "IncludesDeliveryFee", "IncludesDeliveryFixedFee", "IsMerchandiseItemPrice",
        "IsMerchandiseAllInclusivePrice", "IsDeliveryItemPrice" })
@DefaultCoder(SerializableCoder.class)
public class InputDelivery implements Serializable {

    @JsonProperty("IncludesMerchandise")
    private Boolean includesMerchandise;
    @JsonProperty("IncludesMerchandiseDuty")
    private Boolean includesMerchandiseDuty;
    @JsonProperty("IncludesMerchandiseTax")
    private Boolean includesMerchandiseTax;
    @JsonProperty("IncludesMerchandiseFee")
    private Boolean includesMerchandiseFee;
    @JsonProperty("IncludesMerchandiseFixedFee")
    private Boolean includesMerchandiseFixedFee;
    @JsonProperty("IncludesDeliveryItem")
    private Boolean includesDeliveryItem;
    @JsonProperty("IncludesDeliveryDuty")
    private Boolean includesDeliveryDuty;
    @JsonProperty("IncludesDeliveryTax")
    private Boolean includesDeliveryTax;
    @JsonProperty("IncludesDeliveryFee")
    private Boolean includesDeliveryFee;
    @JsonProperty("IncludesDeliveryFixedFee")
    private Boolean includesDeliveryFixedFee;
    @JsonProperty("IsMerchandiseItemPrice")
    private Boolean isMerchandiseItemPrice;
    @JsonProperty("IsMerchandiseAllInclusivePrice")
    private Boolean isMerchandiseAllInclusivePrice;
    @JsonProperty("IsDeliveryItemPrice")
    private Boolean isDeliveryItemPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -845251777302748389L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InputDelivery() {
    }

    /**
     * 
     * @param includesMerchandiseTax
     * @param includesDeliveryFixedFee
     * @param includesMerchandise
     * @param isMerchandiseAllInclusivePrice
     * @param includesMerchandiseFee
     * @param isDeliveryItemPrice
     * @param includesDeliveryDuty
     * @param includesMerchandiseFixedFee
     * @param isMerchandiseItemPrice
     * @param includesDeliveryItem
     * @param includesMerchandiseDuty
     * @param includesDeliveryFee
     * @param includesDeliveryTax
     */
    public InputDelivery(Boolean includesMerchandise, Boolean includesMerchandiseDuty, Boolean includesMerchandiseTax,
            Boolean includesMerchandiseFee, Boolean includesMerchandiseFixedFee, Boolean includesDeliveryItem,
            Boolean includesDeliveryDuty, Boolean includesDeliveryTax, Boolean includesDeliveryFee,
            Boolean includesDeliveryFixedFee, Boolean isMerchandiseItemPrice, Boolean isMerchandiseAllInclusivePrice,
            Boolean isDeliveryItemPrice) {
        super();
        this.includesMerchandise = includesMerchandise;
        this.includesMerchandiseDuty = includesMerchandiseDuty;
        this.includesMerchandiseTax = includesMerchandiseTax;
        this.includesMerchandiseFee = includesMerchandiseFee;
        this.includesMerchandiseFixedFee = includesMerchandiseFixedFee;
        this.includesDeliveryItem = includesDeliveryItem;
        this.includesDeliveryDuty = includesDeliveryDuty;
        this.includesDeliveryTax = includesDeliveryTax;
        this.includesDeliveryFee = includesDeliveryFee;
        this.includesDeliveryFixedFee = includesDeliveryFixedFee;
        this.isMerchandiseItemPrice = isMerchandiseItemPrice;
        this.isMerchandiseAllInclusivePrice = isMerchandiseAllInclusivePrice;
        this.isDeliveryItemPrice = isDeliveryItemPrice;
    }

    @JsonProperty("IncludesMerchandise")
    public Boolean getIncludesMerchandise() {
        return includesMerchandise;
    }

    @JsonProperty("IncludesMerchandise")
    public void setIncludesMerchandise(Boolean includesMerchandise) {
        this.includesMerchandise = includesMerchandise;
    }

    @JsonProperty("IncludesMerchandiseDuty")
    public Boolean getIncludesMerchandiseDuty() {
        return includesMerchandiseDuty;
    }

    @JsonProperty("IncludesMerchandiseDuty")
    public void setIncludesMerchandiseDuty(Boolean includesMerchandiseDuty) {
        this.includesMerchandiseDuty = includesMerchandiseDuty;
    }

    @JsonProperty("IncludesMerchandiseTax")
    public Boolean getIncludesMerchandiseTax() {
        return includesMerchandiseTax;
    }

    @JsonProperty("IncludesMerchandiseTax")
    public void setIncludesMerchandiseTax(Boolean includesMerchandiseTax) {
        this.includesMerchandiseTax = includesMerchandiseTax;
    }

    @JsonProperty("IncludesMerchandiseFee")
    public Boolean getIncludesMerchandiseFee() {
        return includesMerchandiseFee;
    }

    @JsonProperty("IncludesMerchandiseFee")
    public void setIncludesMerchandiseFee(Boolean includesMerchandiseFee) {
        this.includesMerchandiseFee = includesMerchandiseFee;
    }

    @JsonProperty("IncludesMerchandiseFixedFee")
    public Boolean getIncludesMerchandiseFixedFee() {
        return includesMerchandiseFixedFee;
    }

    @JsonProperty("IncludesMerchandiseFixedFee")
    public void setIncludesMerchandiseFixedFee(Boolean includesMerchandiseFixedFee) {
        this.includesMerchandiseFixedFee = includesMerchandiseFixedFee;
    }

    @JsonProperty("IncludesDeliveryItem")
    public Boolean getIncludesDeliveryItem() {
        return includesDeliveryItem;
    }

    @JsonProperty("IncludesDeliveryItem")
    public void setIncludesDeliveryItem(Boolean includesDeliveryItem) {
        this.includesDeliveryItem = includesDeliveryItem;
    }

    @JsonProperty("IncludesDeliveryDuty")
    public Boolean getIncludesDeliveryDuty() {
        return includesDeliveryDuty;
    }

    @JsonProperty("IncludesDeliveryDuty")
    public void setIncludesDeliveryDuty(Boolean includesDeliveryDuty) {
        this.includesDeliveryDuty = includesDeliveryDuty;
    }

    @JsonProperty("IncludesDeliveryTax")
    public Boolean getIncludesDeliveryTax() {
        return includesDeliveryTax;
    }

    @JsonProperty("IncludesDeliveryTax")
    public void setIncludesDeliveryTax(Boolean includesDeliveryTax) {
        this.includesDeliveryTax = includesDeliveryTax;
    }

    @JsonProperty("IncludesDeliveryFee")
    public Boolean getIncludesDeliveryFee() {
        return includesDeliveryFee;
    }

    @JsonProperty("IncludesDeliveryFee")
    public void setIncludesDeliveryFee(Boolean includesDeliveryFee) {
        this.includesDeliveryFee = includesDeliveryFee;
    }

    @JsonProperty("IncludesDeliveryFixedFee")
    public Boolean getIncludesDeliveryFixedFee() {
        return includesDeliveryFixedFee;
    }

    @JsonProperty("IncludesDeliveryFixedFee")
    public void setIncludesDeliveryFixedFee(Boolean includesDeliveryFixedFee) {
        this.includesDeliveryFixedFee = includesDeliveryFixedFee;
    }

    @JsonProperty("IsMerchandiseItemPrice")
    public Boolean getIsMerchandiseItemPrice() {
        return isMerchandiseItemPrice;
    }

    @JsonProperty("IsMerchandiseItemPrice")
    public void setIsMerchandiseItemPrice(Boolean isMerchandiseItemPrice) {
        this.isMerchandiseItemPrice = isMerchandiseItemPrice;
    }

    @JsonProperty("IsMerchandiseAllInclusivePrice")
    public Boolean getIsMerchandiseAllInclusivePrice() {
        return isMerchandiseAllInclusivePrice;
    }

    @JsonProperty("IsMerchandiseAllInclusivePrice")
    public void setIsMerchandiseAllInclusivePrice(Boolean isMerchandiseAllInclusivePrice) {
        this.isMerchandiseAllInclusivePrice = isMerchandiseAllInclusivePrice;
    }

    @JsonProperty("IsDeliveryItemPrice")
    public Boolean getIsDeliveryItemPrice() {
        return isDeliveryItemPrice;
    }

    @JsonProperty("IsDeliveryItemPrice")
    public void setIsDeliveryItemPrice(Boolean isDeliveryItemPrice) {
        this.isDeliveryItemPrice = isDeliveryItemPrice;
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
