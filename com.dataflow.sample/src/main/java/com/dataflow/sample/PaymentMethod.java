package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class PaymentMethod implements Serializable {
    @JsonProperty("PaymentMethodId")
    private String paymentMethodId;
    @JsonProperty("PaymentMethodCode")
    private Integer paymentMethodCode;
    @JsonProperty("PaymentProcessorCode")
    private Integer paymentProcessorCode;
    @JsonProperty("Integration")
    private Integer integration;
    private final static long serialVersionUID = -1675908445828901137L;

    @JsonProperty("PaymentMethodId")
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    @JsonProperty("PaymentMethodId")
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @JsonProperty("PaymentMethodCode")
    public Integer getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("PaymentMethodCode")
    public void setPaymentMethodCode(Integer paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("PaymentProcessorCode")
    public Integer getPaymentProcessorCode() {
        return paymentProcessorCode;
    }

    @JsonProperty("PaymentProcessorCode")
    public void setPaymentProcessorCode(Integer paymentProcessorCode) {
        this.paymentProcessorCode = paymentProcessorCode;
    }

    @JsonProperty("Integration")
    public Integer getIntegration() {
        return integration;
    }

    @JsonProperty("Integration")
    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

}
