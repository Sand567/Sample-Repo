package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] numbers = {2, 11, 7, 15};
		int target = 18;
		
		findTwoSumMethod1(numbers, target);
		System.out.println();
		findTwoSumMethod2(numbers, target);

	}

	private static void findTwoSumMethod2(int[] numbers, int target) {
		
		int[] result = new int[2];
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
				}
			}
		}
		
		System.out.println("Method 2");
		System.out.println(Arrays.toString(result));
		
	}

	private static void findTwoSumMethod1(int[] numbers, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		System.out.println(Arrays.toString(numbers));
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				System.out.println("Inside if, i: " + i);
				int index = map.get(numbers[i]);
				result[0] = index + 1;
				result[1] = i + 1;
				break;
			} else {
				System.out.println("Inside else, i: " + i);
				int value = target - numbers[i];
				System.out.println("value: " + value);
				map.put(value, i);
			}
		}
		
		System.out.println();
		System.out.println("Method 1");
		System.out.println(Arrays.toString(result));
		
	}

}
