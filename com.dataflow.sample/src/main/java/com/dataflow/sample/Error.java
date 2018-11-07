package com.dataflow.sample;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class Error implements Serializable {
    private static final long serialVersionUID = -4444539265574465302L;

    @JsonProperty("Message")
    private String Message;
    @JsonProperty("Code")
    private Integer code;

    @JsonProperty("Code")
    public Integer getCode() {
        return this.code;
    }

    @JsonProperty("Code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return this.Message;
    }

    @JsonProperty("Message")
    public void setMessage(String Message) {
        this.Message = Message;
    }

}