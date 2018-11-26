
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class MasterPayment implements Serializable {

    @JsonProperty("State")
    private Integer state;
    @JsonProperty("PaymentProfileId")
    private String paymentProfileId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("Order")
    private Order order;
    @JsonProperty("PaymentResultUrl")
    private String paymentResultUrl;
    @JsonProperty("AuthorizationUrl")
    private String authorizationUrl;
    @JsonProperty("PostAuthHandoverUrl")
    private String postAuthHandoverUrl;
    @JsonProperty("CreatedDateTime")
    private String createdDateTime;
    @JsonProperty("PaymentMethods")
    private List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
    @JsonProperty("UpdatedDateTime")
    private String updatedDateTime;
    @JsonProperty("SentToPaymentsLegacy")
    private Boolean sentToPaymentsLegacy;
    @JsonProperty("Attempts")
    private List<Attempt> attempts = new ArrayList<Attempt>();
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
    private String created;
    private final static long serialVersionUID = -7776501539637318262L;

    @JsonProperty("State")
    public Integer getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(Integer state) {
        this.state = state;
    }

    @JsonProperty("PaymentProfileId")
    public String getPaymentProfileId() {
        return paymentProfileId;
    }

    @JsonProperty("PaymentProfileId")
    public void setPaymentProfileId(String paymentProfileId) {
        this.paymentProfileId = paymentProfileId;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Order")
    public Order getOrder() {
        return order;
    }

    @JsonProperty("Order")
    public void setOrder(Order order) {
        this.order = order;
    }

    @JsonProperty("PaymentResultUrl")
    public String getPaymentResultUrl() {
        return paymentResultUrl;
    }

    @JsonProperty("PaymentResultUrl")
    public void setPaymentResultUrl(String paymentResultUrl) {
        this.paymentResultUrl = paymentResultUrl;
    }

    @JsonProperty("AuthorizationUrl")
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    @JsonProperty("AuthorizationUrl")
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    @JsonProperty("PostAuthHandoverUrl")
    public String getPostAuthHandoverUrl() {
        return postAuthHandoverUrl;
    }

    @JsonProperty("PostAuthHandoverUrl")
    public void setPostAuthHandoverUrl(String postAuthHandoverUrl) {
        this.postAuthHandoverUrl = postAuthHandoverUrl;
    }

    @JsonProperty("CreatedDateTime")
    public String getCreatedDateTime() {
        return createdDateTime;
    }

    @JsonProperty("CreatedDateTime")
    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @JsonProperty("PaymentMethods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    @JsonProperty("PaymentMethods")
    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @JsonProperty("UpdatedDateTime")
    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    @JsonProperty("UpdatedDateTime")
    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    @JsonProperty("SentToPaymentsLegacy")
    public Boolean getSentToPaymentsLegacy() {
        return sentToPaymentsLegacy;
    }

    @JsonProperty("SentToPaymentsLegacy")
    public void setSentToPaymentsLegacy(Boolean sentToPaymentsLegacy) {
        this.sentToPaymentsLegacy = sentToPaymentsLegacy;
    }

    @JsonProperty("Attempts")
    public List<Attempt> getAttempts() {
        return attempts;
    }

    @JsonProperty("Attempts")
    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
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
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }
}