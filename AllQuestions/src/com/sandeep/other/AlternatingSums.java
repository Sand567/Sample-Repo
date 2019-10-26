package com.sandeep.other;

import java.util.Arrays;

public class AlternatingSums {

	public static void main(String[] args) {
		
		int[] input = {20, 15, 40, 35, 60, 120};
		
		System.out.println("totalSum alternateSum difference");
		System.out.println(Arrays.toString(alternateSum(input)));

	}

	private static int[] alternateSum(int[] input) {
		
		int totalSum = 0;
		int alternateSum = 0;
		
		if (input.length == 0) {
			return null;
		}
		
		for (int i = 0; i < input.length; i++) {
			totalSum += input[i];
		}
		
		for (int i = 0; i < input.length; i = i + 2) {
			alternateSum += input[i];
		}
		
		int difference = totalSum - alternateSum;
		
		return new int[] {totalSum, alternateSum, difference};
		
	}

}
