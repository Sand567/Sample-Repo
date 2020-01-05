package com.sandeep.other.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		productExceptSelf(nums);
	}

	private static void productExceptSelf(int[] nums) {
		
		int[] output = new int[nums.length];
		
		for (int i = 0, temp = 1, l = nums.length; i < l; i++) {
			System.out.println("temp: " + temp + ", nums["+i+"]: " + nums[i]);
			output[i] = temp;
			temp *= nums[i];
		}
		
		System.out.println(Arrays.toString(output));
		
		for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
			System.out.println("output["+i+"]: " + output[i] + ", temp: " + temp);
			output[i] = output[i] * temp;
			temp *= nums[i];
		}

		System.out.println(Arrays.toString(output));
		
	}

}
