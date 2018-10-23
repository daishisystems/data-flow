
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "UseDeliveryContactDetailsForPaymentContactDetails", "EmailMarketingOptIn", "RegisteredProfileId",
        "ShopperCultureLanguageIso", "ExpressPaymentMethod", "MetadataItems" })
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
    @JsonProperty("MetadataItems")
    private List<Object> metadataItems = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
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
     * @param metadataItems
     * @param shopperCultureLanguageIso
     * @param registeredProfileId
     */
    public ShopperCheckoutExperience(Boolean useDeliveryContactDetailsForPaymentContactDetails,
            Boolean emailMarketingOptIn, String registeredProfileId, String shopperCultureLanguageIso,
            String expressPaymentMethod, List<Object> metadataItems) {
        super();
        this.useDeliveryContactDetailsForPaymentContactDetails = useDeliveryContactDetailsForPaymentContactDetails;
        this.emailMarketingOptIn = emailMarketingOptIn;
        this.registeredProfileId = registeredProfileId;
        this.shopperCultureLanguageIso = shopperCultureLanguageIso;
        this.expressPaymentMethod = expressPaymentMethod;
        this.metadataItems = metadataItems;
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

    @JsonProperty("MetadataItems")
    public List<Object> getMetadataItems() {
        return metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataItems(List<Object> metadataItems) {
        this.metadataItems = metadataItems;
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
