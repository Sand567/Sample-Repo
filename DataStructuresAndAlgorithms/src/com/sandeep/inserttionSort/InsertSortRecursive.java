package com.sandeep.inserttionSort;

import com.sandeep.common.Helper;

public class InsertSortRecursive {

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
	}

}
