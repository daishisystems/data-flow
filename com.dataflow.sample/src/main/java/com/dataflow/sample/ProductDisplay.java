package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class ProductDisplay implements Serializable {
    private float MerchandiseDisplayModelId;
    private String Name = null;
    private String Description = null;
    private boolean IncludeAllDutyAndTax;
    private boolean IncludeMerchandiseDuty;
    private boolean IncludeMerchandiseTax;
    private boolean IncludeShipping;
    private boolean IncludeShippingDuty;
    private boolean IncludeShippingTax;
    private boolean IncludeOtherTaxes;
    private boolean IncludeOtherFees;
    private String DefaultDisplayText;
    private String DisplayTextKey;

    // Getter Methods

    public float getMerchandiseDisplayModelId() {
        return MerchandiseDisplayModelId;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public boolean getIncludeAllDutyAndTax() {
        return IncludeAllDutyAndTax;
    }

    public boolean getIncludeMerchandiseDuty() {
        return IncludeMerchandiseDuty;
    }

    public boolean getIncludeMerchandiseTax() {
        return IncludeMerchandiseTax;
    }

    public boolean getIncludeShipping() {
        return IncludeShipping;
    }

    public boolean getIncludeShippingDuty() {
        return IncludeShippingDuty;
    }

    public boolean getIncludeShippingTax() {
        return IncludeShippingTax;
    }

    public boolean getIncludeOtherTaxes() {
        return IncludeOtherTaxes;
    }

    public boolean getIncludeOtherFees() {
        return IncludeOtherFees;
    }

    public String getDefaultDisplayText() {
        return DefaultDisplayText;
    }

    public String getDisplayTextKey() {
        return DisplayTextKey;
    }

    // Setter Methods

    public void setMerchandiseDisplayModelId(float MerchandiseDisplayModelId) {
        this.MerchandiseDisplayModelId = MerchandiseDisplayModelId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setIncludeAllDutyAndTax(boolean IncludeAllDutyAndTax) {
        this.IncludeAllDutyAndTax = IncludeAllDutyAndTax;
    }

    public void setIncludeMerchandiseDuty(boolean IncludeMerchandiseDuty) {
        this.IncludeMerchandiseDuty = IncludeMerchandiseDuty;
    }

    public void setIncludeMerchandiseTax(boolean IncludeMerchandiseTax) {
        this.IncludeMerchandiseTax = IncludeMerchandiseTax;
    }

    public void setIncludeShipping(boolean IncludeShipping) {
        this.IncludeShipping = IncludeShipping;
    }

    public void setIncludeShippingDuty(boolean IncludeShippingDuty) {
        this.IncludeShippingDuty = IncludeShippingDuty;
    }

    public void setIncludeShippingTax(boolean IncludeShippingTax) {
        this.IncludeShippingTax = IncludeShippingTax;
    }

    public void setIncludeOtherTaxes(boolean IncludeOtherTaxes) {
        this.IncludeOtherTaxes = IncludeOtherTaxes;
    }

    public void setIncludeOtherFees(boolean IncludeOtherFees) {
        this.IncludeOtherFees = IncludeOtherFees;
    }

    public void setDefaultDisplayText(String DefaultDisplayText) {
        this.DefaultDisplayText = DefaultDisplayText;
    }

    public void setDisplayTextKey(String DisplayTextKey) {
        this.DisplayTextKey = DisplayTextKey;
    }
}