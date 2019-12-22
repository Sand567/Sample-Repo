package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/*

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 1},
                        {1, 2, 3, 4},
                        {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}};

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num) + " -> " + containsDuplicate(num));
        }

    }

    private static boolean containsDuplicate(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }

        return false;
    }
}
