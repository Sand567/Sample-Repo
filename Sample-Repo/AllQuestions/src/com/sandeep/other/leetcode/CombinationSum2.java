package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

Time complexity: O(2^n)
Space complexity: O(n)

 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // sorting candidates because while checking for
        // duplicates we just check if current number is equal or not equal to
        // the next number
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {

        // this means that we have found a combination
        // that sums to our target
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // if the target goes below 0 or negative
        // we just return
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // i == index: this is when i is at the first index OR
            // candidates[i] != candidates[i - 1]: this is when check for duplicates and
            // if both these conditions satisfy we add candidates[i] to current
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);

                // now we make a recursive call which will pass in the next index
                // and target - candidates[i] because we will be looking for the number
                // we get by subtracting it by the target
                findCombinations(candidates, i + 1, target - candidates[i], current, result);

                // now we remove the number which will simulate
                // not taking that number
                current.remove(current.size() - 1);
            }

        }
    }
}
