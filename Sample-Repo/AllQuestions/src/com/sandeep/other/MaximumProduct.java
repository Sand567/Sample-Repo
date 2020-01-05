package com.sandeep.other;

public class MaximumProduct {

	public static void main(String[] args) {
		
		int[] intArray = {2, 5, 13, 4, 9};
		System.out.println(findMaximumProduct(intArray));

	}

	private static int findMaximumProduct(int[] intArray) {

		int first = Integer.MIN_VALUE; 
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		
		if (intArray.length < 3) {
			return -1;
		}
		
		for (int i = 0; i < intArray.length; i++) {

			if (intArray[i] > first) {
				
				third = second;
				second = first;
				first = intArray[i];
				
			} else if (intArray[i] > second) {
				
				third = second;
				second = intArray[i];
				
			} else if (intArray[i] > third) {
				
				third = intArray[i];
				
			}

		}

		return first * second * third;

	}

}
