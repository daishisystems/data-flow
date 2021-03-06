package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "OrderArticles", "Available", "CalculationRates", "VatRate", "DutyRate", "Weight", "WeightUnit",
        "CountryOfOriginIso", "HsCode", "EstimatedDeliveryDate", "Quantity", "Product", "LineItemId", "CartGrouping",
        "IsCountryDefault", "ChargeTargets" })
@DefaultCoder(SerializableCoder.class)
public class OrderItem implements Serializable {

    @JsonProperty("OrderArticlesAll")
    private List<OrderArticle> orderArticles = new ArrayList<OrderArticle>();
    @JsonProperty("Available")
    private Boolean available;
    @JsonProperty("CalculationRates")
    private CalculationRates calculationRates;
    @JsonProperty("VatRate")
    private Double vatRate;
    @JsonProperty("DutyRate")
    private Double dutyRate;
    @JsonProperty("Weight")
    private Double weight;
    @JsonProperty("WeightUnit")
    private Integer weightUnit;
    @JsonProperty("CountryOfOriginIso")
    private String countryOfOriginIso;
    @JsonProperty("HsCode")
    private String hsCode;
    @JsonProperty("EstimatedDeliveryDate")
    private String estimatedDeliveryDate;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Product")
    private Product product;
    @JsonProperty("LineItemId")
    private String lineItemId;
    @JsonProperty("CartGrouping")
    private String cartGrouping;    
    @JsonProperty("IsCountryDefault")
    private Boolean isCountryDefault;
    @JsonProperty("ChargeTargets")
    private List<ChargeTarget> chargeTargets = new ArrayList<ChargeTarget>();
    private final static long serialVersionUID = 1957550042165809398L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderItem() {
    }

    /**
     * 
     * @param orderArticles
     * @param weight
     * @param weightUnit
     * @param hsCode
     * @param estimatedDeliveryDate
     * @param lineItemId
     * @param available
     * @param vatRate
     * @param chargeTargets
     * @param product
     * @param cartGrouping     
     * @param countryOfOriginIso
     * @param quantity
     * @param calculationRates
     * @param isCountryDefault
     * @param dutyRate
     */
    public OrderItem(List<OrderArticle> orderArticles, Boolean available, CalculationRates calculationRates,
            Double vatRate, Double dutyRate, Double weight, Integer weightUnit, String countryOfOriginIso,
            String hsCode, String estimatedDeliveryDate, Integer quantity, Product product, String lineItemId,
            String cartGrouping, Boolean isCountryDefault,
            List<ChargeTarget> chargeTargets) {
        super();
        this.orderArticles = orderArticles;
        this.available = available;
        this.calculationRates = calculationRates;
        this.vatRate = vatRate;
        this.dutyRate = dutyRate;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.countryOfOriginIso = countryOfOriginIso;
        this.hsCode = hsCode;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.quantity = quantity;
        this.product = product;
        this.lineItemId = lineItemId;
        this.cartGrouping = cartGrouping;        
        this.isCountryDefault = isCountryDefault;
        this.chargeTargets = chargeTargets;
    }

    @JsonProperty("OrderArticlesAll")
    public List<OrderArticle> getOrderArticles() {
        return orderArticles;
    }

    @JsonProperty("OrderArticlesAll")
    public void setOrderArticles(List<OrderArticle> orderArticles) {
        if (orderArticles != null) {
            this.orderArticles = orderArticles;
        }
    }

    @JsonProperty("Available")
    public Boolean getAvailable() {
        return available;
    }

    @JsonProperty("Available")
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @JsonProperty("CalculationRates")
    public CalculationRates getCalculationRates() {
        return calculationRates;
    }

    @JsonProperty("CalculationRates")
    public void setCalculationRates(CalculationRates calculationRates) {
        this.calculationRates = calculationRates;
    }

    @JsonProperty("VatRate")
    public Double getVatRate() {
        return vatRate;
    }

    @JsonProperty("VatRate")
    public void setVatRate(Double vatRate) {
        this.vatRate = Utils.round(vatRate);
    }

    @JsonProperty("DutyRate")
    public Double getDutyRate() {
        return dutyRate;
    }

    @JsonProperty("DutyRate")
    public void setDutyRate(Double dutyRate) {
        this.dutyRate = Utils.round(dutyRate);
    }

    @JsonProperty("Weight")
    public Double getWeight() {
        return weight;
    }

    @JsonProperty("Weight")
    public void setWeight(Double weight) {
        this.weight = Utils.round(weight);
    }

    @JsonProperty("WeightUnit")
    public Integer getWeightUnit() {
        return weightUnit;
    }

    @JsonProperty("WeightUnit")
    public void setWeightUnit(Integer weightUnit) {
        this.weightUnit = weightUnit;
    }

    @JsonProperty("CountryOfOriginIso")
    public String getCountryOfOriginIso() {
        return countryOfOriginIso;
    }

    @JsonProperty("CountryOfOriginIso")
    public void setCountryOfOriginIso(String countryOfOriginIso) {
        this.countryOfOriginIso = countryOfOriginIso;
    }

    @JsonProperty("HsCode")
    public String getHsCode() {
        return hsCode;
    }

    @JsonProperty("HsCode")
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    @JsonProperty("EstimatedDeliveryDate")
    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Product")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("Product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("LineItemId")
    public String getLineItemId() {
        return lineItemId;
    }

    @JsonProperty("LineItemId")
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @JsonProperty("CartGrouping")
    public String getCartGrouping() {
        return cartGrouping;
    }

    @JsonProperty("CartGrouping")
    public void setCartGrouping(String cartGrouping) {
        this.cartGrouping = cartGrouping;
    }    

    @JsonProperty("IsCountryDefault")
    public Boolean getIsCountryDefault() {
        return isCountryDefault;
    }

    @JsonProperty("IsCountryDefault")
    public void setIsCountryDefault(Boolean isCountryDefault) {
        this.isCountryDefault = isCountryDefault;
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
