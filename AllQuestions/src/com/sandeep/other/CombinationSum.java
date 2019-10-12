package com.sandeep.other;

public class CombinationSum {

	public static void main(String[] args) {
		
		int n = 10;
		partition(n, n, "");

	}

	private static void partition(int n, int max, String prefix) {
		
		if (n == 0) {
			System.out.println(prefix);
			return;
		}
		
		for (int i = Math.min(n, max); i >= 1; i--) {
			partition((n - i), i, prefix + " " + i);
		}
		
	}
	
	

}
