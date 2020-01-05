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
		
		int[] numbers = {2, 7, 11, 15};
		int target = 9;

		System.out.println(Arrays.toString(numbers));

		System.out.println("Indices are");
		System.out.println(Arrays.toString(findTwoSumMethod1(numbers, target)));
		System.out.println();

	}

	private static int[] findTwoSumMethod1(int[] numbers, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			int newTarget = target - numbers[i];

			if (map.containsKey(newTarget)) {
				System.out.println("Elements that add up to the target " + target + " are " + newTarget + " and " + numbers[i]);
				return new int[] {map.get(newTarget), i};
			}

			map.put(numbers[i], i);
		}

		throw new IllegalArgumentException("No match found");
	}

}
