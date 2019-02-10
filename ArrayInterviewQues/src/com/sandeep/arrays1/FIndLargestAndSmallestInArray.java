package com.sandeep.arrays1;

import java.util.Arrays;

/**
 * This class will find the maximum and minimum number 
 * in the given array 
 */
public class FIndLargestAndSmallestInArray {

	public static void main(String[] args) {
		
		largestSmallest(new int[] {20, Integer.MAX_VALUE, -30, 10, -15, 90});
		largestSmallest(new int[] {10, Integer.MIN_VALUE, -2});
		largestSmallest(new int[] {Integer.MAX_VALUE, 40, Integer.MAX_VALUE});
		largestSmallest(new int[] {1, -1, 0});

	}
	
	/**
	 * This method loops through the array by setting
	 * the Largest and Smallest by comparing elements
	 * @param numbers
	 */
	private static void largestSmallest(int [] numbers) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		
		for(int number : numbers) {
			if(number > largest) {
				largest = number;
			} else if(number < smallest) {
				smallest = number;
			}
		}
		
		System.out.println("Given Array: " + Arrays.toString(numbers));
		System.out.println("Largest Number in array: " + largest);
		System.out.println("Smallest Number in array: " + smallest + "\n");
	}

}
