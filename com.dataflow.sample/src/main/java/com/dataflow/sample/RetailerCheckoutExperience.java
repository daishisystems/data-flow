
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "RetailerCheckoutExperienceId", "BackToCartUrl", "ContinueShoppingUrl", "MetadataItems" })
@DefaultCoder(SerializableCoder.class)
public class RetailerCheckoutExperience implements Serializable {

    @JsonProperty("RetailerCheckoutExperienceId")
    private String retailerCheckoutExperienceId;
    @JsonProperty("BackToCartUrl")
    private String backToCartUrl;
    @JsonProperty("ContinueShoppingUrl")
    private String continueShoppingUrl;
    @JsonProperty("MetadataItems")
    private List<MetadataItem> metadataItems = new ArrayList<MetadataItem>();
    private final static long serialVersionUID = 8876511106909570277L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetailerCheckoutExperience() {
    }

    /**
     * 
     * @param backToCartUrl
     * @param metadataItems
     * @param continueShoppingUrl
     * @param retailerCheckoutExperienceId
     */
    public RetailerCheckoutExperience(String retailerCheckoutExperienceId, String backToCartUrl,
            String continueShoppingUrl, List<MetadataItem> metadataItems) {
        super();
        this.retailerCheckoutExperienceId = retailerCheckoutExperienceId;
        this.backToCartUrl = backToCartUrl;
        this.continueShoppingUrl = continueShoppingUrl;
        this.metadataItems = metadataItems;
    }

    @JsonProperty("RetailerCheckoutExperienceId")
    public String getRetailerCheckoutExperienceId() {
        return retailerCheckoutExperienceId;
    }

    @JsonProperty("RetailerCheckoutExperienceId")
    public void setRetailerCheckoutExperienceId(String retailerCheckoutExperienceId) {
        this.retailerCheckoutExperienceId = retailerCheckoutExperienceId;
    }

    @JsonProperty("BackToCartUrl")
    public String getBackToCartUrl() {
        return backToCartUrl;
    }

    @JsonProperty("BackToCartUrl")
    public void setBackToCartUrl(String backToCartUrl) {
        this.backToCartUrl = backToCartUrl;
    }

    @JsonProperty("ContinueShoppingUrl")
    public String getContinueShoppingUrl() {
        return continueShoppingUrl;
    }

    @JsonProperty("ContinueShoppingUrl")
    public void setContinueShoppingUrl(String continueShoppingUrl) {
        this.continueShoppingUrl = continueShoppingUrl;
    }

    @JsonProperty("MetadataItems")
    public List<MetadataItem> getMetadataItems() {
        return metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataItems(List<MetadataItem> metadataItems) {
        if (metadataItems != null) {
            this.metadataItems = metadataItems;
        }
    }
}
