package com.sandeep.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateOutStringAndNumbers {
	
	private static final Pattern VALID_NUMBER = Pattern.compile("[0-9]+");
	private static final Pattern VALID_WORD = Pattern.compile("[a-z]+");

	public static void main(String[] args) {
		
		String alpha = "8,33,21,0,16,50,37,0,melon,7,apricot,peach,pine,17,21";
		splitStringNumbers(alpha);
		
	}

	private static void splitStringNumbers(String alpha) {
		
		StringBuilder finalNumbers = new StringBuilder();
		StringBuilder finalWords = new StringBuilder();
		StringBuilder finalResult = new StringBuilder();
		
		Matcher matcher = VALID_NUMBER.matcher(alpha);
		while (matcher.find()) {
			finalNumbers.append(matcher.group()).append(" ");
		}
		
		finalNumbers = new StringBuilder(finalNumbers.toString().replaceAll(" $", ""));
		
		matcher = VALID_WORD.matcher(alpha);
		while (matcher.find()) {
			finalWords.append(matcher.group()).append(" ");
		}
		
		finalWords = new StringBuilder(finalWords.toString().replaceAll(" $", ""));
		
		if (!finalWords.toString().isEmpty()) {
			finalWords.append(" | ");
		}
		
		finalResult.append(finalWords).append(finalNumbers);
		
		System.out.println("Final Result");
		System.out.println(finalResult.toString());

	}

}
