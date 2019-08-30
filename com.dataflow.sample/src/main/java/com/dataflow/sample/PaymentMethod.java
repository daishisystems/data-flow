
package com.dataflow.sample;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "paymentMethods" })
public class PaymentMethod implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("paymentMethods")
    private List<PaymentMethod_> paymentMethods = null;
    private final static long serialVersionUID = 6144770255368499733L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("paymentMethods")
    public List<PaymentMethod_> getPaymentMethods() {
        return paymentMethods;
    }

    @JsonProperty("paymentMethods")
    public void setPaymentMethods(List<PaymentMethod_> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("paymentMethods", paymentMethods).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(paymentMethods).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentMethod) == false) {
            return false;
        }
        PaymentMethod rhs = ((PaymentMethod) other);
        return new EqualsBuilder().append(id, rhs.id).append(paymentMethods, rhs.paymentMethods).isEquals();
    }

}
