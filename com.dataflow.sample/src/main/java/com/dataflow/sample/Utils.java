package com.dataflow.sample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;
import java.util.List;

public class Utils {
    final private static int POWER_OF = 10;
    final private static int NUM_DECIMAL_PLACES = 2;

    public static String mask(String input, char mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(mask);
        }
        return sb.toString();
    }

    public static Double round(Double value) {
        if (value == null) {
            return 0d;
        }
        double scale = Math.pow(POWER_OF, NUM_DECIMAL_PLACES);
        return Math.round(value * scale) / scale;
    }

    /**
     * getFxRates returns a list of non-Euro to Euro conversion rates.
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */
    public static Hashtable<String, BigDecimal> getFxRates(MasterOrder masterOrder, String baseCurrency) {
        if (masterOrder == null || masterOrder.getCalculationParameters() == null) {
            return null;
        }
        List<FxRate> allFxRates = masterOrder.getCalculationParameters().getFxRates();
        if (allFxRates == null) {
            return null;
        }

        Hashtable<String, BigDecimal> fxRates = new Hashtable<String, BigDecimal>();
        for (FxRate fxRate : allFxRates) {
            String fromCurrency = fxRate.getFromCurrency();
            if (!fromCurrency.equals(baseCurrency) && fxRate.getToCurrency().equals(baseCurrency)) {
                fxRates.put(fromCurrency, fxRate.getRate());
            }
        }
        return fxRates;
    }

    /**
     * convertCurrency applies {@link conversionRate} to {@link amount}.
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */
    public static BigDecimal convertCurrency(BigDecimal amount, BigDecimal conversionRate) {
        if (amount == null || conversionRate == null) {
            return BigDecimal.ZERO;
        }
        return amount.multiply(conversionRate);
    }

    /**
     * calcOrderValue aggregates delivery and merchanise charge amounts in
     * {@link masterOrder}, for where applicable to {@link currency} .
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */
    public static BigDecimal calcOrderValue(MasterOrder masterOrder, String currency) {
        BigDecimal deliveryCharge = BigDecimal.ZERO;

        for (OrderItem orderItem : masterOrder.getOrderItems()) {
            for (OrderArticle orderArticle : orderItem.getOrderArticles()) {
                for (Charge charge : orderArticle.getCharges()) {
                    String chargeType = charge.getName();
                    if (charge.getExactValue().getCurrencyCodeIso().equals(currency) && (chargeType.equals("Delivery")
                            || chargeType.equals("DeliveryDuties") || chargeType.equals("DeliveryTaxes")
                            || chargeType.equals("DeliveryTaxOnDuties") || chargeType.equals("DeliveryTaxOnFees")
                            || chargeType.equals("DeliveryFees") || chargeType.equals("DeliveryFixedFee"))) {
                        deliveryCharge = deliveryCharge.add(charge.getExactValue().getValue());
                    }
                }
            }
        }

        BigDecimal merchandiseCharge = BigDecimal.ZERO;

        for (OrderItem orderItem : masterOrder.getOrderItems()) {
            for (OrderArticle orderArticle : orderItem.getOrderArticles()) {
                for (Charge charge : orderArticle.getCharges()) {
                    String chargeType = charge.getName();
                    if (charge.getExactValue().getCurrencyCodeIso().equals(currency) && (chargeType.equals("Items")
                            || chargeType.equals("ItemDuties") || chargeType.equals("ItemTaxes")
                            || chargeType.equals("ItemTaxOnDuties") || chargeType.equals("ItemTaxOnFees")
                            || chargeType.equals("ItemFees") || chargeType.equals("ItemFixedFee"))) {
                        merchandiseCharge = merchandiseCharge.add(charge.getExactValue().getValue());
                    }
                }
            }
        }
        return deliveryCharge.add(merchandiseCharge);
    }

    /**
     * rounded rounds {@value number} to 2 decimal places, using bankers' rounding.
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */
    public static BigDecimal rounded(BigDecimal number) {
        return number.setScale(2, RoundingMode.HALF_EVEN);
    }
}