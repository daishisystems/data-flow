
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "paymentMethodId", "paymentMethodCode", "paymentProcessorCode", "integration" })
public class PaymentMethod_ implements Serializable {

    @JsonProperty("paymentMethodId")
    private String paymentMethodId;
    @JsonProperty("paymentMethodCode")
    private int paymentMethodCode;
    @JsonProperty("paymentProcessorCode")
    private int paymentProcessorCode;
    @JsonProperty("integration")
    private int integration;
    private final static long serialVersionUID = 8913955535382165785L;

    @JsonProperty("paymentMethodId")
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    @JsonProperty("paymentMethodId")
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @JsonProperty("paymentMethodCode")
    public int getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("paymentMethodCode")
    public void setPaymentMethodCode(int paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("paymentProcessorCode")
    public int getPaymentProcessorCode() {
        return paymentProcessorCode;
    }

    @JsonProperty("paymentProcessorCode")
    public void setPaymentProcessorCode(int paymentProcessorCode) {
        this.paymentProcessorCode = paymentProcessorCode;
    }

    @JsonProperty("integration")
    public int getIntegration() {
        return integration;
    }

    @JsonProperty("integration")
    public void setIntegration(int integration) {
        this.integration = integration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("paymentMethodId", paymentMethodId)
                .append("paymentMethodCode", paymentMethodCode).append("paymentProcessorCode", paymentProcessorCode)
                .append("integration", integration).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(paymentMethodCode).append(integration).append(paymentProcessorCode)
                .append(paymentMethodId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentMethod_) == false) {
            return false;
        }
        PaymentMethod_ rhs = ((PaymentMethod_) other);
        return new EqualsBuilder().append(paymentMethodCode, rhs.paymentMethodCode).append(integration, rhs.integration)
                .append(paymentProcessorCode, rhs.paymentProcessorCode).append(paymentMethodId, rhs.paymentMethodId)
                .isEquals();
    }

}
