package com.sandeep.quickSort;

import java.util.Arrays;

import com.sandeep.common.Helper;

/**
 * Quick Sort
 * Time Complexity: Logarithmic => O(nlogn)
 * Worst case: Quadratic => O(n2)
 * In-place algorithm
 */
public class Main {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();
		
		quickSort(intArray, 0, intArray.length);
		
		System.out.println(Arrays.toString(intArray));

	}
	
	private static void quickSort(int[] input, int start, int end) {
		
		// This happens when it is one element array
		if (end - start < 2) {
			return;
		}
		
		// partition will return the correct index of the pivot 
		// in the final array
		int pivotIndex = partition(input, start, end);
		
		// This will return the sorted left sub array
		quickSort(input, start, pivotIndex);
		
		// this will return the sorted right sub array
		quickSort(input, pivotIndex + 1, end);
	}

	// partition sub arrays
	private static int partition(int[] input, int start, int end) {
		
		// we consider 1st element as pivot
		int pivot = input[start];
		
		int i = start;
		int j = end;
		
		// as long as i has not crossed j
		while (i < j) {
			
			// Empty loop body
			// This will keep decrementing j until input[j] is < pivot
			while (i < j && input[--j] >= pivot);
			
			// once we find an element less than the pivot but 
			// not because i > j then we assign 
			// that element to the element at position i
			if (i < j) {
				input[i] = input[j];
			}
			
			// once we find an element greater than the pivot but 
			// not because i > j then we assign 
			// that element to the element at position j
			while (i < j && input[++i] <= pivot);
			if (i < j) {
				input[j] = input[i];
			}
			
		}
		
		// Once we drop out of the loop
		// j is correct position for the pivot element to be inserted
		input[j] = pivot;
		
		// finally return j
		return j;
		
	}

}
