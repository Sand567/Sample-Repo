package com.sandeep.sorting.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Quick Sort
 * Time Complexity: Logarithmic => O(nlogn)
 * Worst case: Quadratic => O(n2)
 * In-place algorithm
 */
public class QuickSortDemo {

	public static void main(String[] args) {
		
//		int[] intArray = Helper.getArray();
		
//		quickSort(intArray, 0, intArray.length);

		int[] intArray = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
		System.out.println("Before sort: " + Arrays.toString(intArray));
		System.out.println();

		quickSort2(intArray);

		System.out.println("After sort" + Arrays.toString(intArray));

	}

	public static void quickSort2(int[] intArray) {
		quickSort2(intArray, 0 , intArray.length - 1);
	}

	private static void quickSort2(int[] intArray, int low, int high) {

		// if there are elements left to sort
		if (low < high + 1) {
			int pivot = partition2(intArray, low, high);
			quickSort2(intArray, low, pivot - 1);
			quickSort2(intArray, pivot + 1, high);
		}

	}

	private static void swap(int[] intArray, int index1, int index2) {
		int temp = intArray[index1];
		intArray[index1] = intArray[index2];
		intArray[index2] = temp;
	}

	// returns random pivot index between low and high inclusive
	private static int getPivot(int low, int high) {
		Random random = new Random();
		return random.nextInt((high - low) + 1) + low;
	}

	private static int partition2(int[] intArray, int low, int high) {
		int pivot = getPivot(low, high);
		System.out.println("pivot: " + pivot);

		// after the swap, low will now have the pivot's element
		swap(intArray, low, pivot);

		// border will be 1 greater than pivot
		int border = low + 1;

		System.out.println("pivot: " + pivot + ", low: " + low + ", border: " + border);
		System.out.println("intArray before: " + Arrays.toString(intArray));

		for (int i = border; i <= high; i++) {
			if (intArray[i] < intArray[low]) {
				swap(intArray, i, border++);
			}
		}

		System.out.println("intArray after: " + Arrays.toString(intArray));

		swap(intArray, low, border - 1);

		System.out.println("intArray after final swap: " + Arrays.toString(intArray));
		System.out.println();

		return border - 1;
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
