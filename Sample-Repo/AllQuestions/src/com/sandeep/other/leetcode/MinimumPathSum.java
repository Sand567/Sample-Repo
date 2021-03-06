package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]

Output: 7

Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */
public class MinimumPathSum {

	public static void main(String[] args) {
		
		int[][] arr = {
			{2},
			{3, 4},
			{6, 5, 7},
			{4, 1, 8, 3}
		};
		
		List<List<Integer>> triangle = new ArrayList<>(arr.length);
		
		for (int[] tri : arr) {
			List<Integer> subList = new ArrayList<>(tri.length);
			
	        for (int num : tri) {
	        	subList.add(num);
	        }
	        
	        triangle.add(subList);
			
		}
		
		triangle.forEach(System.out::println);
		System.out.println("===============");
		
		System.out.println("Minimum path sum: " + findMinimumPathSumFromTopToBottom(triangle));

	}

	private static int findMinimumPathSumFromTopToBottom(List<List<Integer>> triangle) {
		
		int[] total = new int[triangle.size()];
		int len = triangle.size() - 1;
		
		for (int i = 0; i < triangle.get(len).size(); i++) {
			total[i] = triangle.get(len).get(i);
		}
		
		System.out.println(Arrays.toString(total));
		System.out.println("traingle size: " + triangle.size());
		
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			
			System.out.println("triangle.get(i + 1).size() - 1: " + (triangle.get(i + 1).size() - 1));
			
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				
				System.out.println("i: " + i +", j: " + j);
				
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
			
		}
		
		System.out.println(Arrays.toString(total));
		
		return total[0];
		
	}

}
