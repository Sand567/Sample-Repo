package com.sandeep.other;

public class ReverseString {

	public static void main(String[] args) {
		
		String source = "Hello World";
		System.out.println("The reverse of the original string is === " + reverse(source) + " ===");
		
	}
	
	private static String reverse(String source) {
		
		if (source == null || source.isEmpty()) {
			return source;
		}
		
		String reversedString = "";
		
		for (int i = source.length() - 1; i >= 0; i--) {
			reversedString = reversedString + source.charAt(i);
		}
		
		return reversedString;
		
	}

}
