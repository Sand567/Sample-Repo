package com.sandeep.other.leetcode;

import java.util.Arrays;

public class InsertionPosition {

	public static void main(String[] args) {
		
		int[] input = {1, 3, 5, 6};
		int target = 2;
		
		System.out.println("input: " + Arrays.toString(input));
		System.out.println("Insertion postion for the value " + target + " is " + searchInsert(input, target));
		System.out.println("Insertion postion for the value (Binary Search) " + target + " is " + searhInsertBinarySearch(input, target));

	}

	private static int searchInsert(int[] input, int target) {
		
		if (input == null) {
			return 0;
		}
		
		if (target <= input[0]) {
			return 0;
		}
		
		for (int i = 0; i < input.length - 1; i++) {
			if (target > input[i] && target <= input[i + 1]) {
				return i+1;
			}
		}
		
		return input.length;
		
	}
	
	private static int searhInsertBinarySearch(int[] input, int target) {
		if (input == null || target <= input[0]) {
			return 0;
		}
		
		return searchInsertBS(input, target, 0, input.length - 1);
	}

	private static int searchInsertBS(int[] input, int target, int start, int end) {
		int mid = (start + end) / 2;
		
		if (target == input[mid]) {
			return mid;
		} else if (target < input[mid]) {
			return start < mid ? searchInsertBS(input, target, start, mid-1) : start;
		} else {
			return end > mid ? searchInsertBS(input, target, mid+1, end) : (end+1);
		}
	}

}
