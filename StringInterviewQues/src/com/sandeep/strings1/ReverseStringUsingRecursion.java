package com.sandeep.strings1;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		
		String source = "How are you doing";
		System.out.println("Original: [ " + source + " ]");
		System.out.println();
		
		String reversed = reverseRecursive(source);
		System.out.println("Reversed: [ " + reversed + " ]");

	}

	private static String reverseRecursive(String source) {
		
		System.out.println("New Source: [ " + source + " ]");
		
		if (source.length() < 2) {
			return source;
		}
		
		return reverseRecursive(source.substring(1)) + source.charAt(0);
		
	}

}
