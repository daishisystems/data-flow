
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "paymentOrderItemId", "name", "description", "sequenceNumber", "quantity", "productCode",
        "unitPriceExCharges", "unitShippingCharge", "unitTaxCharge" })
public class PaymentOrderItem implements Serializable {

    @JsonProperty("paymentOrderItemId")
    private int paymentOrderItemId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("sequenceNumber")
    private int sequenceNumber;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("unitPriceExCharges")
    private int unitPriceExCharges;
    @JsonProperty("unitShippingCharge")
    private int unitShippingCharge;
    @JsonProperty("unitTaxCharge")
    private int unitTaxCharge;
    private final static long serialVersionUID = 3309356415412337905L;

    @JsonProperty("paymentOrderItemId")
    public int getPaymentOrderItemId() {
        return paymentOrderItemId;
    }

    @JsonProperty("paymentOrderItemId")
    public void setPaymentOrderItemId(int paymentOrderItemId) {
        this.paymentOrderItemId = paymentOrderItemId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("sequenceNumber")
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("sequenceNumber")
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @JsonProperty("quantity")
    public int getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("unitPriceExCharges")
    public int getUnitPriceExCharges() {
        return unitPriceExCharges;
    }

    @JsonProperty("unitPriceExCharges")
    public void setUnitPriceExCharges(int unitPriceExCharges) {
        this.unitPriceExCharges = unitPriceExCharges;
    }

    @JsonProperty("unitShippingCharge")
    public int getUnitShippingCharge() {
        return unitShippingCharge;
    }

    @JsonProperty("unitShippingCharge")
    public void setUnitShippingCharge(int unitShippingCharge) {
        this.unitShippingCharge = unitShippingCharge;
    }

    @JsonProperty("unitTaxCharge")
    public int getUnitTaxCharge() {
        return unitTaxCharge;
    }

    @JsonProperty("unitTaxCharge")
    public void setUnitTaxCharge(int unitTaxCharge) {
        this.unitTaxCharge = unitTaxCharge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("PaymentOrderItemId", paymentOrderItemId).append("name", name)
                .append("description", description).append("sequenceNumber", sequenceNumber)
                .append("quantity", quantity).append("productCode", productCode)
                .append("unitPriceExCharges", unitPriceExCharges).append("unitShippingCharge", unitShippingCharge)
                .append("unitTaxCharge", unitTaxCharge).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unitTaxCharge).append(unitPriceExCharges).append(productCode)
                .append(paymentOrderItemId).append(name).append(quantity).append(unitShippingCharge)
                .append(sequenceNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentOrderItem) == false) {
            return false;
        }
        PaymentOrderItem rhs = ((PaymentOrderItem) other);
        return new EqualsBuilder().append(unitTaxCharge, rhs.unitTaxCharge)
                .append(unitPriceExCharges, rhs.unitPriceExCharges).append(productCode, rhs.productCode)
                .append(paymentOrderItemId, rhs.paymentOrderItemId).append(description, rhs.description)
                .append(name, rhs.name).append(quantity, rhs.quantity)
                .append(unitShippingCharge, rhs.unitShippingCharge).append(sequenceNumber, rhs.sequenceNumber)
                .isEquals();
    }

}
