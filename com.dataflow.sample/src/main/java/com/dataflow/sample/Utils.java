package com.dataflow.sample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.joda.time.DateTime;

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
        if (masterOrder.getEShopWorldCurrencyPaymentAmount() != null) {
            return masterOrder.getEShopWorldCurrencyPaymentAmount().getValue();
        } else {
            return new BigDecimal(0);
        }
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

    /**
     * groupOrders groups a disparat collection of {@link MasterOrder}s into
     * individual collections, bsed on {@link MasterOrder.OrderCode} .
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */ // FIXME: Error handling, validation
    public static List<List<MasterOrder>> groupOrders(Iterable<MasterOrder> masterOrders) {

        if (masterOrders == null)
            return null;

        HashMap<String, List<MasterOrder>> orderMap = new HashMap<String, List<MasterOrder>>();

        for (MasterOrder masterOrder : masterOrders) {
            if (!orderMap.containsKey(masterOrder.getOrderCode())) {
                List<MasterOrder> orderList = new ArrayList<MasterOrder>();
                orderList.add(masterOrder);
                orderMap.put(masterOrder.getOrderCode(), orderList);
            } else {
                orderMap.get(masterOrder.getOrderCode()).add(masterOrder);
            }
        }

        return new ArrayList<List<MasterOrder>>(orderMap.values());
    }

    public static boolean startsWithDigit(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }
        return Character.isDigit(input.charAt(0));
    }

    public static String convertUnixDate(String unixDate) {

        if (unixDate == null || unixDate.isEmpty()) {
            return "1970-01-01T00:00:00+01:00";
        }
        return new DateTime(Long.parseLong(unixDate.substring(0, 13))).toString();
    }

}