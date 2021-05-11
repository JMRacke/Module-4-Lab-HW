/*
 * Author: Joseph Racke
 * Class: CIS 255 Olympic College Spring 2021
 * Date: 10 MAY 2021
 */


package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.LinkedHashSet;
import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl implements Orders {
	
	
	/* This creates the new set to be used to add orders to */
	private LinkedHashSet<TacoImpl> tacoSet2 = new LinkedHashSet<TacoImpl>();
	
    /* This method adds orders to the Set */
    public void addOrder(TacoImpl tacoOrder) {
    	tacoSet2.add(tacoOrder);
    }

    /*
     * If the set is not empty then this will return true.
     */
    public boolean hasNext() {
        if(!(this.tacoSet2.isEmpty()))
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    /*
     * As long as the set is not empty this will pull the next
     * order in the Set. If it is empty then the program will throw
     * a runtime exception stating that there is no more orders.
     */
    public TacoImpl closeNextOrder() {
        if(this.hasNext())
        {
        	TacoImpl nextOrder = tacoSet2.iterator().next();
        	tacoSet2.remove(nextOrder);
        	return nextOrder;
        }
        else
        {
        	throw new RuntimeException("There are no more orders.");
        }
    }

    /*
     * This method uses the size() function to return the amount
     * of orders in the set.
     */
    public int howManyOrders() {
        return this.tacoSet2.size();
    }
}
