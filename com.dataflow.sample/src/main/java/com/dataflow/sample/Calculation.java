
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

@JsonPropertyOrder({ "BrandCountryCalculationId", "DutyTaxCalculationModelId", "IsAccurateCalculationRequired",
        "IsReverseAccurateCalculationRequired", "IsReverseEstimatedCalculationRequired",
        "IsReverseTaxesCalculationRequired", "IsReverseDutyCalculationRequired", "EstimatedDutyRate",
        "EstimatedTaxRate", "BrandCountryMarkupId", "MarkupPercentage", "PricingGroupId", "CustomsCalculationType" })
@DefaultCoder(SerializableCoder.class)
public class Calculation implements Serializable {

    @JsonProperty("BrandCountryCalculationId")
    private Integer brandCountryCalculationId;
    @JsonProperty("DutyTaxCalculationModelId")
    private Integer dutyTaxCalculationModelId;
    @JsonProperty("IsAccurateCalculationRequired")
    private Boolean isAccurateCalculationRequired;
    @JsonProperty("IsReverseAccurateCalculationRequired")
    private Object isReverseAccurateCalculationRequired;
    @JsonProperty("IsReverseEstimatedCalculationRequired")
    private Object isReverseEstimatedCalculationRequired;
    @JsonProperty("IsReverseTaxesCalculationRequired")
    private Object isReverseTaxesCalculationRequired;
    @JsonProperty("IsReverseDutyCalculationRequired")
    private Object isReverseDutyCalculationRequired;
    @JsonProperty("EstimatedDutyRate")
    private Double estimatedDutyRate;
    @JsonProperty("EstimatedTaxRate")
    private Double estimatedTaxRate;
    @JsonProperty("BrandCountryMarkupId")
    private Integer brandCountryMarkupId;
    @JsonProperty("MarkupPercentage")
    private Object markupPercentage;
    @JsonProperty("PricingGroupId")
    private Integer pricingGroupId;
    @JsonProperty("CustomsCalculationType")
    private String customsCalculationType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7006935580647199399L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Calculation() {
    }

    /**
     * 
     * @param isReverseAccurateCalculationRequired
     * @param estimatedTaxRate
     * @param isAccurateCalculationRequired
     * @param isReverseDutyCalculationRequired
     * @param brandCountryMarkupId
     * @param brandCountryCalculationId
     * @param dutyTaxCalculationModelId
     * @param pricingGroupId
     * @param isReverseTaxesCalculationRequired
     * @param customsCalculationType
     * @param isReverseEstimatedCalculationRequired
     * @param markupPercentage
     * @param estimatedDutyRate
     */
    public Calculation(Integer brandCountryCalculationId, Integer dutyTaxCalculationModelId,
            Boolean isAccurateCalculationRequired, Object isReverseAccurateCalculationRequired,
            Object isReverseEstimatedCalculationRequired, Object isReverseTaxesCalculationRequired,
            Object isReverseDutyCalculationRequired, Double estimatedDutyRate, Double estimatedTaxRate,
            Integer brandCountryMarkupId, Object markupPercentage, Integer pricingGroupId,
            String customsCalculationType) {
        super();
        this.brandCountryCalculationId = brandCountryCalculationId;
        this.dutyTaxCalculationModelId = dutyTaxCalculationModelId;
        this.isAccurateCalculationRequired = isAccurateCalculationRequired;
        this.isReverseAccurateCalculationRequired = isReverseAccurateCalculationRequired;
        this.isReverseEstimatedCalculationRequired = isReverseEstimatedCalculationRequired;
        this.isReverseTaxesCalculationRequired = isReverseTaxesCalculationRequired;
        this.isReverseDutyCalculationRequired = isReverseDutyCalculationRequired;
        this.estimatedDutyRate = estimatedDutyRate;
        this.estimatedTaxRate = estimatedTaxRate;
        this.brandCountryMarkupId = brandCountryMarkupId;
        this.markupPercentage = markupPercentage;
        this.pricingGroupId = pricingGroupId;
        this.customsCalculationType = customsCalculationType;
    }

    @JsonProperty("BrandCountryCalculationId")
    public Integer getBrandCountryCalculationId() {
        return brandCountryCalculationId;
    }

    @JsonProperty("BrandCountryCalculationId")
    public void setBrandCountryCalculationId(Integer brandCountryCalculationId) {
        this.brandCountryCalculationId = brandCountryCalculationId;
    }

    @JsonProperty("DutyTaxCalculationModelId")
    public Integer getDutyTaxCalculationModelId() {
        return dutyTaxCalculationModelId;
    }

    @JsonProperty("DutyTaxCalculationModelId")
    public void setDutyTaxCalculationModelId(Integer dutyTaxCalculationModelId) {
        this.dutyTaxCalculationModelId = dutyTaxCalculationModelId;
    }

    @JsonProperty("IsAccurateCalculationRequired")
    public Boolean getIsAccurateCalculationRequired() {
        return isAccurateCalculationRequired;
    }

    @JsonProperty("IsAccurateCalculationRequired")
    public void setIsAccurateCalculationRequired(Boolean isAccurateCalculationRequired) {
        this.isAccurateCalculationRequired = isAccurateCalculationRequired;
    }

    @JsonProperty("IsReverseAccurateCalculationRequired")
    public Object getIsReverseAccurateCalculationRequired() {
        return isReverseAccurateCalculationRequired;
    }

    @JsonProperty("IsReverseAccurateCalculationRequired")
    public void setIsReverseAccurateCalculationRequired(Object isReverseAccurateCalculationRequired) {
        this.isReverseAccurateCalculationRequired = isReverseAccurateCalculationRequired;
    }

    @JsonProperty("IsReverseEstimatedCalculationRequired")
    public Object getIsReverseEstimatedCalculationRequired() {
        return isReverseEstimatedCalculationRequired;
    }

    @JsonProperty("IsReverseEstimatedCalculationRequired")
    public void setIsReverseEstimatedCalculationRequired(Object isReverseEstimatedCalculationRequired) {
        this.isReverseEstimatedCalculationRequired = isReverseEstimatedCalculationRequired;
    }

    @JsonProperty("IsReverseTaxesCalculationRequired")
    public Object getIsReverseTaxesCalculationRequired() {
        return isReverseTaxesCalculationRequired;
    }

    @JsonProperty("IsReverseTaxesCalculationRequired")
    public void setIsReverseTaxesCalculationRequired(Object isReverseTaxesCalculationRequired) {
        this.isReverseTaxesCalculationRequired = isReverseTaxesCalculationRequired;
    }

    @JsonProperty("IsReverseDutyCalculationRequired")
    public Object getIsReverseDutyCalculationRequired() {
        return isReverseDutyCalculationRequired;
    }

    @JsonProperty("IsReverseDutyCalculationRequired")
    public void setIsReverseDutyCalculationRequired(Object isReverseDutyCalculationRequired) {
        this.isReverseDutyCalculationRequired = isReverseDutyCalculationRequired;
    }

    @JsonProperty("EstimatedDutyRate")
    public Double getEstimatedDutyRate() {
        return estimatedDutyRate;
    }

    @JsonProperty("EstimatedDutyRate")
    public void setEstimatedDutyRate(Double estimatedDutyRate) {
        this.estimatedDutyRate = estimatedDutyRate;
    }

    @JsonProperty("EstimatedTaxRate")
    public Double getEstimatedTaxRate() {
        return estimatedTaxRate;
    }

    @JsonProperty("EstimatedTaxRate")
    public void setEstimatedTaxRate(Double estimatedTaxRate) {
        this.estimatedTaxRate = estimatedTaxRate;
    }

    @JsonProperty("BrandCountryMarkupId")
    public Integer getBrandCountryMarkupId() {
        return brandCountryMarkupId;
    }

    @JsonProperty("BrandCountryMarkupId")
    public void setBrandCountryMarkupId(Integer brandCountryMarkupId) {
        this.brandCountryMarkupId = brandCountryMarkupId;
    }

    @JsonProperty("MarkupPercentage")
    public Object getMarkupPercentage() {
        return markupPercentage;
    }

    @JsonProperty("MarkupPercentage")
    public void setMarkupPercentage(Object markupPercentage) {
        this.markupPercentage = markupPercentage;
    }

    @JsonProperty("PricingGroupId")
    public Integer getPricingGroupId() {
        return pricingGroupId;
    }

    @JsonProperty("PricingGroupId")
    public void setPricingGroupId(Integer pricingGroupId) {
        this.pricingGroupId = pricingGroupId;
    }

    @JsonProperty("CustomsCalculationType")
    public String getCustomsCalculationType() {
        return customsCalculationType;
    }

    @JsonProperty("CustomsCalculationType")
    public void setCustomsCalculationType(String customsCalculationType) {
        this.customsCalculationType = customsCalculationType;
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
