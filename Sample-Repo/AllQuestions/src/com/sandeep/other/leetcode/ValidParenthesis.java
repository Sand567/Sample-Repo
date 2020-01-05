package com.sandeep.other.leetcode;

import java.util.Scanner;
import java.util.Stack;

/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

 */
public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(isMatched(s));
        }

        scanner.close();
    }

    private static boolean isMatched(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // initially push new bracket characters
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                System.out.println("c: " + c + ", top: " + top);

                // if top does not match the new character return false
                if (!((c == '}' && top == '{') || (c == ')' && top == '(') || (c == ']' && top == '['))) {
                    return false;
                }
            }

        }

        // if the list is empty that means that
        // there were balanced brackets
        return stack.isEmpty();
    }
}
