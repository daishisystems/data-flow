
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "Charges", "Package", "ChargeTargets" })
@DefaultCoder(SerializableCoder.class)
public class OrderArticle implements Serializable {

    @JsonProperty("Charges")
    private List<Charge> charges = new ArrayList<Charge>();
    @JsonProperty("Package")
    private Package _package;
    @JsonProperty("ChargeTargets")
    private List<ChargeTarget> chargeTargets = new ArrayList<ChargeTarget>();
    private final static long serialVersionUID = 2336595865081111803L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderArticle() {
    }

    /**
     * 
     * @param charges
     * @param _package
     * @param chargeTargets
     */
    public OrderArticle(List<Charge> charges, Package _package, List<ChargeTarget> chargeTargets) {
        super();
        this.charges = charges;
        this._package = _package;
        this.chargeTargets = chargeTargets;
    }

    @JsonProperty("Charges")
    public List<Charge> getCharges() {
        return charges;
    }

    @JsonProperty("Charges")
    public void setCharges(List<Charge> charges) {
        if (charges != null) {
            this.charges = charges;
        }
    }

    @JsonProperty("Package")
    public Package getPackage() {
        return _package;
    }

    @JsonProperty("Package")
    public void setPackage(Package _package) {
        this._package = _package;
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
}
