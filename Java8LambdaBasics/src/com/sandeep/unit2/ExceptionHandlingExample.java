package com.sandeep.unit2;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		
		int[] numbers = {2, 6, 7, 4};
		int key = 2;
		
		process(numbers, key);

	}

	private static void process(int[] numbers, int key) {
		
		for(int i : numbers) {
			System.out.println(i + key);
		}
		
	}

}
