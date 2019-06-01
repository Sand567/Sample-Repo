package com.sandeep.arrays1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfElementsInArray {
	
	private static Map<Pair, Integer> pairs = new HashMap<>();

	public static void main(String[] args) {
		
		int[] a = new int[] {5, 2, -1, 15, 22, -11, 2};
		
		System.out.println("a: " + Arrays.toString(a) + "\n");
		
		findPairsEqualToSumBruteForce(a, 4);
		
		System.out.println("Find pairs - Brute Force");
		for (Map.Entry<Pair, Integer> pair : pairs.entrySet()) {
			System.out.println(pair.getKey().getPair1() + " + " + pair.getKey().getPair2() + 
					" = " + pair.getValue());
		}
		
		System.out.println("");
		pairs.clear();
		
		System.out.println("Find pairs");
		findPairsEqualToSum(a, 4);
		
		for (Map.Entry<Pair, Integer> pair : pairs.entrySet()) {
			System.out.println(pair.getKey().getPair1() + " + " + pair.getKey().getPair2() + 
					" = " + pair.getValue());
		}
		
		// Output
		// ==========
		//	a: [5, 2, -1, 15, 22, -11, 2]
		//
		//	Find pairs - Brute Force
		//	5 + -1 = 4
		//	15 + -11 = 4
		//	2 + 2 = 4
		//
		//	Find pairs
		//	After sort: [-11, -1, 2, 2, 5, 15, 22]
		//	2 + 2 = 4
		//	-11 + 15 = 4
		//	-1 + 5 = 4
		
	}

	// O(nlogn)
	private static void findPairsEqualToSum(int[] input, int sum) {
		
		Arrays.sort(input);
		
		System.out.println("After sort: " + Arrays.toString(input));
		// -11, -1, 2, 2, 5, 15, 22
		
		int i = 0;
		int j = input.length - 1;
		
		while (i < j) {
			
			if ((input[i] + input[j]) == sum) {
				
				Pair pair = new Pair(input[i], input[j]);
				pairs.put(pair, sum);
				i++;
				j--;
				
			} else if ((input[i] + input[j]) < sum) {
				i++;
			} else if ((input[i] + input[j]) > sum) {
				j--;
			}
			
		}
		
	}

	// O(n^2)
	private static void findPairsEqualToSumBruteForce(int[] input, int sum) {
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				
				if ((input[i] + input[j]) == sum) {
					Pair pair = new Pair(input[i], input[j]);
					pairs.put(pair, sum);
				} 
				
			}
		}
		
	}

}
