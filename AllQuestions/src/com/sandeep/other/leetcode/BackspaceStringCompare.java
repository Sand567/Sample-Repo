package AllQuestions.src.com.sandeep.other.leetcode;

import java.util.Stack;

/*

Given two strings S and T, return if they are equal when both are typed into empty text editors.
# means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

Follow up:
Can you solve it in O(N) time and O(1) space?

 */
public class BackspaceStringCompare {

    private static Stack<Character> sStack = new Stack<>();
    private static Stack<Character> tStack = new Stack<>();

    public static void main(String[] args) {
        String[][] ST = {
                {"ab#c", "ad#c"},
                {"ab##", "c#d#"},
                {"a##c", "#a#c"},
                {"a#c", "b"}
        };

        for (String[] str : ST) {
            System.out.println("Equal (backspaceCompare) ? " + backspaceCompare(str[0], str[1]));
        }

        System.out.println();

        for (String[] str : ST) {
            System.out.println("Equal (backSpaceCompareImproved) ? " + backSpaceCompareImproved(str[0], str[1]));
        }
    }

    // Naive approach
    private static boolean backspaceCompare(String S, String T) {

        updateStack(S, sStack);
        updateStack(T, tStack);

        while (!sStack.isEmpty()) {
            char current = sStack.pop();
            if (tStack.isEmpty() || tStack.pop() != current) {
                return false;
            }
        }

        return sStack.isEmpty() && tStack.isEmpty();
    }

    private static void updateStack(String str, Stack<Character> stack) {
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    // O(1) space and O(N) time
    private static boolean backSpaceCompareImproved(String S, String T) {
        return updateString(S).equals(updateString(T));
    }

    private static String updateString(String str) {
        int aPtr = 0;
        int bPtr = 0;

        char[] chars = str.toCharArray();

        while (bPtr < chars.length) {
            if (chars[bPtr] == '#') {
                if (aPtr > 0) {
                    aPtr--;
                }
            } else {

                // if the character is not equal to '#'
                chars[aPtr++] = chars[bPtr];
            }

            bPtr++;
        }

        // as aPtr would be one greater than the
        // current index
        return String.valueOf(chars).substring(0, aPtr);
    }


}
