
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "UseDutyAboveDeminimis", "UseFeeAboveDeminimis", "UseVatAboveDeminimis", "CalculationCurrencyIso",
        "ProductInputCurrencyIso", "DeliveryInputCurrencyIso", "ProductInputType", "DeliveryInputType",
        "OrderChargeInfos", "FxRates", "RetailerToShopperRate", "ShopperToRetailerRate" })
@DefaultCoder(SerializableCoder.class)
public class CalculationParameters implements Serializable {

    @JsonProperty("UseDutyAboveDeminimis")
    private Boolean useDutyAboveDeminimis;
    @JsonProperty("UseFeeAboveDeminimis")
    private Boolean useFeeAboveDeminimis;
    @JsonProperty("UseVatAboveDeminimis")
    private Boolean useVatAboveDeminimis;
    @JsonProperty("CalculationCurrencyIso")
    private String calculationCurrencyIso;
    @JsonProperty("ProductInputCurrencyIso")
    private String productInputCurrencyIso;
    @JsonProperty("DeliveryInputCurrencyIso")
    private String deliveryInputCurrencyIso;
    @JsonProperty("ProductInputType")
    private Integer productInputType;
    @JsonProperty("DeliveryInputType")
    private Integer deliveryInputType;
    @JsonProperty("OrderChargeInfos")
    private OrderChargeInfos orderChargeInfos;
    @JsonProperty("FxRates")
    private List<FxRate> fxRates = new ArrayList<FxRate>();
    @JsonProperty("RetailerToShopperRate")
    private Double retailerToShopperRate;
    @JsonProperty("ShopperToRetailerRate")
    private Double shopperToRetailerRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5266451718458184736L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CalculationParameters() {
    }

    /**
     * 
     * @param fxRates
     * @param deliveryInputType
     * @param productInputCurrencyIso
     * @param deliveryInputCurrencyIso
     * @param orderChargeInfos
     * @param calculationCurrencyIso
     * @param shopperToRetailerRate
     * @param useFeeAboveDeminimis
     * @param productInputType
     * @param useVatAboveDeminimis
     * @param retailerToShopperRate
     * @param useDutyAboveDeminimis
     */
    public CalculationParameters(Boolean useDutyAboveDeminimis, Boolean useFeeAboveDeminimis,
            Boolean useVatAboveDeminimis, String calculationCurrencyIso, String productInputCurrencyIso,
            String deliveryInputCurrencyIso, Integer productInputType, Integer deliveryInputType,
            OrderChargeInfos orderChargeInfos, List<FxRate> fxRates, Double retailerToShopperRate,
            Double shopperToRetailerRate) {
        super();
        this.useDutyAboveDeminimis = useDutyAboveDeminimis;
        this.useFeeAboveDeminimis = useFeeAboveDeminimis;
        this.useVatAboveDeminimis = useVatAboveDeminimis;
        this.calculationCurrencyIso = calculationCurrencyIso;
        this.productInputCurrencyIso = productInputCurrencyIso;
        this.deliveryInputCurrencyIso = deliveryInputCurrencyIso;
        this.productInputType = productInputType;
        this.deliveryInputType = deliveryInputType;
        this.orderChargeInfos = orderChargeInfos;
        this.fxRates = fxRates;
        this.retailerToShopperRate = retailerToShopperRate;
        this.shopperToRetailerRate = shopperToRetailerRate;
    }

    @JsonProperty("UseDutyAboveDeminimis")
    public Boolean getUseDutyAboveDeminimis() {
        return useDutyAboveDeminimis;
    }

    @JsonProperty("UseDutyAboveDeminimis")
    public void setUseDutyAboveDeminimis(Boolean useDutyAboveDeminimis) {
        this.useDutyAboveDeminimis = useDutyAboveDeminimis;
    }

    @JsonProperty("UseFeeAboveDeminimis")
    public Boolean getUseFeeAboveDeminimis() {
        return useFeeAboveDeminimis;
    }

    @JsonProperty("UseFeeAboveDeminimis")
    public void setUseFeeAboveDeminimis(Boolean useFeeAboveDeminimis) {
        this.useFeeAboveDeminimis = useFeeAboveDeminimis;
    }

    @JsonProperty("UseVatAboveDeminimis")
    public Boolean getUseVatAboveDeminimis() {
        return useVatAboveDeminimis;
    }

    @JsonProperty("UseVatAboveDeminimis")
    public void setUseVatAboveDeminimis(Boolean useVatAboveDeminimis) {
        this.useVatAboveDeminimis = useVatAboveDeminimis;
    }

    @JsonProperty("CalculationCurrencyIso")
    public String getCalculationCurrencyIso() {
        return calculationCurrencyIso;
    }

    @JsonProperty("CalculationCurrencyIso")
    public void setCalculationCurrencyIso(String calculationCurrencyIso) {
        this.calculationCurrencyIso = calculationCurrencyIso;
    }

    @JsonProperty("ProductInputCurrencyIso")
    public String getProductInputCurrencyIso() {
        return productInputCurrencyIso;
    }

    @JsonProperty("ProductInputCurrencyIso")
    public void setProductInputCurrencyIso(String productInputCurrencyIso) {
        this.productInputCurrencyIso = productInputCurrencyIso;
    }

    @JsonProperty("DeliveryInputCurrencyIso")
    public String getDeliveryInputCurrencyIso() {
        return deliveryInputCurrencyIso;
    }

    @JsonProperty("DeliveryInputCurrencyIso")
    public void setDeliveryInputCurrencyIso(String deliveryInputCurrencyIso) {
        this.deliveryInputCurrencyIso = deliveryInputCurrencyIso;
    }

    @JsonProperty("ProductInputType")
    public Integer getProductInputType() {
        return productInputType;
    }

    @JsonProperty("ProductInputType")
    public void setProductInputType(Integer productInputType) {
        this.productInputType = productInputType;
    }

    @JsonProperty("DeliveryInputType")
    public Integer getDeliveryInputType() {
        return deliveryInputType;
    }

    @JsonProperty("DeliveryInputType")
    public void setDeliveryInputType(Integer deliveryInputType) {
        this.deliveryInputType = deliveryInputType;
    }

    @JsonProperty("OrderChargeInfos")
    public OrderChargeInfos getOrderChargeInfos() {
        return orderChargeInfos;
    }

    @JsonProperty("OrderChargeInfos")
    public void setOrderChargeInfos(OrderChargeInfos orderChargeInfos) {
        this.orderChargeInfos = orderChargeInfos;
    }

    @JsonProperty("FxRates")
    public List<FxRate> getFxRates() {
        return fxRates;
    }

    @JsonProperty("FxRates")
    public void setFxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }

    @JsonProperty("RetailerToShopperRate")
    public Double getRetailerToShopperRate() {
        return retailerToShopperRate;
    }

    @JsonProperty("RetailerToShopperRate")
    public void setRetailerToShopperRate(Double retailerToShopperRate) {
        this.retailerToShopperRate = retailerToShopperRate;
    }

    @JsonProperty("ShopperToRetailerRate")
    public Double getShopperToRetailerRate() {
        return shopperToRetailerRate;
    }

    @JsonProperty("ShopperToRetailerRate")
    public void setShopperToRetailerRate(Double shopperToRetailerRate) {
        this.shopperToRetailerRate = shopperToRetailerRate;
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
