package com.dataflow.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        List<MasterOrder> sortedOrders = OrderSummary.sortOrders(orders.iterator());

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

        String json = getFile("order.json");
        ObjectMapper mapper = new ObjectMapper();
        MasterOrder masterOrder1 = mapper.readValue(json, MasterOrder.class);
        MasterOrder masterOrder2 = masterOrder1;

        List<MasterOrder> masterOrders = new ArrayList<>();
        masterOrders.add(masterOrder1);
        masterOrders.add(masterOrder2);
        OrderSummary orderSummary = OrderSummary.orderSummary(masterOrders, orderCompleteIdentifier);

        Double expected = 14033.58;
        assertEquals(Double.valueOf(expected), Double.valueOf(orderSummary.getOrderValue()));
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