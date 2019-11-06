
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "UseDeliveryContactDetailsForPaymentContactDetails", "EmailMarketingOptIn", "RegisteredProfileId",
        "ShopperCultureLanguageIso", "ExpressPaymentMethod" })
@DefaultCoder(SerializableCoder.class)
public class ShopperCheckoutExperience implements Serializable {

    @JsonProperty("UseDeliveryContactDetailsForPaymentContactDetails")
    private Boolean useDeliveryContactDetailsForPaymentContactDetails;
    @JsonProperty("EmailMarketingOptIn")
    private Boolean emailMarketingOptIn;
    @JsonProperty("RegisteredProfileId")
    private String registeredProfileId;
    @JsonProperty("ShopperCultureLanguageIso")
    private String shopperCultureLanguageIso;
    @JsonProperty("ExpressPaymentMethod")
    private String expressPaymentMethod;
    private final static long serialVersionUID = 1502372606493616422L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShopperCheckoutExperience() {
    }

    /**
     * 
     * @param useDeliveryContactDetailsForPaymentContactDetails
     * @param expressPaymentMethod
     * @param emailMarketingOptIn
     * @param shopperCultureLanguageIso
     * @param registeredProfileId
     */
    public ShopperCheckoutExperience(Boolean useDeliveryContactDetailsForPaymentContactDetails,
            Boolean emailMarketingOptIn, String registeredProfileId, String shopperCultureLanguageIso,
            String expressPaymentMethod) {
        super();
        this.useDeliveryContactDetailsForPaymentContactDetails = useDeliveryContactDetailsForPaymentContactDetails;
        this.emailMarketingOptIn = emailMarketingOptIn;
        this.registeredProfileId = registeredProfileId;
        this.shopperCultureLanguageIso = shopperCultureLanguageIso;
        this.expressPaymentMethod = expressPaymentMethod;
    }

    @JsonProperty("UseDeliveryContactDetailsForPaymentContactDetails")
    public Boolean getUseDeliveryContactDetailsForPaymentContactDetails() {
        return useDeliveryContactDetailsForPaymentContactDetails;
    }

    @JsonProperty("UseDeliveryContactDetailsForPaymentContactDetails")
    public void setUseDeliveryContactDetailsForPaymentContactDetails(
            Boolean useDeliveryContactDetailsForPaymentContactDetails) {
        this.useDeliveryContactDetailsForPaymentContactDetails = useDeliveryContactDetailsForPaymentContactDetails;
    }

    @JsonProperty("EmailMarketingOptIn")
    public Boolean getEmailMarketingOptIn() {
        return emailMarketingOptIn;
    }

    @JsonProperty("EmailMarketingOptIn")
    public void setEmailMarketingOptIn(Boolean emailMarketingOptIn) {
        this.emailMarketingOptIn = emailMarketingOptIn;
    }

    @JsonProperty("RegisteredProfileId")
    public String getRegisteredProfileId() {
        return registeredProfileId;
    }

    @JsonProperty("RegisteredProfileId")
    public void setRegisteredProfileId(String registeredProfileId) {
        this.registeredProfileId = registeredProfileId;
    }

    @JsonProperty("ShopperCultureLanguageIso")
    public String getShopperCultureLanguageIso() {
        return shopperCultureLanguageIso;
    }

    @JsonProperty("ShopperCultureLanguageIso")
    public void setShopperCultureLanguageIso(String shopperCultureLanguageIso) {
        this.shopperCultureLanguageIso = shopperCultureLanguageIso;
    }

    @JsonProperty("ExpressPaymentMethod")
    public String getExpressPaymentMethod() {
        return expressPaymentMethod;
    }

    @JsonProperty("ExpressPaymentMethod")
    public void setExpressPaymentMethod(String expressPaymentMethod) {
        this.expressPaymentMethod = expressPaymentMethod;
    }
}
