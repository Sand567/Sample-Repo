package com.sandeep.other;

public class GetLastCharacterInAString {

	public static void main(String[] args) {
		
		String sentence = "This is the demo sentence";
		fetchLastCharacter(sentence);

	}

	private static void fetchLastCharacter(String sentence) {
		
		char lastChar = sentence.substring(sentence.length() - 2).charAt(0);
		System.out.println("lastChar: " + String.valueOf(lastChar));
		
	}

}
