
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
@JsonPropertyOrder({ "InputPriceId", "PreOrderSecurityModelId", "InputPriceTypeId", "InputPriceSourceId",
        "CanOverrideCatalogPrice", "CatalogOverrideInputPriceTypeId", "DutyRate", "TaxRate", "OtherRate",
        "MatchInputPrice" })
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
    private Object otherRate;
    @JsonProperty("MatchInputPrice")
    private Boolean matchInputPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
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
            Double dutyRate, Double taxRate, Object otherRate, Boolean matchInputPrice) {
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
        this.dutyRate = dutyRate;
    }

    @JsonProperty("TaxRate")
    public Double getTaxRate() {
        return taxRate;
    }

    @JsonProperty("TaxRate")
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @JsonProperty("OtherRate")
    public Object getOtherRate() {
        return otherRate;
    }

    @JsonProperty("OtherRate")
    public void setOtherRate(Object otherRate) {
        this.otherRate = otherRate;
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
