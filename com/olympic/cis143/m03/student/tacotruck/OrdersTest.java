package com.olympic.cis143.m03.student.tacotruck;

import com.olympic.cis143.m03.student.tacotruck.list.OrdersListImpl;
import com.olympic.cis143.m03.student.tacotruck.queue.OrdersQueueImpl;

public class OrdersTest {

    public static void main(String[] args) {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);

        Orders orders = new OrdersQueueImpl();
        Orders arrayListOrders = new OrdersListImpl();
        
        orders.addOrder(firstTaco);
        arrayListOrders.addOrder(firstTaco);
        
        if (!orders.hasNext() && !arrayListOrders.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        TacoImpl closedTaco = orders.closeNextOrder();
        TacoImpl closedTacoArrayList = arrayListOrders.closeNextOrder();
        if (closedTaco == null && closedTacoArrayList == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco) && !closedTacoArrayList.equals(firstTaco)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (orders.hasNext() && arrayListOrders.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
    }

    public void testCloseNextOrder() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);

        Orders orders = new OrdersQueueImpl();
        Orders arrayListOrders = new OrdersListImpl();
        
        orders.addOrder(firstTaco);
        orders.addOrder(secondTaco);
        
        arrayListOrders.addOrder(firstTaco);
        arrayListOrders.addOrder(secondTaco);
        
        TacoImpl shouldBeFirstTaco = orders.closeNextOrder();
        TacoImpl arrayListfirstTaco = arrayListOrders.closeNextOrder();
        
        if (orders.howManyOrders() != 1 && orders.howManyOrders() != 1) {
            throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco) && firstTaco.equals(arrayListfirstTaco)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
    }
}
