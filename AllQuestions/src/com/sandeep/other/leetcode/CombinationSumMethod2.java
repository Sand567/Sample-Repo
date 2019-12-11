package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */

public class CombinationSumMethod2 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> output = combinationSum(candidates, target);

        for (List<Integer> out : output) {
            for (int in : out) {
                System.out.print(in + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(current);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }

            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
