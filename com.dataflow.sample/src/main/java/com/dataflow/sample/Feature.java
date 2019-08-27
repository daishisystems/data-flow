
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Type", "Active" })
@DefaultCoder(SerializableCoder.class)
public class Feature implements Serializable {

    @JsonProperty("Type")
    private String type;
    @JsonProperty("Active")
    private Boolean active;
    private final static long serialVersionUID = 5340224469099643397L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Feature() {
    }

    /**
     * 
     * @param active
     * @param type
     */
    public Feature(String type, Boolean active) {
        super();
        this.type = type;
        this.active = active;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(Boolean active) {
        this.active = active;
    }
}
