package com.sandeep.primeNum;

public class PrimeNumers {

	public static void main(String[] args) {
		
		int num = 223;
		System.out.println("Sqrt of " + num + " is " + Math.sqrt(num));
		System.out.println("Is Prime or not? " + (isPrime(num) ? "PRIME" : "NOT PRIME"));

	}
	
	private static boolean isPrime(int number) {
		
		if (number == 2 || number == 3) {
			return true;
		}
		
		if (number % 2 == 0) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(number) + 1;

		System.out.println("sqrt: " + sqrt);
		
		for (int i = 3; i < sqrt; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}

}



