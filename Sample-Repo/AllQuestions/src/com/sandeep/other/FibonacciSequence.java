package com.sandeep.other;

import java.util.Arrays;

public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibonacci(n));
        System.out.println(Arrays.toString(calcFibonacci(n)));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int[] calcFibonacci(int number) {

        int[] result = new int[number];
        result[0] = 0;
        result[1] = 1;

        for(int i = 2; i < number; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        return result;

    }
}
