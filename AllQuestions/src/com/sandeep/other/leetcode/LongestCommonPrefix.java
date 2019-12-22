package com.sandeep.other.leetcode;

/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note: All given inputs are in lowercase letters a-z.

 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        // "dog","racecar","car"

        String[] strings = new String[] {"flower","flow","flight"};
        System.out.println("longest common prefix: " + longestCommonPrefix(strings));
    }

    private static String longestCommonPrefix(String[] strings) {

        StringBuilder longestCommonPrefix = new StringBuilder();

        // if strings is either null or length is 0
        // we just return the empty longestCommonPrefix
        if (strings == null || strings.length == 0) {
            return longestCommonPrefix.toString();
        }

        // this is to maintain the index
        // when we loop through strings[i].toCharArray()
        int index = 0;

        // we just consider the first element in strings array
        // we then compare every char in the first string with
        // other characters of other strings
        for (char c : strings[0].toCharArray()) {

            // we do not again want to compare the 0th element
            // hence we begin with the first element
            for (int i = 1; i < strings.length; i++) {

                // if the index is >= strings length or
                // if c is not equal to character at the next string's character at this particular index
                // we then just return longestCommonPrefix
                // because this means that whenever either of the below conditions
                // occur whatever the value at longestCommonPrefix would be the longest common prefix
                if (index >= strings[i].length() || c != strings[i].charAt(index)) {
                    return longestCommonPrefix.toString();
                }
            }

            // if it comes here it means that characters of subsequent strings
            // continue to be equal hence we keep
            // appending it to the longestCommonPrefix
            longestCommonPrefix.append(c);

            // we do this because we need to move over
            // to next character and compare those
            index++;
        }

        return longestCommonPrefix.toString();

    }
}
