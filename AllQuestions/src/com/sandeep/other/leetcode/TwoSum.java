package AllQuestions.src.com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class TwoSum {

	public static void main(String[] args) {
		
		int[] numbers = {2, 7, 11, 15, -6, -2};
		int target = 9;
		
		findTwoSumMethod1(numbers, target);
		System.out.println();
//		findTwoSumMethod2(numbers, target);

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

		int[] result = new int[2];
		System.out.println(Arrays.toString(numbers));
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int newTarget = target - numbers[i];

			if (map.containsKey(newTarget)) {
				System.out.println("The output found at " + newTarget + " and " + numbers[i]);
				System.out.println(map.get(newTarget) + " " + i);
			}

			map.put(numbers[i], i);
		}

		
	}

}
