package com.sandeep.mergeSort;

import java.util.Arrays;

import com.sandeep.common.Helper;

/**
 * Merge Sort
 * Time Complexity: Logarithmic => O(nlogn)
 * Not an in-place algorithm
 */
public class MergeSortDescending {

	public static void main(String[] args) {
		
		int[] intArray = Helper.getArray();
		
		System.out.println("Initial intArray: " + Arrays.toString(intArray));
		System.out.println("----------------");
		
		mergeSort(intArray, 0, intArray.length);
		
		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	private static void mergeSort(int[] input, int start, int end) {
		
		if (end - start < 2) {
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

	private static void merge(int[] input, int start, int mid, int end) {
		
		// if this situation occurs
		// as we know all the elements in the left and right array will be sorted
		// if the below condition satisfies then mid - 1 which is the index of the last
		// position in the left sub array and mid which is the index of the first position
		// of the right sub array. If this satisfies then the left and right sub arrays are in their
		// correct order
		if (input[mid - 1] >= input[mid]) {
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
			temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
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
