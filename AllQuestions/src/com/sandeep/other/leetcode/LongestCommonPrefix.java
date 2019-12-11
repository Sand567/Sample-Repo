package com.sandeep.other.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        // "dog","racecar","car"

        String[] strings = new String[] {"flower","flow","flight"};
        System.out.println("\nlongest common prefix: " + longestCommonPrefix(strings));
    }

    private static String longestCommonPrefix(String[] strings) {

        if (strings == null || strings.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;

        for (String str : strings) {
            if (minLength > str.length()) {
                minLength = str.length();
            }
        }

        if (minLength == 0) {
            return "";
        }

        for (int j = 0; j < minLength; j++) {
            char previous = '0';

            for (int i = 0; i < strings.length; i++) {

                System.out.print(strings[i].charAt(j) + " ");

                if (i == 0) {
                    previous = strings[i].charAt(j);
                    continue;
                }

                if (strings[i].charAt(j) != previous) {
                    return strings[i].substring(0, j);
                }

                System.out.println();
            }

        }

        return strings[0].substring(0, minLength);
    }
}
