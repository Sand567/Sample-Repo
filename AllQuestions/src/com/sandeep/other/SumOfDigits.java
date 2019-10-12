package com.sandeep.other;

public class SumOfDigits {

	public static void main(String[] args) {
		
		findSumOfDigits(3471);
		findSumOfDigits(783);
		findSumOfDigits(342);
		findSumOfDigits(19234);
		findSumOfDigits(8827);

	}

	private static void findSumOfDigits(int number) {
		
		int copyOfNumber = number;
		int sum = 0;
		
		while (copyOfNumber != 0) {
			
			// this will get us the last digit of the number
			int lastDigit = copyOfNumber % 10;
			
			// this will concatenate the result to sum
			sum += lastDigit;
			
			// this will reduce the number
			// eg: 3471 / 10 = 347
			// eg: 347 / 10 = 34
			// eg: 34 / 10 = 3
			// eg: 3 / 10 = 0
			copyOfNumber /= 10;
		}
		
		System.out.println("Sum of " + number + " is " + sum);
		
	}

}
