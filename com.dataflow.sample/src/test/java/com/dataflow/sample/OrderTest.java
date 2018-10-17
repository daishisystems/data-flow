package com.dataflow.sample;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class OrderTest {
    @Test
    public void ordersAreSortedByCreated() {
        long firstTimestamp = 1539093918;
        long secondTimestamp = 1539093930;
        long thirdTimestamp = 1539093959;

        Order order1 = new Order();
        order1.setCreated(firstTimestamp);
        Order order2 = new Order();
        order2.setCreated(secondTimestamp);
        Order order3 = new Order();
        order3.setCreated(thirdTimestamp);

        List<Order> orders = new ArrayList<>();
        orders.add(order3);
        orders.add(order1);
        orders.add(order2);

        List<Order> sortedOrders = OrderSummary.sortOrders(orders.iterator());

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

        Order order1 = new Order();
        order1.setCreated((long) 1539093918);
        order1.setEventName(order1EventName);
        Order order2 = new Order();
        order2.setCreated((long) 1539093930);
        order2.setEventName(order2EventName);
        Order order3 = new Order();
        order3.setCreated((long) 1539093959);
        order3.setEventName(order3EventName);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        OrderSummary orderSummary = OrderSummary.orderSummary(orders, orderCompleteIdentifier);
        assertTrue(orderSummary.getMin() == 12);
        assertTrue(orderSummary.getAvg() == 20);
        assertTrue(orderSummary.getMax() == 29);
        assertTrue(orderSummary.getMaxfirstEventName() == order2EventName);
        assertTrue(orderSummary.getMaxSecondEventName() == order3EventName);
        assertTrue(orderSummary.getMinFirstEventName() == order1EventName);
        assertTrue(orderSummary.getMinSecondEventName() == order2EventName);
        assertTrue(orderSummary.getLastEventName() == order3EventName);
        assertTrue(orderSummary.getComplete());
    }
}