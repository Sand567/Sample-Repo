package com.sandeep.unit2;

public class ThisReferenceExample {
	
	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
		/*
		thisReferenceExample.doProcess(10,  i -> {
			System.out.println("Value of i: " + i);
			System.out.println(this);	// This does not work
		});
		*/
		
		thisReferenceExample.execute();
	}

	private void execute() {
		
		// Here "this" refers to the instance of the class 
		// on which execute is called
		// But "this" does not work in lambdas inside a static context
		doProcess(10, i -> {
			System.out.println("Value of i: " + i);
			System.out.println(this);
		});
	}

	@Override
	public String toString() {
		return "This is from the main class instance";
	}
	
	
	
}
