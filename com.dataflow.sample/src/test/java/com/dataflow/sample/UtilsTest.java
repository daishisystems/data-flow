package com.dataflow.sample;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

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

    @Test
    public void orderIsPartiallyMasked() throws JsonParseException, JsonMappingException, IOException {
        String json = getFile("order.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        MasterOrder masterOrder = mapper.readValue(json, MasterOrder.class);

        List<DeliveryDetail> deliveryDetails = masterOrder.getDeliveryDetails();
        for (DeliveryDetail deliveryDetail : deliveryDetails) {
            Object contactDetailsNickname = deliveryDetail.getContactDetailsNickName();
            if (contactDetailsNickname != null && !contactDetailsNickname.toString().isEmpty()) {
                deliveryDetail.setContactDetailsNickName(Utils.mask(contactDetailsNickname.toString(), '#'));
            }
        }
        masterOrder.setDeliveryDetails(deliveryDetails);
        assertEquals("######################", masterOrder.getDeliveryDetails().get(0).getContactDetailsNickName());
    }

    @Test
    public void valuesAreRounded() {
        double value = 1.5499999999999999999999999;
        double expected = 1.55;
        double actual = Utils.round(value);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void nullValuesAreIgnored() {
        Double value = null;
        double expected = 0;
        double actual = Utils.round(value);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void fxRatesAreReturnedFromOrder() throws JsonParseException, JsonMappingException, IOException {
        String json = getFile("order.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        MasterOrder masterOrder = mapper.readValue(json, MasterOrder.class);

        Hashtable<String, BigDecimal> fxRates = Utils.getFxRates(masterOrder, "EUR");
        assertEquals(new BigDecimal("0.20"), fxRates.get("RON"));
    }

    @Test
    public void valueIsConvertedByCurrencyConversionRate() {
        final BigDecimal amount = new BigDecimal("100");
        final BigDecimal conversionRate = new BigDecimal("0.20");

        BigDecimal converted = Utils.convertCurrency(amount, conversionRate);
        assertEquals(new BigDecimal("20.00"), converted);
    }

    @Test
    public void NumberisRounded() {
        BigDecimal pi = new BigDecimal("3.14159265359");
        BigDecimal rounded = Utils.rounded(pi);

        assertEquals("3.14", rounded.toString());
    }

    @Test
    public void ordersAreGroupedByOrderCode() {

        String order1Code = "ORDER1";
        String order2Code = "ORDER2";

        MasterOrder order1 = new MasterOrder();
        order1.setOrderCode(order1Code);

        MasterOrder order2 = new MasterOrder();
        order2.setOrderCode(order2Code);

        List<MasterOrder> masterOrders = new ArrayList<MasterOrder>();

        masterOrders.add(order1);
        masterOrders.add(order2);

        List<List<MasterOrder>> groupedOrders = Utils.groupOrders(masterOrders);

        assertEquals(2, groupedOrders.size());
        assertEquals(order1Code, groupedOrders.get(0).get(0).getOrderCode());
        assertEquals(order2Code, groupedOrders.get(1).get(0).getOrderCode());
    }

    /**
     * Sorts an iterable collection of orders by created-date.
     * 
     * @version 1.0
     * 
     * @author Paul Mooney
     */
    public static List<MasterOrder> sortOrders(Iterable<MasterOrder> orders) {

        List<MasterOrder> sortedOrders = new ArrayList<>();
        Iterator<MasterOrder> iterator = orders.iterator();
        while (iterator.hasNext()) {
            sortedOrders.add((MasterOrder) iterator.next());
        }
        Collections.sort(sortedOrders, (o1, o2) -> new Long(o1.getCreated()).compareTo(new Long((o2.getCreated()))));
        return sortedOrders;
    }

    private String getFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}