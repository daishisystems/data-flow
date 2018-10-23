
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
@JsonPropertyOrder({ "MerchandiseDisplayModelId", "Name", "Description", "IncludeAllDutyAndTax",
        "IncludeMerchandiseDuty", "IncludeMerchandiseTax", "IncludeShipping", "IncludeShippingDuty",
        "IncludeShippingTax", "IncludeOtherTaxes", "IncludeOtherFees", "DefaultDisplayText", "DisplayTextKey" })
public class ProductDisplay implements Serializable {

    @JsonProperty("MerchandiseDisplayModelId")
    private Integer merchandiseDisplayModelId;
    @JsonProperty("Name")
    private Object name;
    @JsonProperty("Description")
    private Object description;
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
    @JsonProperty("DefaultDisplayText")
    private String defaultDisplayText;
    @JsonProperty("DisplayTextKey")
    private String displayTextKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6594707239095342458L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductDisplay() {
    }

    /**
     * 
     * @param merchandiseDisplayModelId
     * @param includeMerchandiseTax
     * @param displayTextKey
     * @param includeShippingTax
     * @param includeShipping
     * @param includeAllDutyAndTax
     * @param includeShippingDuty
     * @param description
     * @param includeOtherTaxes
     * @param name
     * @param includeOtherFees
     * @param defaultDisplayText
     * @param includeMerchandiseDuty
     */
    public ProductDisplay(Integer merchandiseDisplayModelId, Object name, Object description,
            Boolean includeAllDutyAndTax, Boolean includeMerchandiseDuty, Boolean includeMerchandiseTax,
            Boolean includeShipping, Boolean includeShippingDuty, Boolean includeShippingTax, Boolean includeOtherTaxes,
            Boolean includeOtherFees, String defaultDisplayText, String displayTextKey) {
        super();
        this.merchandiseDisplayModelId = merchandiseDisplayModelId;
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
        this.defaultDisplayText = defaultDisplayText;
        this.displayTextKey = displayTextKey;
    }

    @JsonProperty("MerchandiseDisplayModelId")
    public Integer getMerchandiseDisplayModelId() {
        return merchandiseDisplayModelId;
    }

    @JsonProperty("MerchandiseDisplayModelId")
    public void setMerchandiseDisplayModelId(Integer merchandiseDisplayModelId) {
        this.merchandiseDisplayModelId = merchandiseDisplayModelId;
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
