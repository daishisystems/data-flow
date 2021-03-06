
package com.dataflow.sample;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "FromCurrency", "ToCurrency", "Rate" })
@DefaultCoder(SerializableCoder.class)
public class FxRate implements Serializable {

    @JsonProperty("FromCurrency")
    private String fromCurrency;
    @JsonProperty("ToCurrency")
    private String toCurrency;
    @JsonProperty("Rate")
    private BigDecimal rate;
    private final static long serialVersionUID = 4540677166791904262L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FxRate() {
    }

    @JsonProperty("FromCurrency")
    public String getFromCurrency() {
        return fromCurrency;
    }

    @JsonProperty("FromCurrency")
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    @JsonProperty("ToCurrency")
    public String getToCurrency() {
        return toCurrency;
    }

    @JsonProperty("ToCurrency")
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @JsonProperty("Rate")
    public BigDecimal getRate() {
        return rate;
    }

    @JsonProperty("Rate")
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
