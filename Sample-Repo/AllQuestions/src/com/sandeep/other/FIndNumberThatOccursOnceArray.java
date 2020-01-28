package com.sandeep.other;

import java.util.HashMap;
import java.util.Map;

public class FIndNumberThatOccursOnceArray {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 3, 3};
        System.out.println("The number that occurs once: " + findNumberThatOccursOnce(numbers));
        System.out.println("The number that occurs once: " + findNumberThatOccursOnceMethod2(numbers));
    }

    private static int findNumberThatOccursOnce(int[] numbers) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }

        return -1;
    }

    private static int findNumberThatOccursOnceMethod2(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            System.out.println("result: " + result);
            result = result ^ numbers[i];
        }

        return result;
    }

}
