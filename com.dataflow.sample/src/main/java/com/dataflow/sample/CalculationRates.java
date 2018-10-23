
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
@JsonPropertyOrder({ "ItemVatRateApplied", "DeliveryVatRateApplied", "ItemDutyRateApplied", "DeliveryDutyRateApplied",
        "ItemFeeRateApplied", "DeliveryFeeRateApplied", "ItemReverseCalculationRate",
        "DeliveryReverseCalculationRate" })
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
    @JsonProperty("ItemReverseCalculationRate")
    private Double itemReverseCalculationRate;
    @JsonProperty("DeliveryReverseCalculationRate")
    private Double deliveryReverseCalculationRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1852982147355522267L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CalculationRates() {
    }

    /**
     * 
     * @param deliveryVatRateApplied
     * @param deliveryReverseCalculationRate
     * @param itemVatRateApplied
     * @param itemFeeRateApplied
     * @param itemReverseCalculationRate
     * @param deliveryDutyRateApplied
     * @param deliveryFeeRateApplied
     * @param itemDutyRateApplied
     */
    public CalculationRates(Double itemVatRateApplied, Double deliveryVatRateApplied, Double itemDutyRateApplied,
            Double deliveryDutyRateApplied, Double itemFeeRateApplied, Double deliveryFeeRateApplied,
            Double itemReverseCalculationRate, Double deliveryReverseCalculationRate) {
        super();
        this.itemVatRateApplied = itemVatRateApplied;
        this.deliveryVatRateApplied = deliveryVatRateApplied;
        this.itemDutyRateApplied = itemDutyRateApplied;
        this.deliveryDutyRateApplied = deliveryDutyRateApplied;
        this.itemFeeRateApplied = itemFeeRateApplied;
        this.deliveryFeeRateApplied = deliveryFeeRateApplied;
        this.itemReverseCalculationRate = itemReverseCalculationRate;
        this.deliveryReverseCalculationRate = deliveryReverseCalculationRate;
    }

    @JsonProperty("ItemVatRateApplied")
    public Double getItemVatRateApplied() {
        return itemVatRateApplied;
    }

    @JsonProperty("ItemVatRateApplied")
    public void setItemVatRateApplied(Double itemVatRateApplied) {
        this.itemVatRateApplied = itemVatRateApplied;
    }

    @JsonProperty("DeliveryVatRateApplied")
    public Double getDeliveryVatRateApplied() {
        return deliveryVatRateApplied;
    }

    @JsonProperty("DeliveryVatRateApplied")
    public void setDeliveryVatRateApplied(Double deliveryVatRateApplied) {
        this.deliveryVatRateApplied = deliveryVatRateApplied;
    }

    @JsonProperty("ItemDutyRateApplied")
    public Double getItemDutyRateApplied() {
        return itemDutyRateApplied;
    }

    @JsonProperty("ItemDutyRateApplied")
    public void setItemDutyRateApplied(Double itemDutyRateApplied) {
        this.itemDutyRateApplied = itemDutyRateApplied;
    }

    @JsonProperty("DeliveryDutyRateApplied")
    public Double getDeliveryDutyRateApplied() {
        return deliveryDutyRateApplied;
    }

    @JsonProperty("DeliveryDutyRateApplied")
    public void setDeliveryDutyRateApplied(Double deliveryDutyRateApplied) {
        this.deliveryDutyRateApplied = deliveryDutyRateApplied;
    }

    @JsonProperty("ItemFeeRateApplied")
    public Double getItemFeeRateApplied() {
        return itemFeeRateApplied;
    }

    @JsonProperty("ItemFeeRateApplied")
    public void setItemFeeRateApplied(Double itemFeeRateApplied) {
        this.itemFeeRateApplied = itemFeeRateApplied;
    }

    @JsonProperty("DeliveryFeeRateApplied")
    public Double getDeliveryFeeRateApplied() {
        return deliveryFeeRateApplied;
    }

    @JsonProperty("DeliveryFeeRateApplied")
    public void setDeliveryFeeRateApplied(Double deliveryFeeRateApplied) {
        this.deliveryFeeRateApplied = deliveryFeeRateApplied;
    }

    @JsonProperty("ItemReverseCalculationRate")
    public Double getItemReverseCalculationRate() {
        return itemReverseCalculationRate;
    }

    @JsonProperty("ItemReverseCalculationRate")
    public void setItemReverseCalculationRate(Double itemReverseCalculationRate) {
        this.itemReverseCalculationRate = itemReverseCalculationRate;
    }

    @JsonProperty("DeliveryReverseCalculationRate")
    public Double getDeliveryReverseCalculationRate() {
        return deliveryReverseCalculationRate;
    }

    @JsonProperty("DeliveryReverseCalculationRate")
    public void setDeliveryReverseCalculationRate(Double deliveryReverseCalculationRate) {
        this.deliveryReverseCalculationRate = deliveryReverseCalculationRate;
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
