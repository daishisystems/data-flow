package com.dataflow.sample;

import java.io.Serializable;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Pricing implements Serializable {        
    private String id;
    private String CountryIso;
    ProductInput ProductInputObject;
    DeliveryInput DeliveryInputObject;
    Calculation CalculationObject;
    Display DisplayObject;

    // Getter Methods

    public String getId() {
        return id;
    }

    public String getCountryIso() {
        return CountryIso;
    }

    public ProductInput getProductInput() {
        return ProductInputObject;
    }

    public DeliveryInput getDeliveryInput() {
        return DeliveryInputObject;
    }

    public Calculation getCalculation() {
        return CalculationObject;
    }

    public Display getDisplay() {
        return DisplayObject;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setCountryIso(String CountryIso) {
        this.CountryIso = CountryIso;
    }

    public void setProductInput(ProductInput ProductInputObject) {
        this.ProductInputObject = ProductInputObject;
    }

    public void setDeliveryInput(DeliveryInput DeliveryInputObject) {
        this.DeliveryInputObject = DeliveryInputObject;
    }

    public void setCalculation(Calculation CalculationObject) {
        this.CalculationObject = CalculationObject;
    }

    public void setDisplay(Display DisplayObject) {
        this.DisplayObject = DisplayObject;
    }
}