package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class DeliveryDisplay implements Serializable {
    private boolean IncludeAllDutyAndTax;
    private float ShippingDisplayModelId;
    private String Name = null;
    private String Description = null;
    private boolean IncludeMerchandiseDuty;
    private boolean IncludeMerchandiseTax;
    private boolean IncludeShipping;
    private boolean IncludeShippingDuty;
    private boolean IncludeShippingTax;
    private boolean IncludeOtherTaxes;
    private boolean IncludeOtherFees;
    private boolean IsShippingVisible;
    private String DefaultDisplayText;
    private String DisplayTextKey;

    // Getter Methods

    public boolean getIncludeAllDutyAndTax() {
        return IncludeAllDutyAndTax;
    }

    public float getShippingDisplayModelId() {
        return ShippingDisplayModelId;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
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

    public boolean getIsShippingVisible() {
        return IsShippingVisible;
    }

    public String getDefaultDisplayText() {
        return DefaultDisplayText;
    }

    public String getDisplayTextKey() {
        return DisplayTextKey;
    }

    // Setter Methods

    public void setIncludeAllDutyAndTax(boolean IncludeAllDutyAndTax) {
        this.IncludeAllDutyAndTax = IncludeAllDutyAndTax;
    }

    public void setShippingDisplayModelId(float ShippingDisplayModelId) {
        this.ShippingDisplayModelId = ShippingDisplayModelId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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

    public void setIsShippingVisible(boolean IsShippingVisible) {
        this.IsShippingVisible = IsShippingVisible;
    }

    public void setDefaultDisplayText(String DefaultDisplayText) {
        this.DefaultDisplayText = DefaultDisplayText;
    }

    public void setDisplayTextKey(String DisplayTextKey) {
        this.DisplayTextKey = DisplayTextKey;
    }
}