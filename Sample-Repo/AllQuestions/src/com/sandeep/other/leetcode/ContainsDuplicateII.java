package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */
public class ContainsDuplicateII {
    public static void main(String[] args) {

        // {1, 2, 3, 1}
        // {1, 0, 1, 1},
        // {1, 2, 3, 1, 2, 3}

        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(nums) + " -> " + containsNearbyDuplicates(nums, k));

    }

    private static boolean containsNearbyDuplicates(int[] nums, int k) {

        // map to hold the element and its index as key & value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            // if map has the current key &&
            // the difference between the indices of i and current <= k
            // then it means that condition satisfies
            if (map.containsKey(current) && i - map.get(current) <= k) {
                return true;
            } else {
                // else add it to the map
                // (number, index)
                map.put(current, i);
            }
        }

        // if none of the cases satisfy
        // return false
        return false;
    }
}
