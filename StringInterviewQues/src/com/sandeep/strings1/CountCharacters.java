package com.sandeep.strings1;

public class CountCharacters {

	public static void main(String[] args) {
		
		String word = "Today is Sunday and tomorrow is Monday";
		countOfCharacters(word);

	}
	
	private static void countOfCharacters(String word) {
		
		int charCount = 0;
		
		// count characters using for loop
		long start = System.currentTimeMillis();
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == 'a') {
				charCount++;
			}
		}
		long end = System.currentTimeMillis();
		
		long total = end - start;
		
		System.out.println("Count of character 'a' in the word \"" + word + "\" using for loop is: " + charCount + " and time: " + total);
		
		charCount = 0;
		
		// count characters using for each loop
		start = System.currentTimeMillis();
		for(char ch : word.toCharArray()) {
			if(ch == 'a') {
				charCount++;
			}
		}
		end = System.currentTimeMillis();
		total = end - start;
		
		System.out.println("Count of character 'a' in the word \"" + word + "\" using for each loop is: " + charCount+ " and time: " + total);
	}

}
