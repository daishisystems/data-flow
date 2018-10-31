package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "MerchantId", "GatewayTransactionId", "MerchantTransactionId", "AuthResult", "PaymentBrand",
        "SettleAfterUtc" })
@DefaultCoder(SerializableCoder.class)
public class AuthorizationDetails implements Serializable {

    @JsonProperty("MerchantId")
    private String merchantId;
    @JsonProperty("GatewayTransactionId")
    private String gatewayTransactionId;
    @JsonProperty("MerchantTransactionId")
    private String merchantTransactionId;
    @JsonProperty("AuthResult")
    private String authResult;
    @JsonProperty("PaymentBrand")
    private String paymentBrand;
    @JsonProperty("SettleAfterUtc")
    private String settleAfterUtc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4586287568016047030L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AuthorizationDetails() {
    }

    /**
     * 
     * @param paymentBrand
     * @param settleAfterUtc
     * @param gatewayTransactionId
     * @param merchantId
     * @param merchantTransactionId
     * @param authResult
     */
    public AuthorizationDetails(String merchantId, String gatewayTransactionId, String merchantTransactionId,
            String authResult, String paymentBrand, String settleAfterUtc) {
        super();
        this.merchantId = merchantId;
        this.gatewayTransactionId = gatewayTransactionId;
        this.merchantTransactionId = merchantTransactionId;
        this.authResult = authResult;
        this.paymentBrand = paymentBrand;
        this.settleAfterUtc = settleAfterUtc;
    }

    @JsonProperty("MerchantId")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("MerchantId")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("GatewayTransactionId")
    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    @JsonProperty("GatewayTransactionId")
    public void setGatewayTransactionId(String gatewayTransactionId) {
        this.gatewayTransactionId = gatewayTransactionId;
    }

    @JsonProperty("MerchantTransactionId")
    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    @JsonProperty("MerchantTransactionId")
    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    @JsonProperty("AuthResult")
    public String getAuthResult() {
        return authResult;
    }

    @JsonProperty("AuthResult")
    public void setAuthResult(String authResult) {
        this.authResult = authResult;
    }

    @JsonProperty("PaymentBrand")
    public String getPaymentBrand() {
        return paymentBrand;
    }

    @JsonProperty("PaymentBrand")
    public void setPaymentBrand(String paymentBrand) {
        this.paymentBrand = paymentBrand;
    }

    @JsonProperty("SettleAfterUtc")
    public String getSettleAfterUtc() {
        return settleAfterUtc;
    }

    @JsonProperty("SettleAfterUtc")
    public void setSettleAfterUtc(String settleAfterUtc) {
        this.settleAfterUtc = settleAfterUtc;
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
