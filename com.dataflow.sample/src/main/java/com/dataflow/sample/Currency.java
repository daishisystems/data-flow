
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Iso", "Name", "Exponent", "Id" })
@DefaultCoder(SerializableCoder.class)
public class Currency implements Serializable {

    @JsonProperty("Iso")
    private String iso;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Exponent")
    private Integer exponent;
    @JsonProperty("Id")
    private Integer id;
    private final static long serialVersionUID = 8591908132599002027L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Currency() {
    }

    /**
     * 
     * @param id
     * @param iso
     * @param exponent
     * @param name
     */
    public Currency(String iso, String name, Integer exponent, Integer id) {
        super();
        this.iso = iso;
        this.name = name;
        this.exponent = exponent;
        this.id = id;
    }

    @JsonProperty("Iso")
    public String getIso() {
        return iso;
    }

    @JsonProperty("Iso")
    public void setIso(String iso) {
        this.iso = iso;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Exponent")
    public Integer getExponent() {
        return exponent;
    }

    @JsonProperty("Exponent")
    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }
}
