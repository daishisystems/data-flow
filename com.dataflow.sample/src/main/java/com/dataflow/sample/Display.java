
package com.dataflow.sample;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "BrandCountryDisplayModelId", "ProductDisplay", "DutyAndTaxDisplay1", "DutyAndTaxDisplay2",
        "DeliveryDisplay" })
@DefaultCoder(SerializableCoder.class)
public class Display implements Serializable {

    @JsonProperty("BrandCountryDisplayModelId")
    private Integer brandCountryDisplayModelId;
    @JsonProperty("ProductDisplay")
    private ProductDisplay productDisplay;
    @JsonProperty("DutyAndTaxDisplay1")
    private DutyAndTaxDisplay dutyAndTaxDisplay1;
    @JsonProperty("DutyAndTaxDisplay2")
    private DutyAndTaxDisplay dutyAndTaxDisplay2;
    @JsonProperty("DeliveryDisplay")
    private DeliveryDisplay deliveryDisplay;
    private final static long serialVersionUID = -5642897715618819590L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Display() {
    }

    /**
     * 
     * @param dutyAndTaxDisplay1
     * @param dutyAndTaxDisplay2
     * @param deliveryDisplay
     * @param brandCountryDisplayModelId
     * @param productDisplay
     */
    public Display(Integer brandCountryDisplayModelId, ProductDisplay productDisplay,
            DutyAndTaxDisplay dutyAndTaxDisplay1, DutyAndTaxDisplay dutyAndTaxDisplay2,
            DeliveryDisplay deliveryDisplay) {
        super();
        this.brandCountryDisplayModelId = brandCountryDisplayModelId;
        this.productDisplay = productDisplay;
        this.dutyAndTaxDisplay1 = dutyAndTaxDisplay1;
        this.dutyAndTaxDisplay2 = dutyAndTaxDisplay2;
        this.deliveryDisplay = deliveryDisplay;
    }

    @JsonProperty("BrandCountryDisplayModelId")
    public Integer getBrandCountryDisplayModelId() {
        return brandCountryDisplayModelId;
    }

    @JsonProperty("BrandCountryDisplayModelId")
    public void setBrandCountryDisplayModelId(Integer brandCountryDisplayModelId) {
        this.brandCountryDisplayModelId = brandCountryDisplayModelId;
    }

    @JsonProperty("ProductDisplay")
    public ProductDisplay getProductDisplay() {
        return productDisplay;
    }

    @JsonProperty("ProductDisplay")
    public void setProductDisplay(ProductDisplay productDisplay) {
        this.productDisplay = productDisplay;
    }

    @JsonProperty("DutyAndTaxDisplay1")
    public DutyAndTaxDisplay getDutyAndTaxDisplay1() {
        return dutyAndTaxDisplay1;
    }

    @JsonProperty("DutyAndTaxDisplay1")
    public void setDutyAndTaxDisplay1(DutyAndTaxDisplay dutyAndTaxDisplay1) {
        this.dutyAndTaxDisplay1 = dutyAndTaxDisplay1;
    }

    @JsonProperty("DutyAndTaxDisplay2")
    public DutyAndTaxDisplay getDutyAndTaxDisplay2() {
        return dutyAndTaxDisplay2;
    }

    @JsonProperty("DutyAndTaxDisplay2")
    public void setDutyAndTaxDisplay2(DutyAndTaxDisplay dutyAndTaxDisplay2) {
        this.dutyAndTaxDisplay2 = dutyAndTaxDisplay2;
    }

    @JsonProperty("DeliveryDisplay")
    public DeliveryDisplay getDeliveryDisplay() {
        return deliveryDisplay;
    }

    @JsonProperty("DeliveryDisplay")
    public void setDeliveryDisplay(DeliveryDisplay deliveryDisplay) {
        this.deliveryDisplay = deliveryDisplay;
    }
}
