
package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class ProductInput implements Serializable {
    private float InputPriceId;
    private float PreOrderSecurityModelId;
    private float InputPriceTypeId;
    private float InputPriceSourceId;
    private boolean CanOverrideCatalogPrice;
    private float CatalogOverrideInputPriceTypeId;
    private float DutyRate;
    private float TaxRate;
    private String OtherRate = null;
    private boolean MatchInputPrice;

    // Getter Methods

    public float getInputPriceId() {
        return InputPriceId;
    }

    public float getPreOrderSecurityModelId() {
        return PreOrderSecurityModelId;
    }

    public float getInputPriceTypeId() {
        return InputPriceTypeId;
    }

    public float getInputPriceSourceId() {
        return InputPriceSourceId;
    }

    public boolean getCanOverrideCatalogPrice() {
        return CanOverrideCatalogPrice;
    }

    public float getCatalogOverrideInputPriceTypeId() {
        return CatalogOverrideInputPriceTypeId;
    }

    public float getDutyRate() {
        return DutyRate;
    }

    public float getTaxRate() {
        return TaxRate;
    }

    public String getOtherRate() {
        return OtherRate;
    }

    public boolean getMatchInputPrice() {
        return MatchInputPrice;
    }

    // Setter Methods

    public void setInputPriceId(float InputPriceId) {
        this.InputPriceId = InputPriceId;
    }

    public void setPreOrderSecurityModelId(float PreOrderSecurityModelId) {
        this.PreOrderSecurityModelId = PreOrderSecurityModelId;
    }

    public void setInputPriceTypeId(float InputPriceTypeId) {
        this.InputPriceTypeId = InputPriceTypeId;
    }

    public void setInputPriceSourceId(float InputPriceSourceId) {
        this.InputPriceSourceId = InputPriceSourceId;
    }

    public void setCanOverrideCatalogPrice(boolean CanOverrideCatalogPrice) {
        this.CanOverrideCatalogPrice = CanOverrideCatalogPrice;
    }

    public void setCatalogOverrideInputPriceTypeId(float CatalogOverrideInputPriceTypeId) {
        this.CatalogOverrideInputPriceTypeId = CatalogOverrideInputPriceTypeId;
    }

    public void setDutyRate(float DutyRate) {
        this.DutyRate = DutyRate;
    }

    public void setTaxRate(float TaxRate) {
        this.TaxRate = TaxRate;
    }

    public void setOtherRate(String OtherRate) {
        this.OtherRate = OtherRate;
    }

    public void setMatchInputPrice(boolean MatchInputPrice) {
        this.MatchInputPrice = MatchInputPrice;
    }
}