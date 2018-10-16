package com.dataflow.sample;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

        List<Order> sortedOrders = sortOrders(orders.iterator());

        assertTrue(sortedOrders.get(0).getCreated() == firstTimestamp);
        assertTrue(sortedOrders.get(1).getCreated() == secondTimestamp);
        assertTrue(sortedOrders.get(2).getCreated() == thirdTimestamp);
    }

    @Test
    public void maxDifferenceBetweenOrderCreatedIsCalculated() {
        Order order1 = new Order();
        order1.setCreated((long) 1539093918);
        Order order2 = new Order();
        order2.setCreated((long) 1539093930);
        Order order3 = new Order();
        order3.setCreated((long) 1539093959);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        long maxDiff = maxDiff(orders);
        assertTrue(maxDiff == 29);
    }

    @Test
    public void maxDifferenceIsZeroForSingleItemOrderCollection() {
        Order order = new Order();

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        long maxDiff = maxDiff(orders);
        assertTrue(maxDiff == 0);
    }

    @Test
    public void orderStageIsDetermined() {

        final String finalStage = "COMPLETE";

        Order order1 = new Order();
        order1.setEventName("START");
        Order order2 = new Order();
        order1.setEventName("PROCESSING");
        Order order3 = new Order();
        order3.setEventName(finalStage);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        String orderStage = orderStage(orders);
        assertTrue(orderStage == finalStage);
    }

    @Test
    public void orderIsComplete() {

        final String orderCompleteIdentifier = "COMPLETE";

        Order order1 = new Order();
        order1.setEventName("START");
        Order order2 = new Order();
        order1.setEventName(orderCompleteIdentifier);
        Order order3 = new Order();
        order3.setEventName("ADDITIONAL");

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        Boolean orderIsComplete = orderIsComplete(orders, orderCompleteIdentifier);
        assertTrue(orderIsComplete);
    }

    /**
     * Returns the maximum difference between any pair of adjacent orders in a
     * collection.
     * 
     * @param orders collection of orders to traverse
     * @return maximum difference between any pair of adjacent orders
     */
    long maxDiff(List<Order> orders) {
        Iterator<Order> iterator = orders.iterator();
        long diff = 0;
        if (!iterator.hasNext()) {
            return diff;
        }
        Order previous = iterator.next();
        if (!iterator.hasNext()) {
            return diff;
        }
        do {
            Order current = iterator.next();
            long currentDiff = current.getCreated() - previous.getCreated();
            if (currentDiff > diff) {
                diff = currentDiff;
            }
            previous = current;
        } while (iterator.hasNext());
        return diff;
    }

    /**
     * Sorts an iterable collection of orders by created-date.
     * 
     * @param orders orders to sort
     * @return collection of sorted orders
     */
    List<Order> sortOrders(Iterator<Order> orders) {
        List<Order> sortedOrders = new ArrayList<>();
        while (orders.hasNext()) {
            sortedOrders.add((Order) orders.next());
        }
        Collections.sort(sortedOrders, (o1, o2) -> new Long(o1.getCreated()).compareTo(new Long((o2.getCreated()))));
        return sortedOrders;
    }

    /**
     * Returns the name of the last event-name in a collection of orders.
     * 
     * @param orders collection of orders to traverse
     * @return name of the last event-name in a collection of orders
     */
    String orderStage(List<Order> orders) {
        if (orders.isEmpty()) {
            return "";
        }
        return orders.get(orders.size() - 1).getEventName();
    }

    /**
     * Determines whether or not an order is complete, based on a collection of
     * orders that represent multiple stages of the same order. The function
     * traverses the order collection until an order-complete stage is found, or the
     * entire collection is traversed.
     * 
     * @param orders                  the orders to traverse
     * @param orderCompleteIdentifier value that represents the name of an
     *                                order-complete event
     * @return true if any order stage is complete
     */
    boolean orderIsComplete(List<Order> ordersStages, String orderCompleteIdentifier) {
        if (ordersStages.isEmpty()) {
            return false;
        }
        int index = 0;
        boolean complete = false;
        do {
            if (ordersStages.get(index++).getEventName() == orderCompleteIdentifier) {
                complete = true;
            }
        } while (!complete || index < ordersStages.size());
        return complete;
    }
}