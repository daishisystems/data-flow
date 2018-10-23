package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class MasterOrder implements Serializable {
    private static final long serialVersionUID = 8472098660852369410L;
    private String OrderCode;
    private String RetailerCartId;
    ArrayList<Object> OrderItems = new ArrayList<Object>();
    ArrayList<Object> AvailableOrderItems = new ArrayList<Object>();
    ArrayList<Object> RetailerPromoCodes = new ArrayList<Object>();
    ArrayList<Object> OrderDiscounts = new ArrayList<Object>();
    ArrayList<Object> DeliveryDetails = new ArrayList<Object>();
    ArrayList<Object> PaymentDetails = new ArrayList<Object>();
    DeliveryOption DeliveryOptionObject;
    ArrayList<Object> Errors = new ArrayList<Object>();
    RetailerCheckoutExperience RetailerCheckoutExperienceObject;
    private String ShopperCurrencyIso;
    private String RetailerCurrencyIso;
    private float RetailerFxGroupId;
    private String SourceCountryIso;
    private String DeliveryCountryIso;
    ShopperCheckoutExperience ShopperCheckoutExperienceObject;
    ArrayList<Object> DeliveryOptions = new ArrayList<Object>();
    ArrayList<Object> RetailerDeliveryOptions = new ArrayList<Object>();
    Payment PaymentObject;
    private String IpAddress = null;
    CalculationParameters CalculationParametersObject;
    private String Status;
    private String OrderConfirmationErrorInformation = null;
    Pricing PricingObject;
    ArrayList<Object> Features = new ArrayList<Object>();
    private String ExpiryTimeUtc;
    ArrayList<Object> ChargeTargets = new ArrayList<Object>();
    private boolean GdprAccepted;
    ArrayList<Object> GdprAcceptanceHistory = new ArrayList<Object>();
    private String brandCode;
    private String eventName;
    private String correlationId;
    private String userAgent;
    private String queryString;
    private String created;

    // Getter Methods

    public String getOrderCode() {
        return OrderCode;
    }

    public String getRetailerCartId() {
        return RetailerCartId;
    }

    public DeliveryOption getDeliveryOption() {
        return DeliveryOptionObject;
    }

    public RetailerCheckoutExperience getRetailerCheckoutExperience() {
        return RetailerCheckoutExperienceObject;
    }

    public String getShopperCurrencyIso() {
        return ShopperCurrencyIso;
    }

    public String getRetailerCurrencyIso() {
        return RetailerCurrencyIso;
    }

    public float getRetailerFxGroupId() {
        return RetailerFxGroupId;
    }

    public String getSourceCountryIso() {
        return SourceCountryIso;
    }

    public String getDeliveryCountryIso() {
        return DeliveryCountryIso;
    }

    public ShopperCheckoutExperience getShopperCheckoutExperience() {
        return ShopperCheckoutExperienceObject;
    }

    public Payment getPayment() {
        return PaymentObject;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public CalculationParameters getCalculationParameters() {
        return CalculationParametersObject;
    }

    public String getStatus() {
        return Status;
    }

    public String getOrderConfirmationErrorInformation() {
        return OrderConfirmationErrorInformation;
    }

    public Pricing getPricing() {
        return PricingObject;
    }

    public String getExpiryTimeUtc() {
        return ExpiryTimeUtc;
    }

    public boolean getGdprAccepted() {
        return GdprAccepted;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getCreated() {
        return created;
    }

    // Setter Methods

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public void setRetailerCartId(String RetailerCartId) {
        this.RetailerCartId = RetailerCartId;
    }

    public void setDeliveryOption(DeliveryOption DeliveryOptionObject) {
        this.DeliveryOptionObject = DeliveryOptionObject;
    }

    public void setRetailerCheckoutExperience(RetailerCheckoutExperience RetailerCheckoutExperienceObject) {
        this.RetailerCheckoutExperienceObject = RetailerCheckoutExperienceObject;
    }

    public void setShopperCurrencyIso(String ShopperCurrencyIso) {
        this.ShopperCurrencyIso = ShopperCurrencyIso;
    }

    public void setRetailerCurrencyIso(String RetailerCurrencyIso) {
        this.RetailerCurrencyIso = RetailerCurrencyIso;
    }

    public void setRetailerFxGroupId(float RetailerFxGroupId) {
        this.RetailerFxGroupId = RetailerFxGroupId;
    }

    public void setSourceCountryIso(String SourceCountryIso) {
        this.SourceCountryIso = SourceCountryIso;
    }

    public void setDeliveryCountryIso(String DeliveryCountryIso) {
        this.DeliveryCountryIso = DeliveryCountryIso;
    }

    public void setShopperCheckoutExperience(ShopperCheckoutExperience ShopperCheckoutExperienceObject) {
        this.ShopperCheckoutExperienceObject = ShopperCheckoutExperienceObject;
    }

    public void setPayment(Payment PaymentObject) {
        this.PaymentObject = PaymentObject;
    }

    public void setIpAddress(String IpAddress) {
        this.IpAddress = IpAddress;
    }

    public void setCalculationParameters(CalculationParameters CalculationParametersObject) {
        this.CalculationParametersObject = CalculationParametersObject;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setOrderConfirmationErrorInformation(String OrderConfirmationErrorInformation) {
        this.OrderConfirmationErrorInformation = OrderConfirmationErrorInformation;
    }

    public void setPricing(Pricing PricingObject) {
        this.PricingObject = PricingObject;
    }

    public void setExpiryTimeUtc(String ExpiryTimeUtc) {
        this.ExpiryTimeUtc = ExpiryTimeUtc;
    }

    public void setGdprAccepted(boolean GdprAccepted) {
        this.GdprAccepted = GdprAccepted;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}