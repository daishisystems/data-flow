
package com.dataflow.sample;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "CurrencyCodeIso", "Currency", "Value" })
@DefaultCoder(SerializableCoder.class)
public class ExactValue implements Serializable {

    @JsonProperty("CurrencyCodeIso")
    private String currencyCodeIso;
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Value")
    private BigDecimal value;
    @JsonProperty("IsZero")
    private Boolean isZero;
    @JsonProperty("IsNotZero")
    private Boolean isNotZero;
    private final static long serialVersionUID = -5270350813609374145L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExactValue() {
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

    @JsonProperty("Value") // FIXME: Round to 9 decimal places
    public BigDecimal getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(BigDecimal value) {
        this.value = value;
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
}
