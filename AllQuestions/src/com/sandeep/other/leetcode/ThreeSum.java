package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        findThreeSum(nums);
    }

    private static void findThreeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] > nums[i - 1]) {

                int negate = -nums[i];
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    if (nums[start] + nums[end] == negate) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        start++;
                        end--;

                        while (start < end && (nums[end] == nums[end + 1])) {
                            end--;
                        }

                        while (start < end && (nums[start] == nums[start - 1])) {
                            start++;
                        }
                    } else if (nums[start] + nums[end] < negate) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        result.forEach(res -> {
            res.forEach(r -> System.out.print(r + " "));
            System.out.println();
        });
    }
}
