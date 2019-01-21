
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class UpperBoundary implements Serializable {

    @JsonProperty("CurrencyCodeIso")
    private String currencyCodeIso;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Value")
    private String value;
    private final static long serialVersionUID = 1752833738020851814L;

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
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

}
