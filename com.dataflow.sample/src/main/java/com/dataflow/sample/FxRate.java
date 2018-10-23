
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "FromCurrency", "ToCurrency", "Rate" })
public class FxRate implements Serializable {

    @JsonProperty("FromCurrency")
    private String fromCurrency;
    @JsonProperty("ToCurrency")
    private String toCurrency;
    @JsonProperty("Rate")
    private Double rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4540677166791904262L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FxRate() {
    }

    /**
     * 
     * @param fromCurrency
     * @param rate
     * @param toCurrency
     */
    public FxRate(String fromCurrency, String toCurrency, Double rate) {
        super();
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
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
    public Double getRate() {
        return rate;
    }

    @JsonProperty("Rate")
    public void setRate(Double rate) {
        this.rate = rate;
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