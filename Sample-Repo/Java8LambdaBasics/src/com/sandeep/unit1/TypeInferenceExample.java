package com.sandeep.unit1;

public class TypeInferenceExample {

	public static void main(String[] args) {
		
		printLambda(s -> s.length());
		
	}
	
	private static void printLambda(StringLengthLambda s) {
		System.out.println(s.getLength("Hello lambda"));
	}
	
	interface StringLengthLambda {
		int getLength(String s);
	}

}
