package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "PaymentAttemptId", "PaymentAttemptRef", "OrderRef", "CreatedUtc", "LastUpdatedUtc", "State",
        "PaymentGatewayCode", "PaymentMethodCode", "GatewayTransactionId", "AuthCode", "brandCode", "eventName",
        "correlationId", "queryString", "httpHeaders", "created" })
public class PaymentAttempt2 implements Serializable {

    @JsonProperty("PaymentAttemptId")
    private Integer paymentAttemptId;
    @JsonProperty("PaymentAttemptRef")
    private String paymentAttemptRef;
    @JsonProperty("OrderRef")
    private String orderRef;
    @JsonProperty("CreatedUtc")
    private String createdUtc;
    @JsonProperty("LastUpdatedUtc")
    private String lastUpdatedUtc;
    @JsonProperty("State")
    private Integer state;
    @JsonProperty("PaymentGatewayCode")
    private String paymentGatewayCode;
    @JsonProperty("PaymentMethodCode")
    private String paymentMethodCode;
    @JsonProperty("GatewayTransactionId")
    private String gatewayTransactionId;
    @JsonProperty("AuthCode")
    private String authCode;
    @JsonProperty("brandCode")
    private String brandCode;
    @JsonProperty("eventName")
    private String eventName;
    @JsonProperty("correlationId")
    private String correlationId;
    @JsonProperty("queryString")
    private String queryString;
    @JsonProperty("created")
    private String created;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1672251925109427172L;

    @JsonProperty("PaymentAttemptId")
    public Integer getPaymentAttemptId() {
        return paymentAttemptId;
    }

    @JsonProperty("PaymentAttemptId")
    public void setPaymentAttemptId(Integer paymentAttemptId) {
        this.paymentAttemptId = paymentAttemptId;
    }

    @JsonProperty("PaymentAttemptRef")
    public String getPaymentAttemptRef() {
        return paymentAttemptRef;
    }

    @JsonProperty("PaymentAttemptRef")
    public void setPaymentAttemptRef(String paymentAttemptRef) {
        this.paymentAttemptRef = paymentAttemptRef;
    }

    @JsonProperty("OrderRef")
    public String getOrderRef() {
        return orderRef;
    }

    @JsonProperty("OrderRef")
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    @JsonProperty("CreatedUtc")
    public String getCreatedUtc() {
        return createdUtc;
    }

    @JsonProperty("CreatedUtc")
    public void setCreatedUtc(String createdUtc) {
        this.createdUtc = createdUtc;
    }

    @JsonProperty("LastUpdatedUtc")
    public String getLastUpdatedUtc() {
        return lastUpdatedUtc;
    }

    @JsonProperty("LastUpdatedUtc")
    public void setLastUpdatedUtc(String lastUpdatedUtc) {
        this.lastUpdatedUtc = lastUpdatedUtc;
    }

    @JsonProperty("State")
    public Integer getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(Integer state) {
        this.state = state;
    }

    @JsonProperty("PaymentGatewayCode")
    public String getPaymentGatewayCode() {
        return paymentGatewayCode;
    }

    @JsonProperty("PaymentGatewayCode")
    public void setPaymentGatewayCode(String paymentGatewayCode) {
        this.paymentGatewayCode = paymentGatewayCode;
    }

    @JsonProperty("PaymentMethodCode")
    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("PaymentMethodCode")
    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("GatewayTransactionId")
    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    @JsonProperty("GatewayTransactionId")
    public void setGatewayTransactionId(String gatewayTransactionId) {
        this.gatewayTransactionId = gatewayTransactionId;
    }

    @JsonProperty("AuthCode")
    public String getAuthCode() {
        return authCode;
    }

    @JsonProperty("AuthCode")
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    @JsonProperty("queryString")
    public Object getQueryString() {
        return queryString;
    }

    @JsonProperty("queryString")
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
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