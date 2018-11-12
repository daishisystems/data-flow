
package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@JsonPropertyOrder({ "ProductCode", "Upc", "Title", "Description", "RetailerCurrencyProductPriceInfo",
        "ShopperCurrencyProductPriceInfo", "ImageUrl", "Color", "Size", "IsRestrictedForCountry", "OverridePrice",
        "Dimension5", "Dimension6", "IsNonStandardCatalogItem", "MetadataItems" })
@DefaultCoder(SerializableCoder.class)
public class Product implements Serializable {

    @JsonProperty("ProductCode")
    private String productCode;
    @JsonProperty("Upc")
    private String upc;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("RetailerCurrencyProductPriceInfo")
    private RetailerCurrencyProductPriceInfo retailerCurrencyProductPriceInfo;
    @JsonProperty("ShopperCurrencyProductPriceInfo")
    private ShopperCurrencyProductPriceInfo shopperCurrencyProductPriceInfo;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("IsRestrictedForCountry")
    private Boolean isRestrictedForCountry;
    @JsonProperty("OverridePrice")
    private Boolean overridePrice;
    @JsonProperty("Dimension5")
    private String dimension5;
    @JsonProperty("Dimension6")
    private String dimension6;
    @JsonProperty("IsNonStandardCatalogItem")
    private Boolean isNonStandardCatalogItem;
    @JsonProperty("MetadataItems")
    private List<MetadataItem> metadataItems = new ArrayList<MetadataItem>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3581130492050196380L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param dimension6
     * @param shopperCurrencyProductPriceInfo
     * @param productCode
     * @param imageUrl
     * @param isNonStandardCatalogItem
     * @param overridePrice
     * @param upc
     * @param size
     * @param title
     * @param metadataItems
     * @param color
     * @param description
     * @param isRestrictedForCountry
     * @param retailerCurrencyProductPriceInfo
     * @param dimension5
     */
    public Product(String productCode, String upc, String title, String description,
            RetailerCurrencyProductPriceInfo retailerCurrencyProductPriceInfo,
            ShopperCurrencyProductPriceInfo shopperCurrencyProductPriceInfo, String imageUrl, String color, String size,
            Boolean isRestrictedForCountry, Boolean overridePrice, String dimension5, String dimension6,
            Boolean isNonStandardCatalogItem, List<MetadataItem> metadataItems) {
        super();
        this.productCode = productCode;
        this.upc = upc;
        this.title = title;
        this.description = description;
        this.retailerCurrencyProductPriceInfo = retailerCurrencyProductPriceInfo;
        this.shopperCurrencyProductPriceInfo = shopperCurrencyProductPriceInfo;
        this.imageUrl = imageUrl;
        this.color = color;
        this.size = size;
        this.isRestrictedForCountry = isRestrictedForCountry;
        this.overridePrice = overridePrice;
        this.dimension5 = dimension5;
        this.dimension6 = dimension6;
        this.isNonStandardCatalogItem = isNonStandardCatalogItem;
        this.metadataItems = metadataItems;
    }

    @JsonProperty("ProductCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("ProductCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("Upc")
    public String getUpc() {
        return upc;
    }

    @JsonProperty("Upc")
    public void setUpc(String upc) {
        this.upc = upc;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("RetailerCurrencyProductPriceInfo")
    public RetailerCurrencyProductPriceInfo getRetailerCurrencyProductPriceInfo() {
        return retailerCurrencyProductPriceInfo;
    }

    @JsonProperty("RetailerCurrencyProductPriceInfo")
    public void setRetailerCurrencyProductPriceInfo(RetailerCurrencyProductPriceInfo retailerCurrencyProductPriceInfo) {
        this.retailerCurrencyProductPriceInfo = retailerCurrencyProductPriceInfo;
    }

    @JsonProperty("ShopperCurrencyProductPriceInfo")
    public ShopperCurrencyProductPriceInfo getShopperCurrencyProductPriceInfo() {
        return shopperCurrencyProductPriceInfo;
    }

    @JsonProperty("ShopperCurrencyProductPriceInfo")
    public void setShopperCurrencyProductPriceInfo(ShopperCurrencyProductPriceInfo shopperCurrencyProductPriceInfo) {
        this.shopperCurrencyProductPriceInfo = shopperCurrencyProductPriceInfo;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("Color")
    public String getColor() {
        return color;
    }

    @JsonProperty("Color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("Size")
    public String getSize() {
        return size;
    }

    @JsonProperty("Size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("IsRestrictedForCountry")
    public Boolean getIsRestrictedForCountry() {
        return isRestrictedForCountry;
    }

    @JsonProperty("IsRestrictedForCountry")
    public void setIsRestrictedForCountry(Boolean isRestrictedForCountry) {
        this.isRestrictedForCountry = isRestrictedForCountry;
    }

    @JsonProperty("OverridePrice")
    public Boolean getOverridePrice() {
        return overridePrice;
    }

    @JsonProperty("OverridePrice")
    public void setOverridePrice(Boolean overridePrice) {
        this.overridePrice = overridePrice;
    }

    @JsonProperty("Dimension5")
    public String getDimension5() {
        return dimension5;
    }

    @JsonProperty("Dimension5")
    public void setDimension5(String dimension5) {
        this.dimension5 = dimension5;
    }

    @JsonProperty("Dimension6")
    public String getDimension6() {
        return dimension6;
    }

    @JsonProperty("Dimension6")
    public void setDimension6(String dimension6) {
        this.dimension6 = dimension6;
    }

    @JsonProperty("IsNonStandardCatalogItem")
    public Boolean getIsNonStandardCatalogItem() {
        return isNonStandardCatalogItem;
    }

    @JsonProperty("IsNonStandardCatalogItem")
    public void setIsNonStandardCatalogItem(Boolean isNonStandardCatalogItem) {
        this.isNonStandardCatalogItem = isNonStandardCatalogItem;
    }

    @JsonProperty("MetadataItems")
    public List<MetadataItem> getMetadataItems() {
        return metadataItems;
    }

    @JsonProperty("MetadataItems")
    public void setMetadataItems(List<MetadataItem> metadataItems) {
        if (metadataItems != null) {
            this.metadataItems = metadataItems;
        }
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
