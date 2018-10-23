package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Payment implements Serializable {
    private String PaymentId;
    private String PaymentAttemptRef;
    private String PaymentFraudStatusId = null;
    private String AuthCode = null;
    private String State;
    private String PaymentGatewayCode = null;
    private String PaymentMethodCode = null;
    private String AuthorizationDetails = null;
    private String PaymentTime = null;
    private boolean IsPaymentSuccessful;

    // Getter Methods

    public String getPaymentId() {
        return PaymentId;
    }

    public String getPaymentAttemptRef() {
        return PaymentAttemptRef;
    }

    public String getPaymentFraudStatusId() {
        return PaymentFraudStatusId;
    }

    public String getAuthCode() {
        return AuthCode;
    }

    public String getState() {
        return State;
    }

    public String getPaymentGatewayCode() {
        return PaymentGatewayCode;
    }

    public String getPaymentMethodCode() {
        return PaymentMethodCode;
    }

    public String getAuthorizationDetails() {
        return AuthorizationDetails;
    }

    public String getPaymentTime() {
        return PaymentTime;
    }

    public boolean getIsPaymentSuccessful() {
        return IsPaymentSuccessful;
    }

    // Setter Methods

    public void setPaymentId(String PaymentId) {
        this.PaymentId = PaymentId;
    }

    public void setPaymentAttemptRef(String PaymentAttemptRef) {
        this.PaymentAttemptRef = PaymentAttemptRef;
    }

    public void setPaymentFraudStatusId(String PaymentFraudStatusId) {
        this.PaymentFraudStatusId = PaymentFraudStatusId;
    }

    public void setAuthCode(String AuthCode) {
        this.AuthCode = AuthCode;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setPaymentGatewayCode(String PaymentGatewayCode) {
        this.PaymentGatewayCode = PaymentGatewayCode;
    }

    public void setPaymentMethodCode(String PaymentMethodCode) {
        this.PaymentMethodCode = PaymentMethodCode;
    }

    public void setAuthorizationDetails(String AuthorizationDetails) {
        this.AuthorizationDetails = AuthorizationDetails;
    }

    public void setPaymentTime(String PaymentTime) {
        this.PaymentTime = PaymentTime;
    }

    public void setIsPaymentSuccessful(boolean IsPaymentSuccessful) {
        this.IsPaymentSuccessful = IsPaymentSuccessful;
    }
}