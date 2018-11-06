
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class MasterOrder implements Serializable {
    @JsonProperty("OrderCode")
    private String orderCode;
    @JsonProperty("RetailerCartId")
    private String retailerCartId;
    @JsonProperty("OrderItems")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    @JsonProperty("AvailableOrderItems")
    private List<AvailableOrderItem> availableOrderItems = new ArrayList<AvailableOrderItem>();
    @JsonProperty("RetailerPromoCodes")
    private List<RetailerPromoCode> retailerPromoCodes = new ArrayList<RetailerPromoCode>();
    @JsonProperty("OrderDiscounts")
    private List<OrderDiscount> orderDiscounts = new ArrayList<OrderDiscount>();
    @JsonProperty("DeliveryDetails")
    private List<DeliveryDetail> deliveryDetails = new ArrayList<DeliveryDetail>();
    @JsonProperty("PaymentDetails")
    private List<PaymentDetail> paymentDetails = new ArrayList<PaymentDetail>();
    @JsonProperty("DeliveryOption")
    private DeliveryOption deliveryOption;
    @JsonProperty("Errors")
    private List<Object> errors = new ArrayList<Object>();
    @JsonProperty("RetailerCheckoutExperience")
    private RetailerCheckoutExperience retailerCheckoutExperience;
    @JsonProperty("ShopperCurrencyIso")
    private String shopperCurrencyIso;
    @JsonProperty("RetailerCurrencyIso")
    private String retailerCurrencyIso;
    @JsonProperty("RetailerFxGroupId")
    private Integer retailerFxGroupId;
    @JsonProperty("SourceCountryIso")
    private String sourceCountryIso;
    @JsonProperty("DeliveryCountryIso")
    private String deliveryCountryIso;
    @JsonProperty("ShopperCheckoutExperience")
    private ShopperCheckoutExperience shopperCheckoutExperience;
    @JsonProperty("DeliveryOptions")
    private List<DeliveryOption> deliveryOptions = new ArrayList<DeliveryOption>();
    @JsonProperty("RetailerDeliveryOptions")
    private List<RetailerDeliveryOption> retailerDeliveryOptions = new ArrayList<RetailerDeliveryOption>();
    @JsonProperty("Payment")
    private Payment payment;
    @JsonProperty("IpAddress")
    private Object ipAddress;
    @JsonProperty("CalculationParameters")
    private CalculationParameters calculationParameters;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("RetailerConfirmation")
    private RetailerConfirmation retailerConfirmation;
    @JsonProperty("PlatformCreate")
    private PlatformCreate platformCreate;
    @JsonProperty("Pricing")
    private Pricing pricing;
    @JsonProperty("Features")
    private List<Feature> features = new ArrayList<Feature>();
    @JsonProperty("ExpiryTimeUtc")
    private String expiryTimeUtc;
    @JsonProperty("ChargeTargets")
    private List<Object> chargeTargets = new ArrayList<Object>();
    @JsonProperty("FingerprintId")
    private Object fingerprintId;
    @JsonProperty("GdprAccepted")
    private Boolean gdprAccepted;
    @JsonProperty("GdprAcceptanceHistory")
    private List<Object> gdprAcceptanceHistory = new ArrayList<Object>();
    @JsonProperty("brandCode")
    private String brandCode;
    @JsonProperty("eventName")
    private String eventName;
    @JsonProperty("correlationId")
    private String correlationId;
    @JsonProperty("userAgent")
    private String userAgent;
    @JsonProperty("queryString")
    private String queryString;
    @JsonProperty("created")
    private Long created;
    private final static long serialVersionUID = 8817357657140713368L;

    @JsonProperty("OrderCode")
    public String getOrderCode() {
        return orderCode;
    }

    @JsonProperty("OrderCode")
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @JsonProperty("RetailerCartId")
    public String getRetailerCartId() {
        return retailerCartId;
    }

    @JsonProperty("RetailerCartId")
    public void setRetailerCartId(String retailerCartId) {
        this.retailerCartId = retailerCartId;
    }

    @JsonProperty("OrderItems")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @JsonProperty("OrderItems")
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @JsonProperty("AvailableOrderItems")
    public List<AvailableOrderItem> getAvailableOrderItems() {
        return availableOrderItems;
    }

    @JsonProperty("AvailableOrderItems")
    public void setAvailableOrderItems(List<AvailableOrderItem> availableOrderItems) {
        this.availableOrderItems = availableOrderItems;
    }

    @JsonProperty("RetailerPromoCodes")
    public List<RetailerPromoCode> getRetailerPromoCodes() {
        return retailerPromoCodes;
    }

    @JsonProperty("RetailerPromoCodes")
    public void setRetailerPromoCodes(List<RetailerPromoCode> retailerPromoCodes) {
        this.retailerPromoCodes = retailerPromoCodes;
    }

    @JsonProperty("OrderDiscounts")
    public List<OrderDiscount> getOrderDiscounts() {
        return orderDiscounts;
    }

    @JsonProperty("OrderDiscounts")
    public void setOrderDiscounts(List<OrderDiscount> orderDiscounts) {
        this.orderDiscounts = orderDiscounts;
    }

    @JsonProperty("DeliveryDetails")
    public List<DeliveryDetail> getDeliveryDetails() {
        return deliveryDetails;
    }

    @JsonProperty("DeliveryDetails")
    public void setDeliveryDetails(List<DeliveryDetail> deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    @JsonProperty("PaymentDetails")
    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("PaymentDetails")
    public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("DeliveryOption")
    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    @JsonProperty("DeliveryOption")
    public void setDeliveryOption(DeliveryOption deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    @JsonProperty("Errors")
    public List<Object> getErrors() {
        return errors;
    }

    @JsonProperty("Errors")
    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    @JsonProperty("RetailerCheckoutExperience")
    public RetailerCheckoutExperience getRetailerCheckoutExperience() {
        return retailerCheckoutExperience;
    }

    @JsonProperty("RetailerCheckoutExperience")
    public void setRetailerCheckoutExperience(RetailerCheckoutExperience retailerCheckoutExperience) {
        this.retailerCheckoutExperience = retailerCheckoutExperience;
    }

    @JsonProperty("ShopperCurrencyIso")
    public String getShopperCurrencyIso() {
        return shopperCurrencyIso;
    }

    @JsonProperty("ShopperCurrencyIso")
    public void setShopperCurrencyIso(String shopperCurrencyIso) {
        this.shopperCurrencyIso = shopperCurrencyIso;
    }

    @JsonProperty("RetailerCurrencyIso")
    public String getRetailerCurrencyIso() {
        return retailerCurrencyIso;
    }

    @JsonProperty("RetailerCurrencyIso")
    public void setRetailerCurrencyIso(String retailerCurrencyIso) {
        this.retailerCurrencyIso = retailerCurrencyIso;
    }

    @JsonProperty("RetailerFxGroupId")
    public Integer getRetailerFxGroupId() {
        return retailerFxGroupId;
    }

    @JsonProperty("RetailerFxGroupId")
    public void setRetailerFxGroupId(Integer retailerFxGroupId) {
        this.retailerFxGroupId = retailerFxGroupId;
    }

    @JsonProperty("SourceCountryIso")
    public String getSourceCountryIso() {
        return sourceCountryIso;
    }

    @JsonProperty("SourceCountryIso")
    public void setSourceCountryIso(String sourceCountryIso) {
        this.sourceCountryIso = sourceCountryIso;
    }

    @JsonProperty("DeliveryCountryIso")
    public String getDeliveryCountryIso() {
        return deliveryCountryIso;
    }

    @JsonProperty("DeliveryCountryIso")
    public void setDeliveryCountryIso(String deliveryCountryIso) {
        this.deliveryCountryIso = deliveryCountryIso;
    }

    @JsonProperty("ShopperCheckoutExperience")
    public ShopperCheckoutExperience getShopperCheckoutExperience() {
        return shopperCheckoutExperience;
    }

    @JsonProperty("ShopperCheckoutExperience")
    public void setShopperCheckoutExperience(ShopperCheckoutExperience shopperCheckoutExperience) {
        this.shopperCheckoutExperience = shopperCheckoutExperience;
    }

    @JsonProperty("DeliveryOptions")
    public List<DeliveryOption> getDeliveryOptions() {
        return deliveryOptions;
    }

    @JsonProperty("DeliveryOptions")
    public void setDeliveryOptions(List<DeliveryOption> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    @JsonProperty("RetailerDeliveryOptions")
    public List<RetailerDeliveryOption> getRetailerDeliveryOptions() {
        return retailerDeliveryOptions;
    }

    @JsonProperty("RetailerDeliveryOptions")
    public void setRetailerDeliveryOptions(List<RetailerDeliveryOption> retailerDeliveryOptions) {
        this.retailerDeliveryOptions = retailerDeliveryOptions;
    }

    @JsonProperty("Payment")
    public Payment getPayment() {
        return payment;
    }

    @JsonProperty("Payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @JsonProperty("IpAddress")
    public Object getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("IpAddress")
    public void setIpAddress(Object ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("CalculationParameters")
    public CalculationParameters getCalculationParameters() {
        return calculationParameters;
    }

    @JsonProperty("CalculationParameters")
    public void setCalculationParameters(CalculationParameters calculationParameters) {
        this.calculationParameters = calculationParameters;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("RetailerConfirmation")
    public RetailerConfirmation getRetailerConfirmation() {
        return retailerConfirmation;
    }

    @JsonProperty("RetailerConfirmation")
    public void setRetailerConfirmation(RetailerConfirmation retailerConfirmation) {
        this.retailerConfirmation = retailerConfirmation;
    }

    @JsonProperty("PlatformCreate")
    public PlatformCreate getPlatformCreate() {
        return platformCreate;
    }

    @JsonProperty("PlatformCreate")
    public void setPlatformCreate(PlatformCreate platformCreate) {
        this.platformCreate = platformCreate;
    }

    @JsonProperty("Pricing")
    public Pricing getPricing() {
        return pricing;
    }

    @JsonProperty("Pricing")
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    @JsonProperty("Features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("Features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @JsonProperty("ExpiryTimeUtc")
    public String getExpiryTimeUtc() {
        return expiryTimeUtc;
    }

    @JsonProperty("ExpiryTimeUtc")
    public void setExpiryTimeUtc(String expiryTimeUtc) {
        this.expiryTimeUtc = expiryTimeUtc;
    }

    @JsonProperty("ChargeTargets")
    public List<Object> getChargeTargets() {
        return chargeTargets;
    }

    @JsonProperty("ChargeTargets")
    public void setChargeTargets(List<Object> chargeTargets) {
        this.chargeTargets = chargeTargets;
    }

    @JsonProperty("FingerprintId")
    public Object getFingerprintId() {
        return fingerprintId;
    }

    @JsonProperty("FingerprintId")
    public void setFingerprintId(Object fingerprintId) {
        this.fingerprintId = fingerprintId;
    }

    @JsonProperty("GdprAccepted")
    public Boolean getGdprAccepted() {
        return gdprAccepted;
    }

    @JsonProperty("GdprAccepted")
    public void setGdprAccepted(Boolean gdprAccepted) {
        this.gdprAccepted = gdprAccepted;
    }

    @JsonProperty("GdprAcceptanceHistory")
    public List<Object> getGdprAcceptanceHistory() {
        return gdprAcceptanceHistory;
    }

    @JsonProperty("GdprAcceptanceHistory")
    public void setGdprAcceptanceHistory(List<Object> gdprAcceptanceHistory) {
        this.gdprAcceptanceHistory = gdprAcceptanceHistory;
    }

    @JsonProperty("brandCode")
    public String getBrandCode() {
        return brandCode;
    }

    @JsonProperty("brandCode")
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @JsonProperty("eventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("eventName")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @JsonProperty("correlationId")
    public String getCorrelationId() {
        return correlationId;
    }

    @JsonProperty("correlationId")
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @JsonProperty("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("userAgent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @JsonProperty("queryString")
    public String getQueryString() {
        return queryString;
    }

    @JsonProperty("queryString")
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @JsonProperty("created")
    public Long getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }
}
