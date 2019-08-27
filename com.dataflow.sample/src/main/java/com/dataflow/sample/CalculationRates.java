
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "ItemVatRateApplied", "DeliveryVatRateApplied", "ItemDutyRateApplied", "DeliveryDutyRateApplied",
        "ItemFeeRateApplied", "DeliveryFeeRateApplied", "ItemReverseCalculationRate",
        "DeliveryReverseCalculationRate" })
@DefaultCoder(SerializableCoder.class)
public class CalculationRates implements Serializable {

    @JsonProperty("ItemVatRateApplied")
    private Double itemVatRateApplied;
    @JsonProperty("DeliveryVatRateApplied")
    private Double deliveryVatRateApplied;
    @JsonProperty("ItemDutyRateApplied")
    private Double itemDutyRateApplied;
    @JsonProperty("DeliveryDutyRateApplied")
    private Double deliveryDutyRateApplied;
    @JsonProperty("ItemFeeRateApplied")
    private Double itemFeeRateApplied;
    @JsonProperty("DeliveryFeeRateApplied")
    private Double deliveryFeeRateApplied;
    @JsonProperty("ReverseItemVatRateApplied")
    private Double reverseItemVatRateApplied;
    @JsonProperty("ReverseDeliveryVatRateApplied")
    private Double reverseDeliveryVatRateApplied;
    @JsonProperty("ReverseItemDutyRateApplied")
    private Double reverseItemDutyRateApplied;
    @JsonProperty("ReverseDeliveryDutyRateApplied")
    private Double reverseDeliveryDutyRateApplied;
    @JsonProperty("ReverseItemFeeRateApplied")
    private Double reverseItemFeeRateApplied;
    @JsonProperty("ReverseDeliveryFeeRateApplied")
    private Double reverseDeliveryFeeRateApplied;

    private final static long serialVersionUID = -1852982147355522267L;

    @JsonProperty("ItemVatRateApplied")
    public Double getItemVatRateApplied() {
        return itemVatRateApplied;
    }

    @JsonProperty("ItemVatRateApplied")
    public void setItemVatRateApplied(Double itemVatRateApplied) {
        this.itemVatRateApplied = Utils.round(itemVatRateApplied);
    }

    @JsonProperty("DeliveryVatRateApplied")
    public Double getDeliveryVatRateApplied() {
        return deliveryVatRateApplied;
    }

    @JsonProperty("DeliveryVatRateApplied")
    public void setDeliveryVatRateApplied(Double deliveryVatRateApplied) {
        this.deliveryVatRateApplied = Utils.round(deliveryVatRateApplied);
    }

    @JsonProperty("ItemDutyRateApplied")
    public Double getItemDutyRateApplied() {
        return itemDutyRateApplied;
    }

    @JsonProperty("ItemDutyRateApplied")
    public void setItemDutyRateApplied(Double itemDutyRateApplied) {
        this.itemDutyRateApplied = Utils.round(itemDutyRateApplied);
    }

    @JsonProperty("DeliveryDutyRateApplied")
    public Double getDeliveryDutyRateApplied() {
        return deliveryDutyRateApplied;
    }

    @JsonProperty("DeliveryDutyRateApplied")
    public void setDeliveryDutyRateApplied(Double deliveryDutyRateApplied) {
        this.deliveryDutyRateApplied = Utils.round(deliveryDutyRateApplied);
    }

    @JsonProperty("ItemFeeRateApplied")
    public Double getItemFeeRateApplied() {
        return itemFeeRateApplied;
    }

    @JsonProperty("ItemFeeRateApplied")
    public void setItemFeeRateApplied(Double itemFeeRateApplied) {
        this.itemFeeRateApplied = Utils.round(itemFeeRateApplied);
    }

    @JsonProperty("DeliveryFeeRateApplied")
    public Double getDeliveryFeeRateApplied() {
        return deliveryFeeRateApplied;
    }

    @JsonProperty("DeliveryFeeRateApplied")
    public void setDeliveryFeeRateApplied(Double deliveryFeeRateApplied) {
        this.deliveryFeeRateApplied = Utils.round(deliveryFeeRateApplied);
    }

    @JsonProperty("ReverseItemVatRateApplied")
    public Double getReverseItemVatRateApplied() {
        return this.reverseItemVatRateApplied;
    }

    @JsonProperty("ReverseItemVatRateApplied")
    public void setReverseItemVatRateApplied(Double reverseItemVatRateApplied) {
        this.reverseItemVatRateApplied = reverseItemVatRateApplied;
    }

    @JsonProperty("ReverseDeliveryVatRateApplied")
    public Double getReverseDeliveryVatRateApplied() {
        return this.reverseDeliveryVatRateApplied;
    }

    @JsonProperty("ReverseDeliveryVatRateApplied")
    public void setReverseDeliveryVatRateApplied(Double reverseDeliveryVatRateApplied) {
        this.reverseDeliveryVatRateApplied = reverseDeliveryVatRateApplied;
    }

    @JsonProperty("ReverseItemDutyRateApplied")
    public Double getReverseItemDutyRateApplied() {
        return this.reverseItemDutyRateApplied;
    }

    @JsonProperty("ReverseItemDutyRateApplied")
    public void setReverseItemDutyRateApplied(Double reverseItemDutyRateApplied) {
        this.reverseItemDutyRateApplied = reverseItemDutyRateApplied;
    }

    @JsonProperty("ReverseDeliveryDutyRateApplied")
    public Double getReverseDeliveryDutyRateApplied() {
        return this.reverseDeliveryDutyRateApplied;
    }

    @JsonProperty("ReverseDeliveryDutyRateApplied")
    public void setReverseDeliveryDutyRateApplied(Double reverseDeliveryDutyRateApplied) {
        this.reverseDeliveryDutyRateApplied = reverseDeliveryDutyRateApplied;
    }

    @JsonProperty("ReverseItemFeeRateApplied")
    public Double getReverseItemFeeRateApplied() {
        return this.reverseItemFeeRateApplied;
    }

    @JsonProperty("ReverseItemFeeRateApplied")
    public void setReverseItemFeeRateApplied(Double reverseItemFeeRateApplied) {
        this.reverseItemFeeRateApplied = reverseItemFeeRateApplied;
    }

    @JsonProperty("ReverseDeliveryFeeRateApplied")
    public Double getReverseDeliveryFeeRateApplied() {
        return this.reverseDeliveryFeeRateApplied;
    }

    @JsonProperty("ReverseDeliveryFeeRateApplied")
    public void setReverseDeliveryFeeRateApplied(Double reverseDeliveryFeeRateApplied) {
        this.reverseDeliveryFeeRateApplied = reverseDeliveryFeeRateApplied;
    }
}
