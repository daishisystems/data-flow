
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "ChargeTargets" })
@DefaultCoder(SerializableCoder.class)
public class Package implements Serializable {

    @JsonProperty("ChargeTargets")
    private List<ChargeTarget> chargeTargets = new ArrayList<ChargeTarget>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2148993226447384773L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Package() {
    }

    /**
     * 
     * @param chargeTargets
     */
    public Package(List<ChargeTarget> chargeTargets) {
        super();
        this.chargeTargets = chargeTargets;
    }

    @JsonProperty("ChargeTargets")
    public List<ChargeTarget> getChargeTargets() {
        return chargeTargets;
    }

    @JsonProperty("ChargeTargets")
    public void setChargeTargets(List<ChargeTarget> chargeTargets) {
        if (chargeTargets != null) {
            this.chargeTargets = chargeTargets;
        }
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
