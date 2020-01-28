package com.sandeep.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("The numbers of sub array that equal k is " + subArraySum(nums, k));
    }

    private static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> arraySum = new HashMap<>();

        // this will hold the number of subarrays
        // whose sum equals k
        int result = 0;
        int sum = 0;

        // this means that we have now seen a sum of 0 once
        arraySum.put(0 , 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // we check if we have seen the difference of
            // sum and k
            if (arraySum.containsKey(sum - k)) {
                result += arraySum.get(sum - k);
            }

            // If we are seeing this sum for the first time
            // it will return the value 0 and adds 1 to it
            // If this is not the first time the sum is appearing in the
            // HashMap we then get the actual sum and add 1 to increment the count
            // This map will hold the sum and the number of times it has appeared
            // during the traversal
            arraySum.put(sum, arraySum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
