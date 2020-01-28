package com.sandeep.other.leetcode;

import java.util.Arrays;

/*

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		productExceptSelf(nums);
	}

	private static void productExceptSelf(int[] nums) {
		
		int[] output = new int[nums.length];
		int temp = 1;
		int temp1 = 1;
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println("temp: " + temp + ", nums["+i+"]: " + nums[i]);
			output[i] = temp;
			temp *= nums[i];
		}
		
		System.out.println(Arrays.toString(output));
		System.out.println("temp: " + temp);
		
		for (int i = nums.length - 1; i >= 0; i--) {
			System.out.println("output["+i+"]: " + output[i] + ", temp1: " + temp1);
			output[i] = output[i] * temp1;
			temp1 *= nums[i];
		}

		System.out.println(Arrays.toString(output));
		
	}



}
