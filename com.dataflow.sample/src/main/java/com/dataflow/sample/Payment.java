
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

@JsonPropertyOrder({ "PaymentId", "PaymentAttemptRef", "PaymentFraudStatusId", "AuthCode", "State",
        "PaymentGatewayCode", "PaymentMethodCode", "AuthorizationDetails", "PaymentTime", "IsPaymentSuccessful" })
@DefaultCoder(SerializableCoder.class)
public class Payment implements Serializable {

    @JsonProperty("PaymentId")
    private String paymentId;
    @JsonProperty("PaymentAttemptRef")
    private String paymentAttemptRef;
    @JsonProperty("PaymentFraudStatusId")
    private Object paymentFraudStatusId;
    @JsonProperty("AuthCode")
    private Object authCode;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PaymentGatewayCode")
    private Object paymentGatewayCode;
    @JsonProperty("PaymentMethodCode")
    private Object paymentMethodCode;
    @JsonProperty("AuthorizationDetails")
    private Object authorizationDetails;
    @JsonProperty("PaymentTime")
    private Object paymentTime;
    @JsonProperty("IsPaymentSuccessful")
    private Boolean isPaymentSuccessful;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2148568030482404120L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Payment() {
    }

    /**
     * 
     * @param authCode
     * @param paymentMethodCode
     * @param paymentId
     * @param paymentTime
     * @param state
     * @param paymentAttemptRef
     * @param authorizationDetails
     * @param paymentGatewayCode
     * @param isPaymentSuccessful
     * @param paymentFraudStatusId
     */
    public Payment(String paymentId, String paymentAttemptRef, Object paymentFraudStatusId, Object authCode,
            String state, Object paymentGatewayCode, Object paymentMethodCode, Object authorizationDetails,
            Object paymentTime, Boolean isPaymentSuccessful) {
        super();
        this.paymentId = paymentId;
        this.paymentAttemptRef = paymentAttemptRef;
        this.paymentFraudStatusId = paymentFraudStatusId;
        this.authCode = authCode;
        this.state = state;
        this.paymentGatewayCode = paymentGatewayCode;
        this.paymentMethodCode = paymentMethodCode;
        this.authorizationDetails = authorizationDetails;
        this.paymentTime = paymentTime;
        this.isPaymentSuccessful = isPaymentSuccessful;
    }

    @JsonProperty("PaymentId")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("PaymentId")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("PaymentAttemptRef")
    public String getPaymentAttemptRef() {
        return paymentAttemptRef;
    }

    @JsonProperty("PaymentAttemptRef")
    public void setPaymentAttemptRef(String paymentAttemptRef) {
        this.paymentAttemptRef = paymentAttemptRef;
    }

    @JsonProperty("PaymentFraudStatusId")
    public Object getPaymentFraudStatusId() {
        return paymentFraudStatusId;
    }

    @JsonProperty("PaymentFraudStatusId")
    public void setPaymentFraudStatusId(Object paymentFraudStatusId) {
        this.paymentFraudStatusId = paymentFraudStatusId;
    }

    @JsonProperty("AuthCode")
    public Object getAuthCode() {
        return authCode;
    }

    @JsonProperty("AuthCode")
    public void setAuthCode(Object authCode) {
        this.authCode = authCode;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("PaymentGatewayCode")
    public Object getPaymentGatewayCode() {
        return paymentGatewayCode;
    }

    @JsonProperty("PaymentGatewayCode")
    public void setPaymentGatewayCode(Object paymentGatewayCode) {
        this.paymentGatewayCode = paymentGatewayCode;
    }

    @JsonProperty("PaymentMethodCode")
    public Object getPaymentMethodCode() {
        return paymentMethodCode;
    }

    @JsonProperty("PaymentMethodCode")
    public void setPaymentMethodCode(Object paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @JsonProperty("AuthorizationDetails")
    public Object getAuthorizationDetails() {
        return authorizationDetails;
    }

    @JsonProperty("AuthorizationDetails")
    public void setAuthorizationDetails(Object authorizationDetails) {
        this.authorizationDetails = authorizationDetails;
    }

    @JsonProperty("PaymentTime")
    public Object getPaymentTime() {
        return paymentTime;
    }

    @JsonProperty("PaymentTime")
    public void setPaymentTime(Object paymentTime) {
        this.paymentTime = paymentTime;
    }

    @JsonProperty("IsPaymentSuccessful")
    public Boolean getIsPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    @JsonProperty("IsPaymentSuccessful")
    public void setIsPaymentSuccessful(Boolean isPaymentSuccessful) {
        this.isPaymentSuccessful = isPaymentSuccessful;
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
