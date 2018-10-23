package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Display implements Serializable {
    private float BrandCountryDisplayModelId;
    ProductDisplay ProductDisplayObject;
    private String DutyAndTaxDisplay1 = null;
    private String DutyAndTaxDisplay2 = null;
    DeliveryDisplay DeliveryDisplayObject;

    // Getter Methods

    public float getBrandCountryDisplayModelId() {
        return BrandCountryDisplayModelId;
    }

    public ProductDisplay getProductDisplay() {
        return ProductDisplayObject;
    }

    public String getDutyAndTaxDisplay1() {
        return DutyAndTaxDisplay1;
    }

    public String getDutyAndTaxDisplay2() {
        return DutyAndTaxDisplay2;
    }

    public DeliveryDisplay getDeliveryDisplay() {
        return DeliveryDisplayObject;
    }

    // Setter Methods

    public void setBrandCountryDisplayModelId(float BrandCountryDisplayModelId) {
        this.BrandCountryDisplayModelId = BrandCountryDisplayModelId;
    }

    public void setProductDisplay(ProductDisplay ProductDisplayObject) {
        this.ProductDisplayObject = ProductDisplayObject;
    }

    public void setDutyAndTaxDisplay1(String DutyAndTaxDisplay1) {
        this.DutyAndTaxDisplay1 = DutyAndTaxDisplay1;
    }

    public void setDutyAndTaxDisplay2(String DutyAndTaxDisplay2) {
        this.DutyAndTaxDisplay2 = DutyAndTaxDisplay2;
    }

    public void setDeliveryDisplay(DeliveryDisplay DeliveryDisplayObject) {
        this.DeliveryDisplayObject = DeliveryDisplayObject;
    }
}