
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Option", "IsExpressDelivery" })
@DefaultCoder(SerializableCoder.class)
public class DeliveryOption implements Serializable {

    @JsonProperty("Option")
    private Integer option;
    @JsonProperty("IsExpressDelivery")
    private Boolean isExpressDelivery;
    private final static long serialVersionUID = -1523273077646781560L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryOption() {
    }

    /**
     * 
     * @param isExpressDelivery
     * @param option
     */
    public DeliveryOption(Integer option, Boolean isExpressDelivery) {
        super();
        this.option = option;
        this.isExpressDelivery = isExpressDelivery;
    }

    @JsonProperty("Option")
    public Integer getOption() {
        return option;
    }

    @JsonProperty("Option")
    public void setOption(Integer option) {
        this.option = option;
    }

    @JsonProperty("IsExpressDelivery")
    public Boolean getIsExpressDelivery() {
        return isExpressDelivery;
    }

    @JsonProperty("IsExpressDelivery")
    public void setIsExpressDelivery(Boolean isExpressDelivery) {
        this.isExpressDelivery = isExpressDelivery;
    }
}
