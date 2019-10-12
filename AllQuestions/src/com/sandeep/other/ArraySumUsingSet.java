package com.sandeep.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class will print pairs of integers which
 * equal a certain sum
 */
public class ArraySumUsingSet {

	public static void main(String[] args) {
		prettyPrint(getRandomArray(10), 11);
	}

	/**
	 * This will just print it in the right format 
	 * int array, sum and the pairs
	 * @param randomArray
	 * @param i
	 */
	private static void prettyPrint(int[] randomArray, int i) {
		System.out.println("Random Integer array: " + Arrays.toString(randomArray));
		System.out.println("Sum: " + i);
		System.out.println("Pair of numbers whose sum equal " + i + " is: ");
		printPairsUsingSet(randomArray, i);
		printPairsUsingTwoPointers(randomArray, i);
	}

	/**
	 * This method will use pointers pointing to left and right
	 * and find the pairs by incrementing left and decrementing right
	 * @param randomArray
	 * @param i
	 */
	private static void printPairsUsingTwoPointers(int[] randomArray, int i) {
		if(randomArray.length < 2) {
			return;
		}
		
		Arrays.sort(randomArray);
		
		int left = 0;
		int right = randomArray.length - 1;
		
		while(left < right) {
			int sum = randomArray[left] + randomArray[right];
			if(sum == i) {
				System.out.printf("(%d, %d) by pointers %n", randomArray[left], randomArray[right]);
				left += 1;
				right -= 1;
			} else if(sum < i) {
				left += 1;
			} else if(sum > i) {
				right -= 1;
			}
		}
		
	}

	/**
	 * This method uses a set to find the pairs
	 * @param randomArray
	 * @param sum
	 */
	private static void printPairsUsingSet(int[] randomArray, int sum) {
		if(randomArray.length < 2) {
			return;
		}
		
		Set<Integer> set = new HashSet<>(randomArray.length);
		
		for(int value : randomArray) {
			int target = sum - value;
			
			if(!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) by sets %n", value, target);
			}
		}
		
	}

	/**
	 * This will generate an array with random values
	 * @param length
	 * @return
	 */
	private static int[] getRandomArray(int length) {
		int[] randoms = new int[length];
		for(int i = 0; i < length; i++) {
			randoms[i] = (int) (Math.random()*15);
		}
		return randoms;
	}

}
