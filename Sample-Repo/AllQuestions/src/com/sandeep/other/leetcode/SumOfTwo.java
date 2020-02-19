package com.sandeep.other.leetcode;

import java.util.HashSet;

public class SumOfTwo {
    public static void main(String[] args) {

        // a = [0 0 -5 30212]
        // b = [-10 40 -3 9]
        // value = -8

        int[] arr1 = {0, 0, -5, 30212};
        int[] arr2 = {-10, 40, -3, 9};
        int value = -8;

        System.out.println("Form a sum with the value " + value + " ? (Brute Force) " + sumOfTwoBruteForce(arr1, arr2, value));
        System.out.println("Form a sum with the value " + value + " ? " + sumOfTwo(arr1, arr2, value));
    }

    private static boolean sumOfTwo(int[] a, int[] b, int value) {
        HashSet<Integer> differences = new HashSet<>();

        for (int item : a) {
            int difference = value - item;
            differences.add(difference);
        }

        for (int item : b) {
            if (differences.contains(item)) {
                return true;
            }
        }

        return false;
    }

    private static boolean sumOfTwoBruteForce(int[] a, int[] b, int value) {
        for (int element : a) {
            int neededValue = value - element;
            for (int item : b) {
                if (item == neededValue) {
                    return true;
                }
            }
        }

        return false;
    }
}
