package com.sandeep.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		
		int a = 10;
		
		// here the variable b should be final
		// the value of b should not change
		// if we are trying to to change the value of b within
		// the anonymous class it will then throw an error
		int b = 20;
		doProcess(a, i -> System.out.println(i + b));

	}
	
	private static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}
