package com.sandeep.other;

import java.util.*;

public class FindLongestContinuousSubString {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("");
        stringList.add("10000111");
        stringList.add("aabbbbbCd");

        for (String str : stringList) {

            int[] result = findLongestSubString(str);

            if (result.length > 0) {
                System.out.println("str: " + (str.isEmpty() ? "Empty" : str) + ", start index: " + (result[0] == -1 ? -1 : (char) result[0]) + ", length: " + result[1]);
            }
            System.out.println();
        }

    }

    private static int[] findLongestSubString(String str) {

        if (!str.isEmpty()) {
            Map<Character, Integer> indexLengthMap = new HashMap<>();

            for (int i = 0; i < str.length() - 1; i++) {
                boolean equal = str.charAt(i) == str.charAt(i + 1);

                if (equal && !(indexLengthMap.containsKey(str.charAt(i)))) {
                    indexLengthMap.put(str.charAt(i), 1);
                } else if (equal) {
                    indexLengthMap.put(str.charAt(i), indexLengthMap.get(str.charAt(i)) + 1);
                } else {
                    indexLengthMap.put(str.charAt(i + 1), 0);
                }
            }

            System.out.println(indexLengthMap);

            Map<Character, Integer> reverseSortedByValue = new LinkedHashMap<>();

            indexLengthMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(value -> reverseSortedByValue.put(value.getKey(), value.getValue() + 1));

            System.out.println(reverseSortedByValue);

            Map.Entry<Character, Integer> entry = reverseSortedByValue.entrySet().iterator().next();

            return new int[] {entry.getKey(), entry.getValue()};
        } else {
            return new int[] {-1, 0};
        }

    }
}
