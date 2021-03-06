
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "DutyAndTaxDisplayModelId", "Name", "Description", "IncludeAllDutyAndTax",
        "IncludeMerchandiseDuty", "IncludeMerchandiseTax", "IncludeShipping", "IncludeShippingDuty",
        "IncludeShippingTax", "IncludeOtherTaxes", "IncludeOtherFees", "IsDutyAndTaxVisible", "DefaultDisplayText",
        "DisplayTextKey" })
@DefaultCoder(SerializableCoder.class)
public class DutyAndTaxDisplay implements Serializable {

    @JsonProperty("DutyAndTaxDisplayModelId")
    private Integer dutyAndTaxDisplayModelId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IncludeAllDutyAndTax")
    private Boolean includeAllDutyAndTax;
    @JsonProperty("IncludeMerchandiseDuty")
    private Boolean includeMerchandiseDuty;
    @JsonProperty("IncludeMerchandiseTax")
    private Boolean includeMerchandiseTax;
    @JsonProperty("IncludeShipping")
    private Boolean includeShipping;
    @JsonProperty("IncludeShippingDuty")
    private Boolean includeShippingDuty;
    @JsonProperty("IncludeShippingTax")
    private Boolean includeShippingTax;
    @JsonProperty("IncludeOtherTaxes")
    private Boolean includeOtherTaxes;
    @JsonProperty("IncludeOtherFees")
    private Boolean includeOtherFees;
    @JsonProperty("IsDutyAndTaxVisible")
    private Boolean isDutyAndTaxVisible;
    @JsonProperty("DefaultDisplayText")
    private String defaultDisplayText;
    @JsonProperty("DisplayTextKey")
    private String displayTextKey;
    private final static long serialVersionUID = -6986914330069708290L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DutyAndTaxDisplay() {
    }

    /**
     * 
     * @param dutyAndTaxDisplayModelId
     * @param includeMerchandiseTax
     * @param displayTextKey
     * @param includeShippingTax
     * @param includeShipping
     * @param includeAllDutyAndTax
     * @param includeShippingDuty
     * @param description
     * @param includeOtherTaxes
     * @param name
     * @param isDutyAndTaxVisible
     * @param includeOtherFees
     * @param defaultDisplayText
     * @param includeMerchandiseDuty
     */
    public DutyAndTaxDisplay(Integer dutyAndTaxDisplayModelId, String name, String description,
            Boolean includeAllDutyAndTax, Boolean includeMerchandiseDuty, Boolean includeMerchandiseTax,
            Boolean includeShipping, Boolean includeShippingDuty, Boolean includeShippingTax, Boolean includeOtherTaxes,
            Boolean includeOtherFees, Boolean isDutyAndTaxVisible, String defaultDisplayText, String displayTextKey) {
        super();
        this.dutyAndTaxDisplayModelId = dutyAndTaxDisplayModelId;
        this.name = name;
        this.description = description;
        this.includeAllDutyAndTax = includeAllDutyAndTax;
        this.includeMerchandiseDuty = includeMerchandiseDuty;
        this.includeMerchandiseTax = includeMerchandiseTax;
        this.includeShipping = includeShipping;
        this.includeShippingDuty = includeShippingDuty;
        this.includeShippingTax = includeShippingTax;
        this.includeOtherTaxes = includeOtherTaxes;
        this.includeOtherFees = includeOtherFees;
        this.isDutyAndTaxVisible = isDutyAndTaxVisible;
        this.defaultDisplayText = defaultDisplayText;
        this.displayTextKey = displayTextKey;
    }

    @JsonProperty("DutyAndTaxDisplayModelId")
    public Integer getDutyAndTaxDisplayModelId() {
        return dutyAndTaxDisplayModelId;
    }

    @JsonProperty("DutyAndTaxDisplayModelId")
    public void setDutyAndTaxDisplayModelId(Integer dutyAndTaxDisplayModelId) {
        this.dutyAndTaxDisplayModelId = dutyAndTaxDisplayModelId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("IncludeAllDutyAndTax")
    public Boolean getIncludeAllDutyAndTax() {
        return includeAllDutyAndTax;
    }

    @JsonProperty("IncludeAllDutyAndTax")
    public void setIncludeAllDutyAndTax(Boolean includeAllDutyAndTax) {
        this.includeAllDutyAndTax = includeAllDutyAndTax;
    }

    @JsonProperty("IncludeMerchandiseDuty")
    public Boolean getIncludeMerchandiseDuty() {
        return includeMerchandiseDuty;
    }

    @JsonProperty("IncludeMerchandiseDuty")
    public void setIncludeMerchandiseDuty(Boolean includeMerchandiseDuty) {
        this.includeMerchandiseDuty = includeMerchandiseDuty;
    }

    @JsonProperty("IncludeMerchandiseTax")
    public Boolean getIncludeMerchandiseTax() {
        return includeMerchandiseTax;
    }

    @JsonProperty("IncludeMerchandiseTax")
    public void setIncludeMerchandiseTax(Boolean includeMerchandiseTax) {
        this.includeMerchandiseTax = includeMerchandiseTax;
    }

    @JsonProperty("IncludeShipping")
    public Boolean getIncludeShipping() {
        return includeShipping;
    }

    @JsonProperty("IncludeShipping")
    public void setIncludeShipping(Boolean includeShipping) {
        this.includeShipping = includeShipping;
    }

    @JsonProperty("IncludeShippingDuty")
    public Boolean getIncludeShippingDuty() {
        return includeShippingDuty;
    }

    @JsonProperty("IncludeShippingDuty")
    public void setIncludeShippingDuty(Boolean includeShippingDuty) {
        this.includeShippingDuty = includeShippingDuty;
    }

    @JsonProperty("IncludeShippingTax")
    public Boolean getIncludeShippingTax() {
        return includeShippingTax;
    }

    @JsonProperty("IncludeShippingTax")
    public void setIncludeShippingTax(Boolean includeShippingTax) {
        this.includeShippingTax = includeShippingTax;
    }

    @JsonProperty("IncludeOtherTaxes")
    public Boolean getIncludeOtherTaxes() {
        return includeOtherTaxes;
    }

    @JsonProperty("IncludeOtherTaxes")
    public void setIncludeOtherTaxes(Boolean includeOtherTaxes) {
        this.includeOtherTaxes = includeOtherTaxes;
    }

    @JsonProperty("IncludeOtherFees")
    public Boolean getIncludeOtherFees() {
        return includeOtherFees;
    }

    @JsonProperty("IncludeOtherFees")
    public void setIncludeOtherFees(Boolean includeOtherFees) {
        this.includeOtherFees = includeOtherFees;
    }

    @JsonProperty("IsDutyAndTaxVisible")
    public Boolean getIsDutyAndTaxVisible() {
        return isDutyAndTaxVisible;
    }

    @JsonProperty("IsDutyAndTaxVisible")
    public void setIsDutyAndTaxVisible(Boolean isDutyAndTaxVisible) {
        this.isDutyAndTaxVisible = isDutyAndTaxVisible;
    }

    @JsonProperty("DefaultDisplayText")
    public String getDefaultDisplayText() {
        return defaultDisplayText;
    }

    @JsonProperty("DefaultDisplayText")
    public void setDefaultDisplayText(String defaultDisplayText) {
        this.defaultDisplayText = defaultDisplayText;
    }

    @JsonProperty("DisplayTextKey")
    public String getDisplayTextKey() {
        return displayTextKey;
    }

    @JsonProperty("DisplayTextKey")
    public void setDisplayTextKey(String displayTextKey) {
        this.displayTextKey = displayTextKey;
    }
}
