package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class InputItem implements Serializable {
    private boolean IncludesMerchandise;
    private boolean IncludesMerchandiseDuty;
    private boolean IncludesMerchandiseTax;
    private boolean IncludesMerchandiseFee;
    private boolean IncludesMerchandiseFixedFee;
    private boolean IncludesDeliveryItem;
    private boolean IncludesDeliveryDuty;
    private boolean IncludesDeliveryTax;
    private boolean IncludesDeliveryFee;
    private boolean IncludesDeliveryFixedFee;
    private boolean IsMerchandiseItemPrice;
    private boolean IsMerchandiseAllInclusivePrice;
    private boolean IsDeliveryItemPrice;

    // Getter Methods

    public boolean getIncludesMerchandise() {
        return IncludesMerchandise;
    }

    public boolean getIncludesMerchandiseDuty() {
        return IncludesMerchandiseDuty;
    }

    public boolean getIncludesMerchandiseTax() {
        return IncludesMerchandiseTax;
    }

    public boolean getIncludesMerchandiseFee() {
        return IncludesMerchandiseFee;
    }

    public boolean getIncludesMerchandiseFixedFee() {
        return IncludesMerchandiseFixedFee;
    }

    public boolean getIncludesDeliveryItem() {
        return IncludesDeliveryItem;
    }

    public boolean getIncludesDeliveryDuty() {
        return IncludesDeliveryDuty;
    }

    public boolean getIncludesDeliveryTax() {
        return IncludesDeliveryTax;
    }

    public boolean getIncludesDeliveryFee() {
        return IncludesDeliveryFee;
    }

    public boolean getIncludesDeliveryFixedFee() {
        return IncludesDeliveryFixedFee;
    }

    public boolean getIsMerchandiseItemPrice() {
        return IsMerchandiseItemPrice;
    }

    public boolean getIsMerchandiseAllInclusivePrice() {
        return IsMerchandiseAllInclusivePrice;
    }

    public boolean getIsDeliveryItemPrice() {
        return IsDeliveryItemPrice;
    }

    // Setter Methods

    public void setIncludesMerchandise(boolean IncludesMerchandise) {
        this.IncludesMerchandise = IncludesMerchandise;
    }

    public void setIncludesMerchandiseDuty(boolean IncludesMerchandiseDuty) {
        this.IncludesMerchandiseDuty = IncludesMerchandiseDuty;
    }

    public void setIncludesMerchandiseTax(boolean IncludesMerchandiseTax) {
        this.IncludesMerchandiseTax = IncludesMerchandiseTax;
    }

    public void setIncludesMerchandiseFee(boolean IncludesMerchandiseFee) {
        this.IncludesMerchandiseFee = IncludesMerchandiseFee;
    }

    public void setIncludesMerchandiseFixedFee(boolean IncludesMerchandiseFixedFee) {
        this.IncludesMerchandiseFixedFee = IncludesMerchandiseFixedFee;
    }

    public void setIncludesDeliveryItem(boolean IncludesDeliveryItem) {
        this.IncludesDeliveryItem = IncludesDeliveryItem;
    }

    public void setIncludesDeliveryDuty(boolean IncludesDeliveryDuty) {
        this.IncludesDeliveryDuty = IncludesDeliveryDuty;
    }

    public void setIncludesDeliveryTax(boolean IncludesDeliveryTax) {
        this.IncludesDeliveryTax = IncludesDeliveryTax;
    }

    public void setIncludesDeliveryFee(boolean IncludesDeliveryFee) {
        this.IncludesDeliveryFee = IncludesDeliveryFee;
    }

    public void setIncludesDeliveryFixedFee(boolean IncludesDeliveryFixedFee) {
        this.IncludesDeliveryFixedFee = IncludesDeliveryFixedFee;
    }

    public void setIsMerchandiseItemPrice(boolean IsMerchandiseItemPrice) {
        this.IsMerchandiseItemPrice = IsMerchandiseItemPrice;
    }

    public void setIsMerchandiseAllInclusivePrice(boolean IsMerchandiseAllInclusivePrice) {
        this.IsMerchandiseAllInclusivePrice = IsMerchandiseAllInclusivePrice;
    }

    public void setIsDeliveryItemPrice(boolean IsDeliveryItemPrice) {
        this.IsDeliveryItemPrice = IsDeliveryItemPrice;
    }
}