package com.sandeep.miniproject.factory;

import com.sandeep.miniproject.implementation.VendingMachineImpl;
import com.sandeep.miniproject.interfaces.VendingMachine;

public class VendingMachineFactory {
	
	public static VendingMachine createVendingMachine() {
		return new VendingMachineImpl();
	}

}
