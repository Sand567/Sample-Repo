package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
