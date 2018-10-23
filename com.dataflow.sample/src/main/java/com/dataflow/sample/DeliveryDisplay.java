
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
@JsonPropertyOrder({ "IncludeAllDutyAndTax", "ShippingDisplayModelId", "Name", "Description", "IncludeMerchandiseDuty",
        "IncludeMerchandiseTax", "IncludeShipping", "IncludeShippingDuty", "IncludeShippingTax", "IncludeOtherTaxes",
        "IncludeOtherFees", "IsShippingVisible", "DefaultDisplayText", "DisplayTextKey" })
public class DeliveryDisplay implements Serializable {

    @JsonProperty("IncludeAllDutyAndTax")
    private Boolean includeAllDutyAndTax;
    @JsonProperty("ShippingDisplayModelId")
    private Integer shippingDisplayModelId;
    @JsonProperty("Name")
    private Object name;
    @JsonProperty("Description")
    private Object description;
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
    @JsonProperty("IsShippingVisible")
    private Boolean isShippingVisible;
    @JsonProperty("DefaultDisplayText")
    private String defaultDisplayText;
    @JsonProperty("DisplayTextKey")
    private String displayTextKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5484827506617311445L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryDisplay() {
    }

    /**
     * 
     * @param includeMerchandiseTax
     * @param displayTextKey
     * @param includeShippingTax
     * @param includeShipping
     * @param includeAllDutyAndTax
     * @param includeShippingDuty
     * @param description
     * @param includeOtherTaxes
     * @param name
     * @param isShippingVisible
     * @param includeOtherFees
     * @param defaultDisplayText
     * @param includeMerchandiseDuty
     * @param shippingDisplayModelId
     */
    public DeliveryDisplay(Boolean includeAllDutyAndTax, Integer shippingDisplayModelId, Object name,
            Object description, Boolean includeMerchandiseDuty, Boolean includeMerchandiseTax, Boolean includeShipping,
            Boolean includeShippingDuty, Boolean includeShippingTax, Boolean includeOtherTaxes,
            Boolean includeOtherFees, Boolean isShippingVisible, String defaultDisplayText, String displayTextKey) {
        super();
        this.includeAllDutyAndTax = includeAllDutyAndTax;
        this.shippingDisplayModelId = shippingDisplayModelId;
        this.name = name;
        this.description = description;
        this.includeMerchandiseDuty = includeMerchandiseDuty;
        this.includeMerchandiseTax = includeMerchandiseTax;
        this.includeShipping = includeShipping;
        this.includeShippingDuty = includeShippingDuty;
        this.includeShippingTax = includeShippingTax;
        this.includeOtherTaxes = includeOtherTaxes;
        this.includeOtherFees = includeOtherFees;
        this.isShippingVisible = isShippingVisible;
        this.defaultDisplayText = defaultDisplayText;
        this.displayTextKey = displayTextKey;
    }

    @JsonProperty("IncludeAllDutyAndTax")
    public Boolean getIncludeAllDutyAndTax() {
        return includeAllDutyAndTax;
    }

    @JsonProperty("IncludeAllDutyAndTax")
    public void setIncludeAllDutyAndTax(Boolean includeAllDutyAndTax) {
        this.includeAllDutyAndTax = includeAllDutyAndTax;
    }

    @JsonProperty("ShippingDisplayModelId")
    public Integer getShippingDisplayModelId() {
        return shippingDisplayModelId;
    }

    @JsonProperty("ShippingDisplayModelId")
    public void setShippingDisplayModelId(Integer shippingDisplayModelId) {
        this.shippingDisplayModelId = shippingDisplayModelId;
    }

    @JsonProperty("Name")
    public Object getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(Object name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(Object description) {
        this.description = description;
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

    @JsonProperty("IsShippingVisible")
    public Boolean getIsShippingVisible() {
        return isShippingVisible;
    }

    @JsonProperty("IsShippingVisible")
    public void setIsShippingVisible(Boolean isShippingVisible) {
        this.isShippingVisible = isShippingVisible;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
