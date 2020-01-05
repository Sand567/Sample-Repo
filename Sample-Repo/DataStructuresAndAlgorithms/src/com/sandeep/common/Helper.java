package com.sandeep.common;

public class Helper {
	
	// return an integer array
	public static int[] getArray() {
		return new int[] {20, 35, -15, 7, 55, 1, -22};
	}
	
	// Swaps i and j
	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
