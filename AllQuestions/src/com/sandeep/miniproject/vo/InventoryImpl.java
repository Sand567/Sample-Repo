package com.sandeep.miniproject.vo;

import java.util.HashMap;
import java.util.Map;

import com.sandeep.miniproject.interfaces.Inventory;

public class InventoryImpl<T> implements Inventory<T> {
	
	private Map<T, Integer> inventory = new HashMap<T, Integer>();

	@Override
	public int getQuantity(T item) {
		Integer value = inventory.get(item);
		return value == null ? 0 : value;
	}

	@Override
	public void add(T item) {
		int count = inventory.get(item);
		inventory.put(item, count + 1);
	}

	@Override
	public void deduct(T item) {
		if (hasItem(item)) {
			int count = inventory.get(item);
			inventory.put(item, count - 1);
		}
	}

	@Override
	public boolean hasItem(T item) {
		return getQuantity(item) > 0;
	}

	@Override
	public void clear() {
		inventory.clear();
	}

	@Override
	public void put(T item, int quantity) {
		inventory.put(item, quantity);
	}

}
