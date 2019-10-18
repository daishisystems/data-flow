package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "paymentProfileId", "orderRef", "paymentResultUrl", "authorizationUrl",
        "postAuthHandoverUrl" })
public class MasterPayment implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("paymentProfileId")
    private String paymentProfileId;
    @JsonProperty("orderRef")
    private String orderRef;
    @JsonProperty("paymentResultUrl")
    private String paymentResultUrl;
    @JsonProperty("authorizationUrl")
    private String authorizationUrl;
    @JsonProperty("postAuthHandoverUrl")
    private String postAuthHandoverUrl;
    private final static long serialVersionUID = 6130777216195902623L;
    @JsonProperty("created")
    private Long created;

    @JsonProperty("created")
    public Long getCreated() {
        return this.created;
    }

    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("paymentProfileId")
    public String getPaymentProfileId() {
        return paymentProfileId;
    }

    @JsonProperty("paymentProfileId")
    public void setPaymentProfileId(String paymentProfileId) {
        this.paymentProfileId = paymentProfileId;
    }

    @JsonProperty("orderRef")
    public String getOrderRef() {
        return orderRef;
    }

    @JsonProperty("orderRef")
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    @JsonProperty("paymentResultUrl")
    public String getPaymentResultUrl() {
        return paymentResultUrl;
    }

    @JsonProperty("paymentResultUrl")
    public void setPaymentResultUrl(String paymentResultUrl) {
        this.paymentResultUrl = paymentResultUrl;
    }

    @JsonProperty("authorizationUrl")
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    @JsonProperty("authorizationUrl")
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    @JsonProperty("postAuthHandoverUrl")
    public String getPostAuthHandoverUrl() {
        return postAuthHandoverUrl;
    }

    @JsonProperty("postAuthHandoverUrl")
    public void setPostAuthHandoverUrl(String postAuthHandoverUrl) {
        this.postAuthHandoverUrl = postAuthHandoverUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("paymentProfileId", paymentProfileId)
                .append("orderRef", orderRef).append("paymentResultUrl", paymentResultUrl)
                .append("authorizationUrl", authorizationUrl).append("postAuthHandoverUrl", postAuthHandoverUrl)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(postAuthHandoverUrl).append(authorizationUrl)
                .append(paymentProfileId).append(orderRef).append(paymentResultUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MasterPayment) == false) {
            return false;
        }
        MasterPayment rhs = ((MasterPayment) other);
        return new EqualsBuilder().append(id, rhs.id).append(postAuthHandoverUrl, rhs.postAuthHandoverUrl)
                .append(authorizationUrl, rhs.authorizationUrl).append(paymentProfileId, rhs.paymentProfileId)
                .append(orderRef, rhs.orderRef).append(paymentResultUrl, rhs.paymentResultUrl).isEquals();
    }

}