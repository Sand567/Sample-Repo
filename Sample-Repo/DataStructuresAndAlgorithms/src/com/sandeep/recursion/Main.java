package com.sandeep.recursion;

public class Main {

	public static void main(String[] args) {
		
		// n! = n * (n - 1)!
		// 3! = 3 * 2!
		// 2! = 2 * 1!
		// 1! = 1 * 0!
		// 0! = 1
		
		int n = 3;
		System.out.println("iterativeFactorial for " + n + ": " + iterativeFactorial(n));
		System.out.println("recursiveFactorial for " + n + ": " + recursiveFactorial(n));

	}
	
	private static int iterativeFactorial(int num) {
		
		if (num == 0) {
			return 1;
		}
		
		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}
		
		return factorial;
		
	}
	
	private static int recursiveFactorial(int num) {
		
		if (num == 0) {
			return 1;
		}
		
		return num * recursiveFactorial(num - 1);
		
	}

}
