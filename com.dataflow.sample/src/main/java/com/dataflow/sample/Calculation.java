package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Calculation implements Serializable {
    private float BrandCountryCalculationId;
    private float DutyTaxCalculationModelId;
    private boolean IsAccurateCalculationRequired;
    private String IsReverseAccurateCalculationRequired = null;
    private String IsReverseEstimatedCalculationRequired = null;
    private String IsReverseTaxesCalculationRequired = null;
    private String IsReverseDutyCalculationRequired = null;
    private float EstimatedDutyRate;
    private float EstimatedTaxRate;
    private float BrandCountryMarkupId;
    private String MarkupPercentage = null;
    private float PricingGroupId;
    private String CustomsCalculationType;

    // Getter Methods

    public float getBrandCountryCalculationId() {
        return BrandCountryCalculationId;
    }

    public float getDutyTaxCalculationModelId() {
        return DutyTaxCalculationModelId;
    }

    public boolean getIsAccurateCalculationRequired() {
        return IsAccurateCalculationRequired;
    }

    public String getIsReverseAccurateCalculationRequired() {
        return IsReverseAccurateCalculationRequired;
    }

    public String getIsReverseEstimatedCalculationRequired() {
        return IsReverseEstimatedCalculationRequired;
    }

    public String getIsReverseTaxesCalculationRequired() {
        return IsReverseTaxesCalculationRequired;
    }

    public String getIsReverseDutyCalculationRequired() {
        return IsReverseDutyCalculationRequired;
    }

    public float getEstimatedDutyRate() {
        return EstimatedDutyRate;
    }

    public float getEstimatedTaxRate() {
        return EstimatedTaxRate;
    }

    public float getBrandCountryMarkupId() {
        return BrandCountryMarkupId;
    }

    public String getMarkupPercentage() {
        return MarkupPercentage;
    }

    public float getPricingGroupId() {
        return PricingGroupId;
    }

    public String getCustomsCalculationType() {
        return CustomsCalculationType;
    }

    // Setter Methods

    public void setBrandCountryCalculationId(float BrandCountryCalculationId) {
        this.BrandCountryCalculationId = BrandCountryCalculationId;
    }

    public void setDutyTaxCalculationModelId(float DutyTaxCalculationModelId) {
        this.DutyTaxCalculationModelId = DutyTaxCalculationModelId;
    }

    public void setIsAccurateCalculationRequired(boolean IsAccurateCalculationRequired) {
        this.IsAccurateCalculationRequired = IsAccurateCalculationRequired;
    }

    public void setIsReverseAccurateCalculationRequired(String IsReverseAccurateCalculationRequired) {
        this.IsReverseAccurateCalculationRequired = IsReverseAccurateCalculationRequired;
    }

    public void setIsReverseEstimatedCalculationRequired(String IsReverseEstimatedCalculationRequired) {
        this.IsReverseEstimatedCalculationRequired = IsReverseEstimatedCalculationRequired;
    }

    public void setIsReverseTaxesCalculationRequired(String IsReverseTaxesCalculationRequired) {
        this.IsReverseTaxesCalculationRequired = IsReverseTaxesCalculationRequired;
    }

    public void setIsReverseDutyCalculationRequired(String IsReverseDutyCalculationRequired) {
        this.IsReverseDutyCalculationRequired = IsReverseDutyCalculationRequired;
    }

    public void setEstimatedDutyRate(float EstimatedDutyRate) {
        this.EstimatedDutyRate = EstimatedDutyRate;
    }

    public void setEstimatedTaxRate(float EstimatedTaxRate) {
        this.EstimatedTaxRate = EstimatedTaxRate;
    }

    public void setBrandCountryMarkupId(float BrandCountryMarkupId) {
        this.BrandCountryMarkupId = BrandCountryMarkupId;
    }

    public void setMarkupPercentage(String MarkupPercentage) {
        this.MarkupPercentage = MarkupPercentage;
    }

    public void setPricingGroupId(float PricingGroupId) {
        this.PricingGroupId = PricingGroupId;
    }

    public void setCustomsCalculationType(String CustomsCalculationType) {
        this.CustomsCalculationType = CustomsCalculationType;
    }
}