package com.sandeep.other;

public class IntegerStringConversion {

	public static void main(String[] args) {
		
		System.out.println("Integer to String: " + intToString(-723));
		System.out.println("Integer to String: " + intToString(956));
		
		System.out.println();
		
		System.out.println("String to Integer: " + strToInteger("2674"));
		System.out.println("String to Integer: " + strToInteger("-836"));

	}
	
	private static String intToString(int num) {
		boolean isNegative = false;
		
		if (num < 0) {
			isNegative = true;
		}
		
		StringBuilder builder = new StringBuilder();
		
		do {
			
			builder.append((char)('0' + Math.abs(num % 10)));
			num /= 10;
			
		} while (num != 0);
		
		if (isNegative) {
			builder.append("-");
		}
		
		builder.reverse();
		
		return builder.toString();
	}
	
	private static int strToInteger(String str) {
		int result = 0;
		
		for (int i = str.charAt(0) == '-' ? 1 : 0; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			System.out.println("digit: " + digit);
			result = result * 10 + digit;
			System.out.println("result in iteraton " + (i) + ": " + result);
		}
		
		
		return str.charAt(0) == '-' ? -result : result;

	}

}
