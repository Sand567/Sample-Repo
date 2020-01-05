package com.sandeep.other.leetcode;

/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */
public class ReverseInteger {
    public static void main(String[] args) {
        int[] nums = {123, -123, 120};
        for (int num : nums) {
            System.out.println("Reverse of " + num + " is " + reverse(num));
            System.out.println();
        }
    }

    private static int reverse(int num) {
        boolean negative = false;

        // if num is -ve then we convert it to
        // +ve by multiplying it by -1
        if (num < 0) {
            negative = true;
            num = num * -1;
        }

        long reversed = 0;

        // if it is a +ve number
        // we multiply reversed by 10: this is to handle the digit position
        // add num % 10: this is to retrieve the last number
        while (num > 0) {
            System.out.println("num: " + num + ", reversed: " + reversed);
            reversed = (reversed * 10) + (num % 10);
            num /= 10;
        }

        System.out.println("After reverse: " + reversed);

        // this is just to check if it exceeds the normal
        // Integer ranges
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }

        return negative ? (int)(reversed * -1) : (int)(reversed);
    }
}
