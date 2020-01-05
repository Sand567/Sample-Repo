package com.sandeep.shellSort;

import java.util.Arrays;

import com.sandeep.common.Helper;

/**
 * Shell Sort
 * Time Complexity: Quadratic => O(n^2) or may be better
 * UnStable Algorithm
 * In place algorithm
 */
public class Main {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();
		
		// We set the gap to array's length / 2 and 
		// divide it / 2 until the final value of gap be 1
		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
			
			// We then set i to gap, newElement to intArray[i] and j to i
			for (int i = gap; i < intArray.length; i++) {
				
				int newElement = intArray[i];
				int j = i;
				
				// Loop as long as j >= gap and the other element we are 
				// comparing to should be > newElement
				// When that happens switch both the elements and
				// decrement the value of j by gap
				while (j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j -gap];
					j -= gap;
				}
				
				// Once we drop of the loop we will have the correct position
				// in the iteration to insert the element
				intArray[j] = newElement;
				
				System.out.println("intArray: " + Arrays.toString(intArray));
				
			}
			
		}
		
		System.out.println("\nShell Sort");
		System.out.println("Final intArray: " + Arrays.toString(intArray));
		
	}
	
	/*	
	 * 	Sample Output:
	 	intArray: [-22, 35, -15, 7, 55, 1, 20]
		intArray: [-22, -15, 35, 7, 55, 1, 20]
		intArray: [-22, -15, 7, 35, 55, 1, 20]
		intArray: [-22, -15, 7, 35, 55, 1, 20]
		intArray: [-22, -15, 1, 7, 35, 55, 20]
		intArray: [-22, -15, 1, 7, 20, 35, 55]
		
		Shell Sort
		Final intArray: [-22, -15, 1, 7, 20, 35, 55]
	 */

}
