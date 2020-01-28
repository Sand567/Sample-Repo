package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
Each element in the result must be unique.
The result can be in any order.

 */
public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                intersection.add(j);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for (int k : intersection) {
            result[index++] = k;
        }

        return result;
    }
}
