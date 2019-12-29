package AllQuestions.src.com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        // we have to initially sort the array
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList<>();

        // nums.length - 2 because we are making sure that
        // the comparisons go out of range
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                // we begin the search from the ith's next element
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {

                        // if they the 2 elements add up to the sum, we then add
                        // add it to the output list
                        output.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // this is to check for duplicates
                        while (low < high && (nums[low] == nums[low + 1])) {
                            low++;
                        }

                        // this is to check for duplicates
                        while (low < high && (nums[high] == nums[high - 1])) {
                            high--;
                        }

                        low++;
                        high--;

                    } else if (nums[low] + nums[high] > sum) {

                        // if result of addition is > sum
                        // we just decrement high because as the array is sorted
                        // by decrementing the index by 1 we get an element
                        // that is lesser than the next element
                        // hence until we get the correct element
                        // we keep decrementing by 1
                        high--;
                    } else {

                        // the above above logic holds true for
                        // low pointer as well
                        low++;
                    }
                }
            }
        }

        return output;
    }
}
