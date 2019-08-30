package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "paymentId", "alternativePaymentAttemptRef", "paymentMethodCode", "integrationType",
        "paymentProcessorCode", "merchantAccountId", "is3DSecure" })
public class PaymentAttempt implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("paymentId")
    private String paymentId;
    @JsonProperty("alternativePaymentAttemptRef")
    private String alternativePaymentAttemptRef;
    @JsonProperty("paymentMethodCode")
    private int paymentMethodCode;
    @JsonProperty("integrationType")
    private int integrationType;
    @JsonProperty("paymentProcessorCode")
    private int paymentProcessorCode;
    @JsonProperty("merchantAccountId")
    private String merchantAccountId;
    @JsonProperty("is3DSecure")
    private boolean is3DSecure;
    private final static long serialVersionUID = 2560899287790414354L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("paymentId")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("paymentId")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("alternativePaymentAttemptRef")
    public String getAlternativePaymentAttemptRef() {
        return alternativePaymentAttemptRef;
    }

    @JsonProperty("alternativePaymentAttemptRef")
    public void setAlternativePaymentAttemptRef(String alternativePaymentAttemptRef) {
        this.alternativePaymentAttemptRef = alternativePaymentAttemptRef;
    }

    @JsonProperty("paymentMethodCode")
    public int getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("paymentMethodCode")
    public void setPaymentMethodCode(int paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("integrationType")
    public int getIntegrationType() {
        return integrationType;
    }

    @JsonProperty("integrationType")
    public void setIntegrationType(int integrationType) {
        this.integrationType = integrationType;
    }

    @JsonProperty("paymentProcessorCode")
    public int getPaymentProcessorCode() {
        return paymentProcessorCode;
    }

    @JsonProperty("paymentProcessorCode")
    public void setPaymentProcessorCode(int paymentProcessorCode) {
        this.paymentProcessorCode = paymentProcessorCode;
    }

    @JsonProperty("merchantAccountId")
    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    @JsonProperty("merchantAccountId")
    public void setMerchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    @JsonProperty("is3DSecure")
    public boolean isIs3DSecure() {
        return is3DSecure;
    }

    @JsonProperty("is3DSecure")
    public void setIs3DSecure(boolean is3DSecure) {
        this.is3DSecure = is3DSecure;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("paymentId", paymentId)
                .append("alternativePaymentAttemptRef", alternativePaymentAttemptRef)
                .append("paymentMethodCode", paymentMethodCode).append("integrationType", integrationType)
                .append("paymentProcessorCode", paymentProcessorCode).append("merchantAccountId", merchantAccountId)
                .append("is3DSecure", is3DSecure).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(alternativePaymentAttemptRef).append(paymentMethodCode)
                .append(paymentId).append(is3DSecure).append(paymentProcessorCode).append(integrationType)
                .append(merchantAccountId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentAttempt) == false) {
            return false;
        }
        PaymentAttempt rhs = ((PaymentAttempt) other);
        return new EqualsBuilder().append(id, rhs.id)
                .append(alternativePaymentAttemptRef, rhs.alternativePaymentAttemptRef)
                .append(paymentMethodCode, rhs.paymentMethodCode).append(paymentId, rhs.paymentId)
                .append(is3DSecure, rhs.is3DSecure).append(paymentProcessorCode, rhs.paymentProcessorCode)
                .append(integrationType, rhs.integrationType).append(merchantAccountId, rhs.merchantAccountId)
                .isEquals();
    }

}