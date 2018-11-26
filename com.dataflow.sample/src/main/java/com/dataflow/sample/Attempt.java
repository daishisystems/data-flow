
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Attempt implements Serializable {

    @JsonProperty("PaymentAttemptRef")
    private String paymentAttemptRef;
    @JsonProperty("AlternativePaymentAttemptRef")
    private String alternativePaymentAttemptRef;
    @JsonProperty("PaymentMethodCode")
    private Integer paymentMethodCode;
    @JsonProperty("IntegrationType")
    private Integer integrationType;
    @JsonProperty("PaymentProcessorCode")
    private Integer paymentProcessorCode;
    @JsonProperty("MerchantAccountId")
    private String merchantAccountId;
    @JsonProperty("Is3DSecure")
    private Boolean is3DSecure;
    private final static long serialVersionUID = 1912901946241033718L;

    @JsonProperty("PaymentAttemptRef")
    public String getPaymentAttemptRef() {
        return paymentAttemptRef;
    }

    @JsonProperty("PaymentAttemptRef")
    public void setPaymentAttemptRef(String paymentAttemptRef) {
        this.paymentAttemptRef = paymentAttemptRef;
    }

    @JsonProperty("AlternativePaymentAttemptRef")
    public String getAlternativePaymentAttemptRef() {
        return alternativePaymentAttemptRef;
    }

    @JsonProperty("AlternativePaymentAttemptRef")
    public void setAlternativePaymentAttemptRef(String alternativePaymentAttemptRef) {
        this.alternativePaymentAttemptRef = alternativePaymentAttemptRef;
    }

    @JsonProperty("PaymentMethodCode")
    public Integer getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("PaymentMethodCode")
    public void setPaymentMethodCode(Integer paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("IntegrationType")
    public Integer getIntegrationType() {
        return integrationType;
    }

    @JsonProperty("IntegrationType")
    public void setIntegrationType(Integer integrationType) {
        this.integrationType = integrationType;
    }

    @JsonProperty("PaymentProcessorCode")
    public Integer getPaymentProcessorCode() {
        return paymentProcessorCode;
    }

    @JsonProperty("PaymentProcessorCode")
    public void setPaymentProcessorCode(Integer paymentProcessorCode) {
        this.paymentProcessorCode = paymentProcessorCode;
    }

    @JsonProperty("MerchantAccountId")
    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    @JsonProperty("MerchantAccountId")
    public void setMerchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    @JsonProperty("Is3DSecure")
    public Boolean getIs3DSecure() {
        return is3DSecure;
    }

    @JsonProperty("Is3DSecure")
    public void setIs3DSecure(Boolean is3DSecure) {
        this.is3DSecure = is3DSecure;
    }
}
