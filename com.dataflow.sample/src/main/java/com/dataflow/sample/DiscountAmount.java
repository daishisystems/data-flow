
package com.dataflow.sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "CurrencyCodeIso", "Currency", "Value" })
@DefaultCoder(SerializableCoder.class)
public class DiscountAmount implements Serializable {

    @JsonProperty("CurrencyCodeIso")
    private String currencyCodeIso;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Value")
    private Double value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7240839411364606049L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscountAmount() {
    }

    /**
     * 
     * @param currencyCodeIso
     * @param value
     * @param currency
     */
    public DiscountAmount(String currencyCodeIso, Currency currency, Double value) {
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
        this.value = value;
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
