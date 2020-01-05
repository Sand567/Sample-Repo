package com.sandeep.other.leetcode;

public class FindPeakElement {

	public static void main(String[] args) {
		
		int[] num = {3, 5, 11, 6, 13, 11, 2};
		
		System.out.println("max index: " + findPeakElement(num) + ", max element: " + num[findPeakElement(num)]);

	}
	
	private static int findPeakElement(int[] num) {
		
		int max = num[0];
		int index = 0;
		
		for (int i = 1; i <= num.length - 2; i++) {
			int prev = num[i - 1];
			int curr = num[i];
			int next = num[i + 1];
			
			if (curr > prev && curr > next && curr > max) {
				max = curr;
				index = i;
			}
		}
		
		if (num[num.length - 1] > max) {
			return num.length - 1;
		}
		
		return index;
		
	}

}
