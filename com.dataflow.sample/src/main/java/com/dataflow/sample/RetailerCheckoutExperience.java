package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class RetailerCheckoutExperience implements Serializable {
    private String RetailerCheckoutExperienceId;
    private String BackToCartUrl;
    private String ContinueShoppingUrl;
    ArrayList<Object> MetadataItems = new ArrayList<Object>();

    // Getter Methods

    public String getRetailerCheckoutExperienceId() {
        return RetailerCheckoutExperienceId;
    }

    public String getBackToCartUrl() {
        return BackToCartUrl;
    }

    public String getContinueShoppingUrl() {
        return ContinueShoppingUrl;
    }

    // Setter Methods

    public void setRetailerCheckoutExperienceId(String RetailerCheckoutExperienceId) {
        this.RetailerCheckoutExperienceId = RetailerCheckoutExperienceId;
    }

    public void setBackToCartUrl(String BackToCartUrl) {
        this.BackToCartUrl = BackToCartUrl;
    }

    public void setContinueShoppingUrl(String ContinueShoppingUrl) {
        this.ContinueShoppingUrl = ContinueShoppingUrl;
    }
}