package com.dataflow.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void StringIsMasked() {
        final String input = "INPUT";
        String masked = Utils.mask(input, '#');
        assertEquals("#####", masked);
    }

    @Test
    public void ObjectIsMasked() {
        final Object input = "INPUT";
        String masked = Utils.mask(input.toString(), '#');
        assertEquals("#####", masked);
    }
}