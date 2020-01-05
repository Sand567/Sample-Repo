package com.sandeep.other;

import java.util.Arrays;

public class RotateArray {
	
	private static int count = 0;

	public static void main(String[] args) {
		
		int k = 3;
		
		rotateWithIntermediateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, k);
		System.out.println("===================");
		bubbleRotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 4);
		System.out.println("===================");
		rotateByReversing(new int[] {1, 2, 3, 4, 5, 6, 7}, 5);

	}

	private static void rotateWithIntermediateArray(int[] input, int k) {
		
		if (input.length < k) {
			k = k % input.length;
		}
		
		int result[] = new int[input.length];
		
		for (int i = 0; i < k; i++) {
			int indexToBeginRotating = input.length - k + i;
			result[i] = input[indexToBeginRotating];
		}
		
		int j = 0;
		for (int i = k; i < input.length; i++) {
			result[i] = input[j];
			j++;
		}

		System.out.println(Arrays.toString(result));
		
	}
	
	private static void bubbleRotate(int[] input, int k) {
		
		if (input == null || k < 0) {
			throw new IllegalArgumentException("Illegal Arguments supplied");
		}
		
		for (int i = 0; i < k; i++) {
			for (int j = input.length - 1; j > 0; j--) {
				int temp = input[j];
				input[j] = input[j - 1];
				input[j - 1] = temp;
			}
		}
		
		System.out.println(Arrays.toString(input));
		
	}
	
	private static void rotateByReversing(int[] input, int k) {
		
		// making sure if in case the number of elements are less than k
		k = k % input.length;
		
		if (input == null || k < 0) {
			throw new IllegalArgumentException("Illegal Arguments supplied");
		}
		
		System.out.println("k: " + k);
		
		// dividing array into 2 parts
		int partitionLength = input.length - k;
		
		System.out.println("partitionLength: " + partitionLength);
		System.out.println("Array before partition: " + Arrays.toString(input));
		
		// reversing elements of left sub array
		reverse(input, 0, partitionLength - 1);
		
		// reversing elements of right sub array
		reverse(input, partitionLength, input.length - 1);
		
		// rotate elements by reversing the entire array
		reverse(input, 0, input.length - 1);
		
	}

	private static void reverse(int[] input, int left, int right) {
		
		count++;
		
		if (input == null || input.length == 1) {
			return;
		}
		
		while (left <  right) {
			int temp = input[left];
			input[left] = input[right];
			input[right] = temp;
			left++;
			right--;
		}
		
		if (count == 3) {
			System.out.println("Final result: " + Arrays.toString(input));
		} else if (count == 1) {
			System.out.println("Reversing left sub array: " + Arrays.toString(input));
		} else if (count == 2) {
			System.out.println("Reversing right sub array: " + Arrays.toString(input));
		}
		
		
	}

}
