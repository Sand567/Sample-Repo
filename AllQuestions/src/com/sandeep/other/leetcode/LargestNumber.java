package com.sandeep.other.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = new int[] {3, 30, 34, 5, 9};
        System.out.println(largestNumber(numbers));
    }

    private static String largestNumber(int[] numbers) {

        System.out.println("Original: " + Arrays.toString(numbers));

        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        System.out.println("After String conversion: " + Arrays.toString(nums));

        Arrays.sort(nums, (left, right) -> {
            String leftRight = left.concat(right);
            String rightLeft = right.concat(left);
            System.out.println("leftRight: " + leftRight);
            System.out.println("rightLeft: " + rightLeft);
            return rightLeft.compareTo(leftRight);
        });

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        BigInteger result = new BigInteger(sb.toString());
        return result.toString();

    }
}
