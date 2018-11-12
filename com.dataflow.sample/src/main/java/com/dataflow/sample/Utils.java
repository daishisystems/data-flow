package com.dataflow.sample;

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
}