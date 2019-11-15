package com.sandeep.other;

public class GCDOfNPositiveNumbers {

	public static void main(String[] args) {
		
		int[] arr = {25, 125, 625};
		
		GCDIterative(arr, arr.length);
		GCDRecursive(arr, arr.length);

	}

	private static void GCDIterative(int[] arr, int length) {
		
		int result = arr[0];
		int i = 1;
		
		while (i < length) {
			if (arr[i] % result == 0) {
				i++;
			} else {
				result = arr[i] % result;
				i++;
			}
		}
		
		System.out.println("result (iterative): " + result);
		
	}
	
	private static void GCDRecursive(int[] arr, int length) {
		
		int result = arr[0];
		for (int i = 1; i < length; i++) {
			result = gcd(arr[i], result); 
		}
		
		System.out.println("result (recursive): " + result);
		
	}

	private static int gcd(int elemA, int elemB) {
		if (elemA == 0) {
			return elemB;
		}
		
		return gcd(elemB % elemA, elemA);
	}

}
