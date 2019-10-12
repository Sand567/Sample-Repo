package com.sandeep.other;

public class SqrtOfANumber {

	public static void main(String[] args) {
		
		int number = 16;
		findSquareRoot(number);

	}

	private static void findSquareRoot(int number) {
		
		double temp;
		double squareRoot = number / 2;
		
		do {
			
			temp = squareRoot;
			squareRoot = (temp + (number / temp)) / 2;
			
		} while ((temp - squareRoot) != 0);
		
		System.out.println("Square root of " + number + " is " + squareRoot);
		
		
	}

}
