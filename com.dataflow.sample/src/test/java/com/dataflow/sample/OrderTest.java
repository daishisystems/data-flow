package com.dataflow.sample;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class OrderTest {
    @Test
    public void ordersAreSortedByCreated() {

        long firstTimestamp = 1539093918;
        long secondTimestamp = 1539093930;
        long thirdTimestamp = 1539093959;

        Order order1 = new Order();
        order1.setCreated((long) firstTimestamp);
        Order order2 = new Order();
        order2.setCreated((long) secondTimestamp);
        Order order3 = new Order();
        order3.setCreated((long) thirdTimestamp);

        List<Order> orders = new ArrayList<>();
        orders.add(order3);
        orders.add(order1);
        orders.add(order2);

        Order.SortOrders(orders);

        assertTrue(orders.get(0).getCreated() == firstTimestamp);
        assertTrue(orders.get(1).getCreated() == secondTimestamp);
        assertTrue(orders.get(2).getCreated() == thirdTimestamp);
    }

    @Test
    public void maxDifferenceBetweenOrderCreatedIsCalculated() {
        long firstTimestamp = 1539093918;
        long secondTimestamp = 1539093930;
        long thirdTimestamp = 1539093959;

        Order order1 = new Order();
        order1.setCreated((long) firstTimestamp);
        Order order2 = new Order();
        order2.setCreated((long) secondTimestamp);
        Order order3 = new Order();
        order3.setCreated((long) thirdTimestamp);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        OrderDifference orderDifference = new OrderDifference();
        Order o1 = null;
        Order o2 = null;
        long createdDifference = 0;

        for (int i = 1; i < orders.size(); i++) {
            o1 = orders.get(i);
            o2 = orders.get(i - 1);
            createdDifference = o1.getCreated() - o2.getCreated();

            if (createdDifference > orderDifference.getCreatedDifference()) {
                orderDifference.setFirstOrder(o1);
                orderDifference.setSecondOrder(o2);
                orderDifference.setCreatedDifference(createdDifference);
            }
        }

        assertTrue(orderDifference.getCreatedDifference() == 29);
    }
}
