package com.sandeep.miniproject.interfaces;

public interface Inventory<T> {
	
	public int getQuantity(T item);
	public void add(T item);
	public void deduct(T item);
	public boolean hasItem(T item);
	public void clear();
	public void put(T item, int quantity);
	
}
