package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class ShopperCheckoutExperience implements Serializable {
    private boolean UseDeliveryContactDetailsForPaymentContactDetails;
    private boolean EmailMarketingOptIn;
    private String RegisteredProfileId;
    private String ShopperCultureLanguageIso;
    private String ExpressPaymentMethod;
    ArrayList<Object> MetadataItems = new ArrayList<Object>();

    // Getter Methods

    public boolean getUseDeliveryContactDetailsForPaymentContactDetails() {
        return UseDeliveryContactDetailsForPaymentContactDetails;
    }

    public boolean getEmailMarketingOptIn() {
        return EmailMarketingOptIn;
    }

    public String getRegisteredProfileId() {
        return RegisteredProfileId;
    }

    public String getShopperCultureLanguageIso() {
        return ShopperCultureLanguageIso;
    }

    public String getExpressPaymentMethod() {
        return ExpressPaymentMethod;
    }

    // Setter Methods

    public void setUseDeliveryContactDetailsForPaymentContactDetails(
            boolean UseDeliveryContactDetailsForPaymentContactDetails) {
        this.UseDeliveryContactDetailsForPaymentContactDetails = UseDeliveryContactDetailsForPaymentContactDetails;
    }

    public void setEmailMarketingOptIn(boolean EmailMarketingOptIn) {
        this.EmailMarketingOptIn = EmailMarketingOptIn;
    }

    public void setRegisteredProfileId(String RegisteredProfileId) {
        this.RegisteredProfileId = RegisteredProfileId;
    }

    public void setShopperCultureLanguageIso(String ShopperCultureLanguageIso) {
        this.ShopperCultureLanguageIso = ShopperCultureLanguageIso;
    }

    public void setExpressPaymentMethod(String ExpressPaymentMethod) {
        this.ExpressPaymentMethod = ExpressPaymentMethod;
    }
}