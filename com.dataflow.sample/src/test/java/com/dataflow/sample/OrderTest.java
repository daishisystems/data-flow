package com.dataflow.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.junit.Test;

public class OrderTest {
    @Test
    public void ordersAreSortedByCreated() {
        long firstTimestamp = 1539093918;
        long secondTimestamp = 1539093930;
        long thirdTimestamp = 1539093959;

        MasterOrder order1 = new MasterOrder();
        order1.setCreated(firstTimestamp);
        MasterOrder order2 = new MasterOrder();
        order2.setCreated(secondTimestamp);
        MasterOrder order3 = new MasterOrder();
        order3.setCreated(thirdTimestamp);

        List<MasterOrder> orders = new ArrayList<>();
        orders.add(order3);
        orders.add(order1);
        orders.add(order2);

        List<MasterOrder> sortedOrders = OrderSummary.sortOrders(orders);

        assertTrue(sortedOrders.get(0).getCreated() == firstTimestamp);
        assertTrue(sortedOrders.get(1).getCreated() == secondTimestamp);
        assertTrue(sortedOrders.get(2).getCreated() == thirdTimestamp);
    }

    @Test
    public void orderSummaryIsCreated() {

        final String order1EventName = "ORDER1";
        final String order2EventName = "ORDER2";
        final String order3EventName = "ORDER3";
        final String orderCompleteIdentifier = "ORDER3";

        MasterOrder order1 = new MasterOrder();
        order1.setCreated((long) 1539093918);
        order1.setEventName(order1EventName);
        MasterOrder order2 = new MasterOrder();
        order2.setCreated((long) 1539093930);
        order2.setEventName(order2EventName);
        MasterOrder order3 = new MasterOrder();
        order3.setCreated((long) 1539093959);
        order3.setEventName(order3EventName);

        List<MasterOrder> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        OrderSummary orderSummary = OrderSummary.orderSummary(orders, orderCompleteIdentifier);
        assertTrue(orderSummary.getMinTimeDelay() == 12);
        assertTrue(orderSummary.getAvgTimedelay() == 20);
        assertTrue(orderSummary.getMaxTimeDelay() == 29);
        assertTrue(orderSummary.getMaxfirstEventName() == order2EventName);
        assertTrue(orderSummary.getMaxSecondEventName() == order3EventName);
        assertTrue(orderSummary.getMinFirstEventName() == order1EventName);
        assertTrue(orderSummary.getMinSecondEventName() == order2EventName);
        assertTrue(orderSummary.getLastEventName() == order3EventName);
        assertTrue(orderSummary.getComplete());
        assertEquals(41, orderSummary.getTotalTime());
    }

    @Test
    public void ChargesItemsAndCountryCodeAreCalculated() throws JsonParseException, JsonMappingException, IOException {
        final String orderCompleteIdentifier = "COMPLETE";

        String json1 = getFile("order.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        MasterOrder masterOrder1 = mapper.readValue(json1, MasterOrder.class);

        String json2 = getFile("order.json");
        MasterOrder masterOrder2 = mapper.readValue(json2, MasterOrder.class);

        List<MasterOrder> masterOrders = new ArrayList<>();
        masterOrders.add(masterOrder1);
        masterOrders.add(masterOrder2);
        OrderSummary orderSummary = OrderSummary.orderSummary(masterOrders, orderCompleteIdentifier);

        BigDecimal expected = new BigDecimal("7317.68");
        assertEquals(expected, orderSummary.getOrderValue());
    }

    @Test
    public void orderIsComplete() {
        final String orderCompleteEventName = "COMPLETE";

        MasterOrder masterOrder1 = new MasterOrder();
        masterOrder1.setEventName("EVENT1");
        MasterOrder masterOrder2 = new MasterOrder();
        masterOrder2.setEventName("EVENT2");
        MasterOrder masterOrder3 = new MasterOrder();
        masterOrder3.setEventName("COMPLETE");

        List<MasterOrder> masterOrders = new ArrayList<>();
        masterOrders.add(masterOrder1);
        masterOrders.add(masterOrder2);
        masterOrders.add(masterOrder3);

        boolean orderIsComplete = OrderSummary.orderIsComplete(masterOrders, orderCompleteEventName);
        assertTrue(orderIsComplete);
    }

    @Test
    public void orderIsNotComplete() {
        final String orderCompleteEventName = "COMPLETE";

        MasterOrder masterOrder1 = new MasterOrder();
        masterOrder1.setEventName("EVENT1");
        MasterOrder masterOrder2 = new MasterOrder();
        masterOrder2.setEventName("EVENT2");
        MasterOrder masterOrder3 = new MasterOrder();
        masterOrder3.setEventName("EVENT3");

        List<MasterOrder> masterOrders = new ArrayList<>();
        masterOrders.add(masterOrder1);
        masterOrders.add(masterOrder2);
        masterOrders.add(masterOrder3);

        boolean orderIsComplete = OrderSummary.orderIsComplete(masterOrders, orderCompleteEventName);
        assertFalse(orderIsComplete);
    }

    @Test
    public void masterOrdersAreEqual() {
        String orderCode = "cf419e1d-a87a-4697-bb81-92ef2f44527d";
        String correlationId = "060fc8e8-befa-42a4-af36-33f6da10e0a2";
        Long created = 1542191931l;
        String eventName = "CREATE";

        MasterOrder masterOrder = new MasterOrder();
        masterOrder.setOrderCode(orderCode);
        masterOrder.setCorrelationId(correlationId);
        masterOrder.setCreated(created);
        masterOrder.setEventName(eventName);

        MasterOrder other = new MasterOrder();
        other.setOrderCode(orderCode);
        other.setCorrelationId(correlationId);
        other.setCreated(created);
        other.setEventName(eventName);

        assertTrue(masterOrder.equals(other));
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