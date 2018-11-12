
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

@JsonPropertyOrder({ "PromoCode", "Title", "Description" })
@DefaultCoder(SerializableCoder.class)
public class RetailerPromoCode implements Serializable {

    @JsonProperty("PromoCode")
    private String promoCode;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6931059952484929669L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetailerPromoCode() {
    }

    /**
     * 
     * @param title
     * @param description
     * @param promoCode
     */
    public RetailerPromoCode(String promoCode, String title, String description) {
        super();
        this.promoCode = promoCode;
        this.title = title;
        this.description = description;
    }

    @JsonProperty("PromoCode")
    public String getPromoCode() {
        return promoCode;
    }

    @JsonProperty("PromoCode")
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
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
