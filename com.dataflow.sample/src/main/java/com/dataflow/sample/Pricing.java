
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "id", "CountryIso", "ProductInput", "DeliveryInput", "Calculation", "Display" })
@DefaultCoder(SerializableCoder.class)
public class Pricing implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("CountryIso")
    private String countryIso;
    @JsonProperty("ProductInput")
    private ProductInput productInput;
    @JsonProperty("DeliveryInput")
    private DeliveryInput deliveryInput;
    @JsonProperty("Calculation")
    private Calculation calculation;
    @JsonProperty("Display")
    private Display display;
    private final static long serialVersionUID = -2410857603365967642L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pricing() {
    }

    /**
     * 
     * @param calculation
     * @param id
     * @param deliveryInput
     * @param display
     * @param countryIso
     * @param productInput
     */
    public Pricing(String id, String countryIso, ProductInput productInput, DeliveryInput deliveryInput,
            Calculation calculation, Display display) {
        super();
        this.id = id;
        this.countryIso = countryIso;
        this.productInput = productInput;
        this.deliveryInput = deliveryInput;
        this.calculation = calculation;
        this.display = display;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("CountryIso")
    public String getCountryIso() {
        return countryIso;
    }

    @JsonProperty("CountryIso")
    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    @JsonProperty("ProductInput")
    public ProductInput getProductInput() {
        return productInput;
    }

    @JsonProperty("ProductInput")
    public void setProductInput(ProductInput productInput) {
        this.productInput = productInput;
    }

    @JsonProperty("DeliveryInput")
    public DeliveryInput getDeliveryInput() {
        return deliveryInput;
    }

    @JsonProperty("DeliveryInput")
    public void setDeliveryInput(DeliveryInput deliveryInput) {
        this.deliveryInput = deliveryInput;
    }

    @JsonProperty("Calculation")
    public Calculation getCalculation() {
        return calculation;
    }

    @JsonProperty("Calculation")
    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    @JsonProperty("Display")
    public Display getDisplay() {
        return display;
    }

    @JsonProperty("Display")
    public void setDisplay(Display display) {
        this.display = display;
    }
}
