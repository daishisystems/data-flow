
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class FixFee implements Serializable {

    @JsonProperty("CurrencyCodeIso")
    private String currencyCodeIso;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Value")
    private Double value;
    private final static long serialVersionUID = -5481148120513482689L;

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

}
