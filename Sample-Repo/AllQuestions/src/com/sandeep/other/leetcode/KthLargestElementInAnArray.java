package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
//        System.out.println("The " + k + "th largest element is: " + findKthLargestMethod1(nums, k));
        System.out.println("The " + k + "th largest element is: " + findKthLargestMethod2(nums, k));
    }

    private static int findKthLargestMethod1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static int findKthLargestMethod2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int removed = 0;
        for (int num : nums) {
            System.out.println("removed element: " + removed);
            minHeap.add(num);
            System.out.println("Heap contents after addition");
            minHeap.forEach(System.out::println);
            if (minHeap.size() > k) {
                removed = minHeap.remove();
            }
        }

        System.out.println("Final Heap");
        minHeap.forEach(System.out::println);
        return minHeap.remove();
    }
}
