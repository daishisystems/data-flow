
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class PaymentOrderItem implements Serializable {
    @JsonProperty("OrderItemId")
    private Integer orderItemId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("SequenceNumber")
    private Integer sequenceNumber;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("ProductCode")
    private String productCode;
    @JsonProperty("UnitPriceExCharges")
    private Double unitPriceExCharges;
    @JsonProperty("UnitShippingCharge")
    private Double unitShippingCharge;
    @JsonProperty("UnitTaxCharge")
    private Double unitTaxCharge;
    private final static long serialVersionUID = 6993863613944046365L;

    @JsonProperty("OrderItemId")
    public Integer getOrderItemId() {
        return orderItemId;
    }

    @JsonProperty("OrderItemId")
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("SequenceNumber")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("SequenceNumber")
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("ProductCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("ProductCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("UnitPriceExCharges")
    public Double getUnitPriceExCharges() {
        return unitPriceExCharges;
    }

    @JsonProperty("UnitPriceExCharges")
    public void setUnitPriceExCharges(Double unitPriceExCharges) {
        this.unitPriceExCharges = unitPriceExCharges;
    }

    @JsonProperty("UnitShippingCharge")
    public Double getUnitShippingCharge() {
        return unitShippingCharge;
    }

    @JsonProperty("UnitShippingCharge")
    public void setUnitShippingCharge(Double unitShippingCharge) {
        this.unitShippingCharge = unitShippingCharge;
    }

    @JsonProperty("UnitTaxCharge")
    public Double getUnitTaxCharge() {
        return unitTaxCharge;
    }

    @JsonProperty("UnitTaxCharge")
    public void setUnitTaxCharge(Double unitTaxCharge) {
        this.unitTaxCharge = unitTaxCharge;
    }
}