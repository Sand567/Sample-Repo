package com.sandeep.miniproject.implementation;

import java.util.List;

import com.sandeep.miniproject.enums.Coin;
import com.sandeep.miniproject.enums.Item;
import com.sandeep.miniproject.interfaces.VendingMachine;
import com.sandeep.miniproject.vo.Bucket;

public class VendingMachineImpl implements VendingMachine {

	@Override
	public long selectItemAndGetPrice(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coin> refund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
