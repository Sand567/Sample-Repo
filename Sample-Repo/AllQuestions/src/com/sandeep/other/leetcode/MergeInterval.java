package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/
public class MergeInterval {
    // Hello
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {

        // if lenght <= 1 return interval
        if (intervals.length <= 1) {
            return intervals;
        }

        // Here we cannot assume the array would be sorted
        // hence we have to sort the array
        // Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        // Below same as above
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        // As we do not know the size the resulting array
        // we create a list of int array
        List<int[]> output = new ArrayList<>();
        int[] currentInterval = intervals[0];
        output.add(currentInterval);

        // we loop through and extract the current and the next
        // interval's beginning and ending values
        for (int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            // if there is an overlap
            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                output.add(currentInterval);
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
