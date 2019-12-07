package com.sandeep.bubbleSort;

import com.sandeep.common.Helper;

import java.util.Arrays;

/**
 * Bubble Sort
 * Time Complexity: Quadratic => O(n^2)
 * Stable Algorithm
 * In place algorithm
 */
public class BubbleSortDemo {

	public static void main(String[] args) {
		
		int[] intArray = {20, 35, -15, 7, 55, 1, -22};
		
		// last element is first to get sorted
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					Helper.swap(intArray, i, i + 1);
				}
			}
			
			System.out.println("intArray: " + Arrays.toString(intArray));
		}
		
		System.out.println("\nBubble Sort");
		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	/*	
	 	Sample Output:
		intArray: [20, -15, 7, 35, 1, -22, 55]
		intArray: [-15, 7, 20, 1, -22, 35, 55]
		intArray: [-15, 7, 1, -22, 20, 35, 55]
		intArray: [-15, 1, -22, 7, 20, 35, 55]
		intArray: [-15, -22, 1, 7, 20, 35, 55]
		intArray: [-22, -15, 1, 7, 20, 35, 55]
		
		Bubble Sort
		Final intArray: [-22, -15, 1, 7, 20, 35, 55]
	*/

}
