
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class MasterOrder implements Serializable {
    @JsonProperty("ShopperCurrencyPaymentAmount")
    private ShopperCurrencyPaymentAmount shopperCurrencyPaymentAmount;
    @JsonProperty("RetailerCurrencyPaymentAmount")
    private RetailerCurrencyPaymentAmount retailerCurrencyPaymentAmount;
    @JsonProperty("EShopWorldCurrencyPaymentAmount")
    private EShopWorldCurrencyPaymentAmount eShopWorldCurrencyPaymentAmount;
    @JsonProperty("OrderCode")
    private String orderCode;
    @JsonProperty("RetailerCartId")
    private String retailerCartId;
    @JsonProperty("OrderItemsAll")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
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
    private List<Error> errors = new ArrayList<Error>();
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
    private String ipAddress;
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
    @JsonProperty("OrderConfirmationErrorInformation")
    private String orderConfirmationErrorInformation;
    @JsonProperty("Features")
    private List<Feature> features = new ArrayList<Feature>();
    @JsonProperty("ExpiryTimeUtc")
    private String expiryTimeUtc;
    @JsonProperty("ChargeTargets")
    private List<ChargeTarget> chargeTargets = new ArrayList<ChargeTarget>();
    @JsonProperty("FingerprintId")
    private String fingerprintId;
    @JsonProperty("GdprAccepted")
    private Boolean gdprAccepted;
    @JsonProperty("GdprAcceptanceHistory")
    private List<GdprAcceptance> gdprAcceptanceHistory = new ArrayList<GdprAcceptance>();
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
    @JsonProperty("isRobot")
    private Boolean isRobot;
    @JsonProperty("primaryHardwareType")
    private String primaryHardwareType;
    @JsonProperty("browserName")
    private String browserName;
    @JsonProperty("osName")
    private String osName;
    @JsonProperty("DocumentLifetime")
    private String documentLifetime;
    @JsonProperty("ProductDataRetrievedAndInstalled")
    private Boolean productDataRetrievedAndInstalled;
    @JsonProperty("ProductDataCountryIso")
    private String productDataCountryIso;
    @JsonProperty("httpHeaders")
    private HashMap<String, String> httpHeaders;
    @JsonProperty("CreatedTimeUtc")
    @JsonIgnore
    private String createdTimeUtc;
    @JsonProperty("Version")
    @JsonIgnore
    private String version;
    @JsonProperty("HasPriceMultiplier")
    @JsonIgnore
    private Boolean hasPriceMultiplier;
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return this.timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("HasPriceMultiplier")
    @JsonIgnore
    public Boolean getHasPriceMultiplier() {
        return this.hasPriceMultiplier;
    }

    @JsonProperty("HasPriceMultiplier")
    @JsonIgnore
    public void setHasPriceMultiplier(Boolean hasPriceMultiplier) {
        this.hasPriceMultiplier = hasPriceMultiplier;
    }

    @JsonProperty("Version")
    @JsonIgnore
    public String getVersion() {
        return this.version;
    }

    @JsonProperty("Version")
    @JsonIgnore
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("CreatedTimeUtc")
    @JsonIgnore
    public String getCreatedTimeUtc() {
        return this.createdTimeUtc;
    }

    @JsonProperty("CreatedTimeUtc")
    @JsonIgnore
    public void setCreatedTimeUtc(String createdTimeUtc) {
        this.createdTimeUtc = createdTimeUtc;
    }

    @JsonProperty("UniqueId")
    @JsonIgnore
    private String uniqueId;

    @JsonProperty("UniqueId")
    @JsonIgnore
    public String getUniqueId() {
        return this.uniqueId;
    }

    @JsonProperty("UniqueId")
    @JsonIgnore
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonProperty("IsSelected")
    @JsonIgnore
    private Boolean isSelected;

    @JsonProperty("IsSelected")
    @JsonIgnore
    public Boolean getIsSelected() {
        return this.isSelected;
    }

    @JsonProperty("IsSelected")
    @JsonIgnore
    public void isIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    private final static long serialVersionUID = 8817357657140713368L;

    @JsonProperty("EShopWorldCurrencyPaymentAmount")
    public EShopWorldCurrencyPaymentAmount getEShopWorldCurrencyPaymentAmount() {
        return this.eShopWorldCurrencyPaymentAmount;
    }

    @JsonProperty("EShopWorldCurrencyPaymentAmount")
    public void setEShopWorldCurrencyPaymentAmount(EShopWorldCurrencyPaymentAmount eShopWorldCurrencyPaymentAmount) {
        this.eShopWorldCurrencyPaymentAmount = eShopWorldCurrencyPaymentAmount;
    }

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

    @JsonProperty("OrderItemsAll")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @JsonProperty("OrderItemsAll")
    public void setOrderItems(List<OrderItem> orderItems) {
        if (orderItems != null) {
            this.orderItems = orderItems;
        }
    }

    @JsonProperty("RetailerPromoCodes")
    public List<RetailerPromoCode> getRetailerPromoCodes() {
        return retailerPromoCodes;
    }

    @JsonProperty("RetailerPromoCodes")
    public void setRetailerPromoCodes(List<RetailerPromoCode> retailerPromoCodes) {
        if (retailerPromoCodes != null) {
            this.retailerPromoCodes = retailerPromoCodes;
        }
    }

    @JsonProperty("OrderDiscounts")
    public List<OrderDiscount> getOrderDiscounts() {
        return orderDiscounts;
    }

    @JsonProperty("OrderDiscounts")
    public void setOrderDiscounts(List<OrderDiscount> orderDiscounts) {
        if (orderDiscounts != null) {
            this.orderDiscounts = orderDiscounts;
        }
    }

    @JsonProperty("DeliveryDetails")
    public List<DeliveryDetail> getDeliveryDetails() {
        return deliveryDetails;
    }

    @JsonProperty("DeliveryDetails")
    public void setDeliveryDetails(List<DeliveryDetail> deliveryDetails) {
        if (deliveryDetails != null) {
            this.deliveryDetails = deliveryDetails;
        }
    }

    @JsonProperty("PaymentDetails")
    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("PaymentDetails")
    public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
        if (paymentDetails != null) {
            this.paymentDetails = paymentDetails;
        }
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
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("Errors")
    public void setErrors(List<Error> errors) {
        if (errors != null) {
            this.errors = errors;
        }
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
        if (deliveryOptions != null) {
            this.deliveryOptions = deliveryOptions;
        }
    }

    @JsonProperty("RetailerDeliveryOptions")
    public List<RetailerDeliveryOption> getRetailerDeliveryOptions() {
        return retailerDeliveryOptions;
    }

    @JsonProperty("RetailerDeliveryOptions")
    public void setRetailerDeliveryOptions(List<RetailerDeliveryOption> retailerDeliveryOptions) {
        if (retailerDeliveryOptions != null) {
            this.retailerDeliveryOptions = retailerDeliveryOptions;
        }
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
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("IpAddress")
    public void setIpAddress(String ipAddress) {
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

    @JsonProperty("OrderConfirmationErrorInformation")
    public String getOrderConfirmationErrorInformation() {
        return this.orderConfirmationErrorInformation;
    }

    @JsonProperty("OrderConfirmationErrorInformation")
    public void setOrderConfirmationErrorInformation(String orderConfirmationErrorInformation) {
        this.orderConfirmationErrorInformation = orderConfirmationErrorInformation;
    }

    @JsonProperty("Features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("Features")
    public void setFeatures(List<Feature> features) {
        if (features != null) {
            this.features = features;
        }
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
    public List<ChargeTarget> getChargeTargets() {
        return chargeTargets;
    }

    @JsonProperty("ChargeTargets")
    public void setChargeTargets(List<ChargeTarget> chargeTargets) {
        if (chargeTargets != null) {
            this.chargeTargets = chargeTargets;
        }
    }

    @JsonProperty("FingerprintId")
    public String getFingerprintId() {
        return fingerprintId;
    }

    @JsonProperty("FingerprintId")
    public void setFingerprintId(String fingerprintId) {
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
    public List<GdprAcceptance> getGdprAcceptanceHistory() {
        return gdprAcceptanceHistory;
    }

    @JsonProperty("GdprAcceptanceHistory")
    public void setGdprAcceptanceHistory(List<GdprAcceptance> gdprAcceptanceHistory) {
        if (gdprAcceptanceHistory != null) {
            this.gdprAcceptanceHistory = gdprAcceptanceHistory;
        }
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

    @JsonProperty("isRobot")
    public Boolean getIsRobot() {
        return isRobot;
    }

    @JsonProperty("isRobot")
    public void setIsRobot(Boolean isRobot) {
        this.isRobot = isRobot;
    }

    @JsonProperty("primaryHardwareType")
    public String getPrimaryHardwareType() {
        return primaryHardwareType;
    }

    @JsonProperty("primaryHardwareType")
    public void setPrimaryHardwareType(String primaryHardwareType) {
        this.primaryHardwareType = primaryHardwareType;
    }

    @JsonProperty("browserName")
    public String getBrowserName() {
        return browserName;
    }

    @JsonProperty("browserName")
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    @JsonProperty("osName")
    public String getOsName() {
        return osName;
    }

    @JsonProperty("osName")
    public void setOsName(String osName) {
        this.osName = osName;
    }

    @JsonProperty("DocumentLifetime")
    public String getDocumentLifetime() {
        return this.documentLifetime;
    }

    @JsonProperty("DocumentLifetime")
    public void setDocumentLifetime(String documentLifetime) {
        this.documentLifetime = documentLifetime;
    }

    @JsonProperty("ProductDataRetrievedAndInstalled")
    public Boolean getProductDataRetrievedAndInstalled() {
        return this.productDataRetrievedAndInstalled;
    }

    @JsonProperty("ProductDataRetrievedAndInstalled")
    public void isProductDataRetrievedAndInstalled(Boolean productDataRetrievedAndInstalled) {
        this.productDataRetrievedAndInstalled = productDataRetrievedAndInstalled;
    }

    @JsonProperty("ProductDataCountryIso")
    public String getProductDataCountryIso() {
        return this.productDataCountryIso;
    }

    @JsonProperty("ProductDataCountryIso")
    public void setProductDataCountryIso(String productDataCountryIso) {
        this.productDataCountryIso = productDataCountryIso;
    }

    @JsonProperty("httpHeaders")
    public HashMap<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    @JsonProperty("httpHeaders")
    public void setHttpHeaders(HashMap<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MasterOrder))
            return false;
        if (obj == this)
            return true;

        MasterOrder other = (MasterOrder) obj;

        String orderCode;
        if (this.orderCode != null) {
            orderCode = this.orderCode;
        } else {
            orderCode = "";
        }

        return orderCode.equals(other.getOrderCode()) && this.correlationId.equals(other.getCorrelationId())
                && this.created.equals(other.getCreated()) && this.eventName.equals(other.getEventName());
    }
}
