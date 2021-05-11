/*
 * Author: Joseph Racke
 * Class: CIS 255 Olympic College Spring 2021
 * Date: 10 MAY 2021
 */

package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;


import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class OrdersMapImpl implements Orders {

	// Creates a private LinkedHashMap with String type Keys and TacoImpl type values
	private LinkedHashMap<String,TacoImpl> tacoMap = new LinkedHashMap<String,TacoImpl>();
	
    /*
     * Creates an order with the orderid given and type null (until it's filled)
     */
    public void createOrder(final String orderid) {
    	tacoMap.put(orderid, null);
    }

    /*
     * Checks to see if the orderid is in the Map, if it is it adds the taco order
     * to the orderid. If not, it'll throw an exception saying that orderid doesn't exist
     */
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	if(tacoMap.containsKey(orderid))
    	{
    		tacoMap.replace(orderid, taco);
    	}
    	else throw new OrderDoesNotExistException(orderid);
    }

    // Checks to see if the HashMap is empty
    public boolean hasNext() {
    	if(!(this.tacoMap.isEmpty()))
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

	// This instantiates a List<> to add the orders to and then removes the order from the Map
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
        if (this.hasNext())
        {
        	List<TacoImpl> orderList = new ArrayList<TacoImpl>();
        	orderList.add(tacoMap.remove(orderid));
        	return orderList;
        }
        else throw new OrderDoesNotExistException(orderid);
    }

    // This method returns how many orders are still in the Map
    public int howManyOrders() {
        return this.tacoMap.size();
    }

    /*
     *  This method determines if the orderid exists in the Map, if it does then it checks to
     *  see if the value of that orderid is not 'null' (as in nothing has been added to the orderid yet)
     *  If it isn't null then it returns the list of orders.
     */
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        if(tacoMap.containsKey(orderid))
        {
        	List<TacoImpl> orderList = new ArrayList<TacoImpl>();
        	if(tacoMap.get(orderid) != null)
        	{
        		orderList.add(tacoMap.get(orderid));
        	}
        	return orderList;
        }
        else throw new OrderDoesNotExistException(orderid);
    }
}
