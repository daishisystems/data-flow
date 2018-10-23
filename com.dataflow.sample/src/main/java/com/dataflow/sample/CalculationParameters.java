package com.dataflow.sample;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.SerializableCoder;

@DefaultCoder(SerializableCoder.class)
public class CalculationParameters implements Serializable {
    private boolean UseDutyAboveDeminimis;
    private boolean UseFeeAboveDeminimis;
    private boolean UseVatAboveDeminimis;
    private String CalculationCurrencyIso;
    private String ProductInputCurrencyIso;
    private String DeliveryInputCurrencyIso;
    private float ProductInputType;
    private float DeliveryInputType;
    OrderChargeInfos OrderChargeInfosObject;
    ArrayList<Object> FxRates = new ArrayList<Object>();
    private float RetailerToShopperRate;
    private float ShopperToRetailerRate;

    // Getter Methods

    public boolean getUseDutyAboveDeminimis() {
        return UseDutyAboveDeminimis;
    }

    public boolean getUseFeeAboveDeminimis() {
        return UseFeeAboveDeminimis;
    }

    public boolean getUseVatAboveDeminimis() {
        return UseVatAboveDeminimis;
    }

    public String getCalculationCurrencyIso() {
        return CalculationCurrencyIso;
    }

    public String getProductInputCurrencyIso() {
        return ProductInputCurrencyIso;
    }

    public String getDeliveryInputCurrencyIso() {
        return DeliveryInputCurrencyIso;
    }

    public float getProductInputType() {
        return ProductInputType;
    }

    public float getDeliveryInputType() {
        return DeliveryInputType;
    }

    public OrderChargeInfos getOrderChargeInfos() {
        return OrderChargeInfosObject;
    }

    public float getRetailerToShopperRate() {
        return RetailerToShopperRate;
    }

    public float getShopperToRetailerRate() {
        return ShopperToRetailerRate;
    }

    // Setter Methods

    public void setUseDutyAboveDeminimis(boolean UseDutyAboveDeminimis) {
        this.UseDutyAboveDeminimis = UseDutyAboveDeminimis;
    }

    public void setUseFeeAboveDeminimis(boolean UseFeeAboveDeminimis) {
        this.UseFeeAboveDeminimis = UseFeeAboveDeminimis;
    }

    public void setUseVatAboveDeminimis(boolean UseVatAboveDeminimis) {
        this.UseVatAboveDeminimis = UseVatAboveDeminimis;
    }

    public void setCalculationCurrencyIso(String CalculationCurrencyIso) {
        this.CalculationCurrencyIso = CalculationCurrencyIso;
    }

    public void setProductInputCurrencyIso(String ProductInputCurrencyIso) {
        this.ProductInputCurrencyIso = ProductInputCurrencyIso;
    }

    public void setDeliveryInputCurrencyIso(String DeliveryInputCurrencyIso) {
        this.DeliveryInputCurrencyIso = DeliveryInputCurrencyIso;
    }

    public void setProductInputType(float ProductInputType) {
        this.ProductInputType = ProductInputType;
    }

    public void setDeliveryInputType(float DeliveryInputType) {
        this.DeliveryInputType = DeliveryInputType;
    }

    public void setOrderChargeInfos(OrderChargeInfos OrderChargeInfosObject) {
        this.OrderChargeInfosObject = OrderChargeInfosObject;
    }

    public void setRetailerToShopperRate(float RetailerToShopperRate) {
        this.RetailerToShopperRate = RetailerToShopperRate;
    }

    public void setShopperToRetailerRate(float ShopperToRetailerRate) {
        this.ShopperToRetailerRate = ShopperToRetailerRate;
    }
}