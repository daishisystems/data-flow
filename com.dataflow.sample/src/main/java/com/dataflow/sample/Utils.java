package com.dataflow.sample;

public class Utils {
    public static String mask(String input, char mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(mask);
        }
        return sb.toString();
    }
}