
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

@JsonPropertyOrder({ "InputPriceId", "PreOrderSecurityModelId", "InputPriceTypeId", "InputPriceSourceId",
        "CanOverrideShippingPrice", "ShippingOverrideInputPriceTypeId", "DutyRate", "TaxRate", "OtherRate",
        "MatchInputPrice" })
@DefaultCoder(SerializableCoder.class)
public class DeliveryInput implements Serializable {

    @JsonProperty("InputPriceId")
    private Integer inputPriceId;
    @JsonProperty("PreOrderSecurityModelId")
    private Integer preOrderSecurityModelId;
    @JsonProperty("InputPriceTypeId")
    private Integer inputPriceTypeId;
    @JsonProperty("InputPriceSourceId")
    private Integer inputPriceSourceId;
    @JsonProperty("CanOverrideShippingPrice")
    private Boolean canOverrideShippingPrice;
    @JsonProperty("ShippingOverrideInputPriceTypeId")
    private Integer shippingOverrideInputPriceTypeId;
    @JsonProperty("DutyRate")
    private Double dutyRate;
    @JsonProperty("TaxRate")
    private Double taxRate;
    @JsonProperty("OtherRate")
    private Double otherRate;
    @JsonProperty("MatchInputPrice")
    private Boolean matchInputPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5498438466502887917L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryInput() {
    }

    /**
     * 
     * @param shippingOverrideInputPriceTypeId
     * @param taxRate
     * @param matchInputPrice
     * @param preOrderSecurityModelId
     * @param inputPriceId
     * @param inputPriceSourceId
     * @param otherRate
     * @param inputPriceTypeId
     * @param dutyRate
     * @param canOverrideShippingPrice
     */
    public DeliveryInput(Integer inputPriceId, Integer preOrderSecurityModelId, Integer inputPriceTypeId,
            Integer inputPriceSourceId, Boolean canOverrideShippingPrice, Integer shippingOverrideInputPriceTypeId,
            Double dutyRate, Double taxRate, Double otherRate, Boolean matchInputPrice) {
        super();
        this.inputPriceId = inputPriceId;
        this.preOrderSecurityModelId = preOrderSecurityModelId;
        this.inputPriceTypeId = inputPriceTypeId;
        this.inputPriceSourceId = inputPriceSourceId;
        this.canOverrideShippingPrice = canOverrideShippingPrice;
        this.shippingOverrideInputPriceTypeId = shippingOverrideInputPriceTypeId;
        this.dutyRate = dutyRate;
        this.taxRate = taxRate;
        this.otherRate = otherRate;
        this.matchInputPrice = matchInputPrice;
    }

    @JsonProperty("InputPriceId")
    public Integer getInputPriceId() {
        return inputPriceId;
    }

    @JsonProperty("InputPriceId")
    public void setInputPriceId(Integer inputPriceId) {
        this.inputPriceId = inputPriceId;
    }

    @JsonProperty("PreOrderSecurityModelId")
    public Integer getPreOrderSecurityModelId() {
        return preOrderSecurityModelId;
    }

    @JsonProperty("PreOrderSecurityModelId")
    public void setPreOrderSecurityModelId(Integer preOrderSecurityModelId) {
        this.preOrderSecurityModelId = preOrderSecurityModelId;
    }

    @JsonProperty("InputPriceTypeId")
    public Integer getInputPriceTypeId() {
        return inputPriceTypeId;
    }

    @JsonProperty("InputPriceTypeId")
    public void setInputPriceTypeId(Integer inputPriceTypeId) {
        this.inputPriceTypeId = inputPriceTypeId;
    }

    @JsonProperty("InputPriceSourceId")
    public Integer getInputPriceSourceId() {
        return inputPriceSourceId;
    }

    @JsonProperty("InputPriceSourceId")
    public void setInputPriceSourceId(Integer inputPriceSourceId) {
        this.inputPriceSourceId = inputPriceSourceId;
    }

    @JsonProperty("CanOverrideShippingPrice")
    public Boolean getCanOverrideShippingPrice() {
        return canOverrideShippingPrice;
    }

    @JsonProperty("CanOverrideShippingPrice")
    public void setCanOverrideShippingPrice(Boolean canOverrideShippingPrice) {
        this.canOverrideShippingPrice = canOverrideShippingPrice;
    }

    @JsonProperty("ShippingOverrideInputPriceTypeId")
    public Integer getShippingOverrideInputPriceTypeId() {
        return shippingOverrideInputPriceTypeId;
    }

    @JsonProperty("ShippingOverrideInputPriceTypeId")
    public void setShippingOverrideInputPriceTypeId(Integer shippingOverrideInputPriceTypeId) {
        this.shippingOverrideInputPriceTypeId = shippingOverrideInputPriceTypeId;
    }

    @JsonProperty("DutyRate")
    public Double getDutyRate() {
        return dutyRate;
    }

    @JsonProperty("DutyRate")
    public void setDutyRate(Double dutyRate) {
        this.dutyRate = Utils.round(dutyRate);
    }

    @JsonProperty("TaxRate")
    public Double getTaxRate() {
        return taxRate;
    }

    @JsonProperty("TaxRate")
    public void setTaxRate(Double taxRate) {
        this.taxRate = Utils.round(taxRate);
    }

    @JsonProperty("OtherRate")
    public Double getOtherRate() {
        return otherRate;
    }

    @JsonProperty("OtherRate")
    public void setOtherRate(Double otherRate) {
        this.otherRate = Utils.round(otherRate);
    }

    @JsonProperty("MatchInputPrice")
    public Boolean getMatchInputPrice() {
        return matchInputPrice;
    }

    @JsonProperty("MatchInputPrice")
    public void setMatchInputPrice(Boolean matchInputPrice) {
        this.matchInputPrice = matchInputPrice;
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
