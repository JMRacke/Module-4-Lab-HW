package com.olympic.cis143.m03.student.tacotruck.list;

import java.util.ArrayList;

import com.olympic.cis143.m03.student.tacotruck.Orders;
import com.olympic.cis143.m03.student.tacotruck.TacoImpl;

public class OrdersListImpl implements Orders
{
	
	private ArrayList<TacoImpl> tacoArrayList = new ArrayList<TacoImpl>();
	
	// TODO implement method
	public void addOrder(TacoImpl tacoOrder) 
	{
		tacoArrayList.add(tacoOrder);
	}
	
	// TODO implement method
	public boolean hasNext() 
	{
		if(tacoArrayList.size() != 0)
		{
			return true;
		} else {
			return false;
		}
		
	}
	
	// TODO implement method
	public TacoImpl closeNextOrder()
	{
		if(hasNext()) 
		{
			return tacoArrayList.remove(0);
		} else {
			throw new RuntimeException("There are no more orders.");
		}
	}
	
	// TODO implement method
	public int howManyOrders()
	{
		return tacoArrayList.size();
	}
}
