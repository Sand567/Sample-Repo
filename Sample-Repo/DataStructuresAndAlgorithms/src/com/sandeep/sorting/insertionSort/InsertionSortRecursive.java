package com.sandeep.insertionSort;

import com.sandeep.common.Helper;

public class InsertionSortRecursive {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();
		
		insertionSort(intArray, intArray.length);

	}
	
	private static void insertionSort(int[] input, int numItems) {
		
		// if we have 1 item that means the array is sorted
		if (numItems < 2) {
			return;
		}
		
		insertionSort(input, numItems - 1);
		
		int newElement = input[numItems - 1];
		int i;
		
		for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
			input[i] = input[i - 1];
		}
		
		input[i] = newElement;
		
		System.out.println("Result of call when numItems: " + numItems);
		for (i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}
		System.out.println("");
		System.out.println("-----------------------------");
	}

}
