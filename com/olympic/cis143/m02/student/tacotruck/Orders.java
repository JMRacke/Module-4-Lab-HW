package com.olympic.cis143.m02.student.tacotruck;

public interface Orders {
	
	public void addOrder(TacoImpl tacoOrder);
	public boolean hasNext();
	public TacoImpl closeNextOrder();
	public int howManyOrders();
}
