package com.sandeep.bubbleSort;

import java.util.Arrays;

/**
 * Bubble Sort
 * Time Complexity: Quadratic => O(n^2)
 */
public class Main {

	public static void main(String[] args) {
		
		int[] intArray = {20, 35, -15, 7, 55, 1, -22};
		
		// last is the first to get sorted
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
			
			System.out.println("intArray: " + Arrays.toString(intArray));
		}
		
		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	// Swaps i and j
	private static void swap(int[] array, int i, int j) {
		
		if (i == j) {
			return;
		}
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
	
	/*	Sample Output:
		intArray: [20, -15, 7, 35, 1, -22, 55]
		intArray: [-15, 7, 20, 1, -22, 35, 55]
		intArray: [-15, 7, 1, -22, 20, 35, 55]
		intArray: [-15, 1, -22, 7, 20, 35, 55]
		intArray: [-15, -22, 1, 7, 20, 35, 55]
		intArray: [-22, -15, 1, 7, 20, 35, 55]
		Final intArray: [-22, -15, 1, 7, 20, 35, 55]
	*/

}
