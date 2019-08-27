
package com.dataflow.sample;

import java.io.Serializable;

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
    private Boolean isReverseAccurateCalculationRequired;
    @JsonProperty("IsReverseEstimatedCalculationRequired")
    private Boolean isReverseEstimatedCalculationRequired;
    @JsonProperty("IsReverseTaxesCalculationRequired")
    private Boolean isReverseTaxesCalculationRequired;
    @JsonProperty("IsReverseDutyCalculationRequired")
    private Boolean isReverseDutyCalculationRequired;
    @JsonProperty("EstimatedDutyRate")
    private Double estimatedDutyRate;
    @JsonProperty("EstimatedTaxRate")
    private Double estimatedTaxRate;
    @JsonProperty("BrandCountryMarkupId")
    private Integer brandCountryMarkupId;
    @JsonProperty("MarkupPercentage")
    private Double markupPercentage;
    @JsonProperty("PricingGroupId")
    private Integer pricingGroupId;
    @JsonProperty("CustomsCalculationType")
    private String customsCalculationType;
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
            Boolean isAccurateCalculationRequired, Boolean isReverseAccurateCalculationRequired,
            Boolean isReverseEstimatedCalculationRequired, Boolean isReverseTaxesCalculationRequired,
            Boolean isReverseDutyCalculationRequired, Double estimatedDutyRate, Double estimatedTaxRate,
            Integer brandCountryMarkupId, Double markupPercentage, Integer pricingGroupId,
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
    public Boolean getIsReverseAccurateCalculationRequired() {
        return isReverseAccurateCalculationRequired;
    }

    @JsonProperty("IsReverseAccurateCalculationRequired")
    public void setIsReverseAccurateCalculationRequired(Boolean isReverseAccurateCalculationRequired) {
        this.isReverseAccurateCalculationRequired = isReverseAccurateCalculationRequired;
    }

    @JsonProperty("IsReverseEstimatedCalculationRequired")
    public Boolean getIsReverseEstimatedCalculationRequired() {
        return isReverseEstimatedCalculationRequired;
    }

    @JsonProperty("IsReverseEstimatedCalculationRequired")
    public void setIsReverseEstimatedCalculationRequired(Boolean isReverseEstimatedCalculationRequired) {
        this.isReverseEstimatedCalculationRequired = isReverseEstimatedCalculationRequired;
    }

    @JsonProperty("IsReverseTaxesCalculationRequired")
    public Boolean getIsReverseTaxesCalculationRequired() {
        return isReverseTaxesCalculationRequired;
    }

    @JsonProperty("IsReverseTaxesCalculationRequired")
    public void setIsReverseTaxesCalculationRequired(Boolean isReverseTaxesCalculationRequired) {
        this.isReverseTaxesCalculationRequired = isReverseTaxesCalculationRequired;
    }

    @JsonProperty("IsReverseDutyCalculationRequired")
    public Boolean getIsReverseDutyCalculationRequired() {
        return isReverseDutyCalculationRequired;
    }

    @JsonProperty("IsReverseDutyCalculationRequired")
    public void setIsReverseDutyCalculationRequired(Boolean isReverseDutyCalculationRequired) {
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
        this.estimatedTaxRate = Utils.round(estimatedTaxRate);
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
    public Double getMarkupPercentage() {
        return markupPercentage;
    }

    @JsonProperty("MarkupPercentage")
    public void setMarkupPercentage(Double markupPercentage) {
        this.markupPercentage = Utils.round(markupPercentage);
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

}
