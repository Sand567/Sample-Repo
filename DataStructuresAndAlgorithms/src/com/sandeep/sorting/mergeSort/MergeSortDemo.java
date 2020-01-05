package com.sandeep.sorting.mergeSort;

import com.sandeep.common.Helper;

import java.util.Arrays;

/**
 * Merge Sort
 * Time Complexity: Logarithmic => O(nlogn)
 * Not an in-place algorithm
 */
public class MergeSortDemo {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();
		
//		mergeSort(intArray, 0, intArray.length);

		mergeSort2(intArray, intArray.length);

		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	private static void mergeSort(int[] input, int start, int end) {
		
		if ((end - start) < 2) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		// make logical partitions to create left sub array
		mergeSort(input, start, mid);
		
		// make logical partitions to create right sub array
		mergeSort(input, mid, end);
		
		// This will merge both the partitions
		merge(input, start, mid, end);
		
	}

	private static void mergeSort2(int[] input, int length) {

		// {20, 35, -15, 7, 55, 1, -22}

		if (length < 2) {
			return;
		}

		int mid = length / 2;

		System.out.println("length: " + length + ", mid: " + mid + ", (length - mid): " + (length - mid));

		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = input[i];
		}

		for (int i = mid; i < length; i++) {
			right[i - mid] = input[i];
		}

		mergeSort2(left, mid);
		mergeSort2(right, length - mid);

		System.out.println("left: " + Arrays.toString(left) + ", right: " + Arrays.toString(right));

		merge2(input, left, right, mid, length - mid);
	}

	private static void merge2(int[] input, int[] left, int[] right, int l, int r) {
		int i = 0, j = 0, k = 0;

		// if there are elements in both the left and right array
		while (i < l && j < r) {
			if (left[i] <= right[j]) {
				input[k++] = left[i++];
			} else {
				input[k++] = right[j++];
			}
		}

		System.out.println("i: " + i + ", j: " + j + ", input before: " + Arrays.toString(input));

		// only if there are elements in the left array
		while (i < l) {
			input[k++] = left[i++];
		}

		// only if there are elements in the right array
		while (j < r) {
			input[k++] = right[j++];
		}

		System.out.println("input after: " + Arrays.toString(input));
	}

	private static void merge(int[] input, int start, int mid, int end) {
		
		// if this situation occurs
		// as we know all the elements in the left and right array will be sorted
		// if the below condition satisfies then mid - 1 which is the index of the last
		// position in the left sub array and mid which is the index of the first position
		// of the right sub array. If this satisfies then the left and right sub arrays are in their
		// correct order
		if (input[mid - 1] <= input[mid]) {
			return;
		}
		
		int i = start;
		int j = mid;
		
		// maintain the index of temp array
		int tempIndex = 0;
		
		// Setting the size of the temp array to optimal size to accommodate for both
		// left and right sub arrays to be transferred over
		int[] temp = new int[end - start];
		
		// This will check both the sub arrays that have to transferred over to the temp array
		while (i < mid && j < end) {
			temp[tempIndex++] = (input[i] <= input[j]) ? input[i++] : input[j++];
		}

		System.out.println("temp: " + Arrays.toString(temp));

		System.out.println("start: " + start + " | end: " + end +
				" | mid: " + mid + " | i: " + i + " | j: " + j + " | tempIndex: " + tempIndex);
		System.out.println("----------------");
		
		// This will work only if the there are elements left out
		// in the left sub array but the position of the remaining element 
		// is incorrect
		// {32, 35}, {33, 34}
		// temp - {32, 33, 34} - In this case we know 35 would be the last element
		// But we also know that 35 is already in the input array but only the position
		// has to change and hence we follow below steps
		// If the left over elements are in the right array that means they are greater than 
		// the elements to the left of it and hence we do not need to copy it back to intArray
		System.arraycopy(input, i, input, start + tempIndex, mid - i);
		System.arraycopy(temp, 0, input, start, tempIndex);
		
	}

}
