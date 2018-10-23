
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
@JsonPropertyOrder({ "Name", "TargetValue" })
public class ChargeTarget implements Serializable {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("TargetValue")
    private TargetValue targetValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2614436583257061409L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChargeTarget() {
    }

    /**
     * 
     * @param targetValue
     * @param name
     */
    public ChargeTarget(String name, TargetValue targetValue) {
        super();
        this.name = name;
        this.targetValue = targetValue;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("TargetValue")
    public TargetValue getTargetValue() {
        return targetValue;
    }

    @JsonProperty("TargetValue")
    public void setTargetValue(TargetValue targetValue) {
        this.targetValue = targetValue;
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
