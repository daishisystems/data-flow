
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "InputPriceId", "PreOrderSecurityModelId", "InputPriceTypeId", "InputPriceSourceId",
        "CanOverrideCatalogPrice", "CatalogOverrideInputPriceTypeId", "DutyRate", "TaxRate", "OtherRate",
        "MatchInputPrice" })
@DefaultCoder(SerializableCoder.class)
public class ProductInput implements Serializable {

    @JsonProperty("InputPriceId")
    private Integer inputPriceId;
    @JsonProperty("PreOrderSecurityModelId")
    private Integer preOrderSecurityModelId;
    @JsonProperty("InputPriceTypeId")
    private Integer inputPriceTypeId;
    @JsonProperty("InputPriceSourceId")
    private Integer inputPriceSourceId;
    @JsonProperty("CanOverrideCatalogPrice")
    private Boolean canOverrideCatalogPrice;
    @JsonProperty("CatalogOverrideInputPriceTypeId")
    private Integer catalogOverrideInputPriceTypeId;
    @JsonProperty("DutyRate")
    private Double dutyRate;
    @JsonProperty("TaxRate")
    private Double taxRate;
    @JsonProperty("OtherRate")
    private Double otherRate;
    @JsonProperty("MatchInputPrice")
    private Boolean matchInputPrice;
    private final static long serialVersionUID = -8964358742348025189L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductInput() {
    }

    /**
     * 
     * @param taxRate
     * @param matchInputPrice
     * @param preOrderSecurityModelId
     * @param inputPriceId
     * @param inputPriceSourceId
     * @param otherRate
     * @param inputPriceTypeId
     * @param dutyRate
     * @param canOverrideCatalogPrice
     * @param catalogOverrideInputPriceTypeId
     */
    public ProductInput(Integer inputPriceId, Integer preOrderSecurityModelId, Integer inputPriceTypeId,
            Integer inputPriceSourceId, Boolean canOverrideCatalogPrice, Integer catalogOverrideInputPriceTypeId,
            Double dutyRate, Double taxRate, Double otherRate, Boolean matchInputPrice) {
        super();
        this.inputPriceId = inputPriceId;
        this.preOrderSecurityModelId = preOrderSecurityModelId;
        this.inputPriceTypeId = inputPriceTypeId;
        this.inputPriceSourceId = inputPriceSourceId;
        this.canOverrideCatalogPrice = canOverrideCatalogPrice;
        this.catalogOverrideInputPriceTypeId = catalogOverrideInputPriceTypeId;
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

    @JsonProperty("CanOverrideCatalogPrice")
    public Boolean getCanOverrideCatalogPrice() {
        return canOverrideCatalogPrice;
    }

    @JsonProperty("CanOverrideCatalogPrice")
    public void setCanOverrideCatalogPrice(Boolean canOverrideCatalogPrice) {
        this.canOverrideCatalogPrice = canOverrideCatalogPrice;
    }

    @JsonProperty("CatalogOverrideInputPriceTypeId")
    public Integer getCatalogOverrideInputPriceTypeId() {
        return catalogOverrideInputPriceTypeId;
    }

    @JsonProperty("CatalogOverrideInputPriceTypeId")
    public void setCatalogOverrideInputPriceTypeId(Integer catalogOverrideInputPriceTypeId) {
        this.catalogOverrideInputPriceTypeId = catalogOverrideInputPriceTypeId;
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
}
