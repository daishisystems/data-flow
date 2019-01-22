
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

@JsonPropertyOrder({ "CurrencyCodeIso", "Currency", "Value" })
@DefaultCoder(SerializableCoder.class)
public class BeforeDiscount implements Serializable {

    @JsonProperty("CurrencyCodeIso")
    private String currencyCodeIso;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Value")
    private Double value;
    @JsonProperty("IsZero")
    private Boolean isZero;
    @JsonProperty("IsNotZero")
    private Boolean isNotZero;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 65916518594011050L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BeforeDiscount() {
    }

    /**
     * 
     * @param currencyCodeIso
     * @param value
     * @param currency
     */
    public BeforeDiscount(String currencyCodeIso, Currency currency, Double value) {
        super();
        this.currencyCodeIso = currencyCodeIso;
        this.currency = currency;
        this.value = value;
    }

    @JsonProperty("CurrencyCodeIso")
    public String getCurrencyCodeIso() {
        return currencyCodeIso;
    }

    @JsonProperty("CurrencyCodeIso")
    public void setCurrencyCodeIso(String currencyCodeIso) {
        this.currencyCodeIso = currencyCodeIso;
    }

    @JsonProperty("Currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Double value) {
        this.value = Utils.round(value);
    }

    @JsonProperty("IsZero")
    public Boolean getIsZero() {
        return this.isZero;
    }

    @JsonProperty("IsZero")
    public void setIsZero(Boolean isZero) {
        this.isZero = isZero;
    }

    @JsonProperty("IsNotZero")
    public Boolean getIsNotZero() {
        return this.isNotZero;
    }

    @JsonProperty("IsNotZero")
    public void setIsNotZero(Boolean isNotZero) {
        this.isNotZero = isNotZero;
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
