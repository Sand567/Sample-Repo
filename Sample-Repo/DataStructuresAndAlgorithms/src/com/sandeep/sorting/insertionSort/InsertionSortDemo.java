package com.sandeep.insertionSort;

import com.sandeep.common.Helper;

import java.util.Arrays;

/**
 * Insertion Sort
 * Time Complexity: Quadratic => O(n^2)
 * Stable Algorithm
 * In place algorithm
 */
public class InsertionSortDemo {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();

		// 20, 35, -15, 7, 55, 1, -22
		
		// This will maintain the sorted partition from left to right
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			
			// make 2nd element the newElement initially i.e index = 1
			int newElement = intArray[firstUnsortedIndex];
			
			// This is to save the position of i
			int i;
			
			// start looping from index 1 till the end of the array
			// by checking the elements in the sorted partition
			// If elements in the sorted partition are > than newElement then switch 
			// places until newElement is in its proper position to be inserted
			// into the sorted partition
			for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			
			// Once the above condition fails we will have the correct position of i
			// then drop out of the loop and insert the newElement at that position
			intArray[i] = newElement;
			System.out.println("intArray: " + Arrays.toString(intArray));
			
		}
		
		System.out.println("\nInsertion Sort");
		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	/*
	 	Sample Output: 
	 	intArray: [20, 35, -15, 7, 55, 1, -22]
		intArray: [-15, 20, 35, 7, 55, 1, -22]
		intArray: [-15, 7, 20, 35, 55, 1, -22]
		intArray: [-15, 7, 20, 35, 55, 1, -22]
		intArray: [-15, 1, 7, 20, 35, 55, -22]
		intArray: [-22, -15, 1, 7, 20, 35, 55]
		
		Insertion Sort
		Final intArray: [-22, -15, 1, 7, 20, 35, 55]
	 */

}
