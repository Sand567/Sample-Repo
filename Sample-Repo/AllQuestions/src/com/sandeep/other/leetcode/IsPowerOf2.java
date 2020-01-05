package com.sandeep.other.leetcode;

/*

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 2^0 = 1

Example 2:
s
Input: 16
Output: true
Explanation: 2^4 = 16

Example 3:

Input: 218
Output: false

 */
public class IsPowerOf2 {
    public static void main(String[] args) {
        int[] powers = new int[] {1, 8, 13, 16, 25, 218};
        for (int power : powers) {
            System.out.println("Is " + power + " a power of 2 ? " + isPowerOfTwo(power));
        }

    }

    private static boolean isPowerOfTwo(int n) {
        int i = 1;

        // we loop until i < n
        // and multiply it by 2
        while (i < n) {
            i = i * 2;
        }

        // check if i is equal to n and return result
        return i == n;
    }
}
