package com.sandeep.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {

	public static void main(String[] args) {
		
		int[] data = {1, 2 , 3, 4, 345, 312, 756, 0, -234321132, 234};
		int[] data2 = {2, 3, 10, 15, 3, 15, 30, 10, 15};
		
		// mean or average = sum of numbers / length
		// median = middle element in the array
		// mode = the number that occurs the most number of times
		
		findMedian(data);
		System.out.println();
		findMode(data2);

	}

	private static void findMode(int[] data) {
		
		int[] local = data;
		System.out.println(Arrays.toString(local));
		
		int maximumNum = -1;
		int maximumAppearances = -1;
		
		for (int i = 0; i < local.length; i++) {
			int count = 0;
			
			for (int j = 0; j < local.length; j++) {
				
				if (local[i] == local[j]) {
					count++;
				}
				
			}
			
			if (count > maximumAppearances) {
				maximumNum = local[i];
				maximumAppearances = count;
			}
			
		}
		
		System.out.println("mode: " + maximumNum);
		
		
	}

	private static void findMedian(int[] data) {
		
		int[] local = data;
		
		Arrays.sort(local);
		System.out.println("After sorting");
		System.out.println(Arrays.toString(local));
		
		int start = 0;
		int end = local.length - 1;
		int median = 0;
		int mid = (start + end) / 2;
		
		if (local.length % 2 == 0) {
			median = (local[mid] + local[mid + 1]) / 2;
		} else {
			median = local[mid];
		}
		
		System.out.println("median: " + median);
		
	}

}
