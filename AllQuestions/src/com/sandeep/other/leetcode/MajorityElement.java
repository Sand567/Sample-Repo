package com.sandeep.other.leetcode;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		
		int[] nums = {10, 10, 20, 40, 10, 10, 20, 10, 10, 30};
		System.out.println(majorityElem(nums));
		System.out.println(majorityElem2(nums));

	}
	
	private static int majorityElem(int[] nums) {
		
		System.out.println("nums: " + Arrays.toString(nums));
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		Arrays.sort(nums);
		
		System.out.println("nums: " + Arrays.toString(nums));
		
		int prev = nums[0];
		int count = 1;
		
		for (int i = 1; i < nums.length; i++) {
			
			System.out.println("nums["+i+"]=" + nums[i] + ", prev=" + prev + ", count=" + count);
			
			if (nums[i] == prev) {
				count++;
				if (count > nums.length / 2) {
					return nums[i];
				}
			} else {
				count = 1;
				prev = nums[i];
			}
		}
		
		return 0;
		
	}
	
	private static int majorityElem2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
