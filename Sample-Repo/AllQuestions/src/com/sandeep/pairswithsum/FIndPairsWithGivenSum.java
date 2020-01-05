package com.sandeep.pairswithsum;

public class FIndPairsWithGivenSum {

	public static void main(String[] args) {
		int arr[] = {2, 4, 3, 3};
		int sum = 6;
		findPairsBruteForce(arr, sum);
	}

	private static void findPairsBruteForce(int[] input, int sum) {

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (j != i && (input[i] + input[j]) == sum) {
					addPairsAndDisplay(input[i], (sum - input[i]));
				}
			}
		}

	}

	private static void addPairsAndDisplay(int i, int j) {
		StringBuilder builder = new StringBuilder();
	}
	
	private static void displayPairs() {
		
	}
	

}
