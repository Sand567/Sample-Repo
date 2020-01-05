package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

Given a time represented in the format "HH:MM" form the next closest time by reusing the
current digits. There is no limit on how many times a digit can be reused

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
"1:34", "12:9" are invalid

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4 is 19:39, which occurs 5 minutes
later. It is not "19:33", because this occurs 23 hours and 59 minutes later.

 */
public class NextClosestTime {
    public static void main(String[] args) {
        String[] times = {"19:34", "23:59"};
        for (String time : times) {
            System.out.println("Next closest time to " + time + " is " + nextClosestTime(time));
            System.out.println();
        }
    }

    private static String nextClosestTime(String time) {

        System.out.println("time: " + time);

        // this is to get the first 2 digits of the string
        // and multiply it by 60 to convert hour to minutes
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;

        // this will get the rest of digits after the ":"
        minutes += Integer.parseInt(time.substring(3));

        System.out.println("Total minutes: " + minutes);

        Set<Integer> digits = new HashSet<>();

        // this is to get all the numbers as Integers
        // in the string and also to check for validity
        for (char c : time.toCharArray()) {
            digits.add(c - '0');
        }

        while (true) {
            // now we have to check if the next minute is valid or not
            // hence we add 1 to minutes and check for validity
            // (24 * 60) is to make sure it considers next minute after 23 hr and 59 min
            minutes = (minutes + 1) % (24 * 60);

            int hourFirst = minutes / 60 / 10;
            int hourSecond = minutes / 60 % 10;
            int minuteFirst = minutes % 60 / 10;
            int minuteSecond = minutes % 60 % 10;

            System.out.println("minutes: " + minutes + ", hourFirst: " + hourFirst + ", hourSecond: " + hourSecond + ", " +
                    "minuteFirst: " + minuteFirst + ", minuteSecond: " + minuteSecond);

            int[] nextTime = {
                    hourFirst, // first digit in the hour part
                    hourSecond, // second digit in the hour part
                    minuteFirst, // first digit in the minute part
                    minuteSecond  // second digit in the minute part
            };

            System.out.println(Arrays.toString(nextTime));

            boolean isValid = true;
            for (int digit : nextTime) {
                if (!digits.contains(digit)) {
                    isValid = false;
                    break;
                }
            }

            // if valid return result in the
            // correct format "HH:MM"
            if (isValid) {
                return String.format("%02d:%02d", (minutes / 60), (minutes % 60));
            }
        }
    }
}
