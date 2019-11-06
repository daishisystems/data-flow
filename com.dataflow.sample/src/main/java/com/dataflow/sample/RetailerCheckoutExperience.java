
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "RetailerCheckoutExperienceId", "BackToCartUrl", "ContinueShoppingUrl" })
@DefaultCoder(SerializableCoder.class)
public class RetailerCheckoutExperience implements Serializable {

    @JsonProperty("RetailerCheckoutExperienceId")
    private String retailerCheckoutExperienceId;
    @JsonProperty("BackToCartUrl")
    private String backToCartUrl;
    @JsonProperty("ContinueShoppingUrl")
    private String continueShoppingUrl;
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
     * @param continueShoppingUrl
     * @param retailerCheckoutExperienceId
     */
    public RetailerCheckoutExperience(String retailerCheckoutExperienceId, String backToCartUrl,
            String continueShoppingUrl) {
        super();
        this.retailerCheckoutExperienceId = retailerCheckoutExperienceId;
        this.backToCartUrl = backToCartUrl;
        this.continueShoppingUrl = continueShoppingUrl;
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
}
