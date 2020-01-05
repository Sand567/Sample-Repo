package com.sandeep.fibonacci;

import java.util.Arrays;

public class FibanacciCalculator {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(calcFibonacci(12)));
	}

	/**
	 * Calculates Fibonacci series and stores it in an array
	 * @param number
	 * @return: int[] result
	 */
	private static int[] calcFibonacci(int number) {
		
		int[] result = new int[number];
		result[0] = 1;
		result[1] = 1;
		
		for(int i = 2; i < number; i++) {
			result[i] = result[i-1] + result[i-2];
		}

		return result;
		
	}

}
