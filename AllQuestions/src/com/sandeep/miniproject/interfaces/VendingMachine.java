package com.sandeep.miniproject.interfaces;

import java.util.List;

import com.sandeep.miniproject.enums.*;
import com.sandeep.miniproject.vo.Bucket;

public interface VendingMachine {
	
	public long selectItemAndGetPrice(Item item);
	public void insertCoin(Coin coin);
	public List<Coin> refund();
	public Bucket<Item, List<Coin>> collectItemAndChange();
	public void reset();

}
