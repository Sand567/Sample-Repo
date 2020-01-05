package com.sandeep.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateChars {

	public static void main(String[] args) {
		printDuplicateCharacters("ProgrammingaarpP");
		System.out.println();
		printDuplicateCharacters("Combicnation");
		System.out.println();
		printDuplicateCharacters("Java");
	}
	
	/**
	 * This method finds and prints 
	 * duplicate characters in a word or a sentence
	 * @param word
	 */
	public static void printDuplicateCharacters(String word) {
		
		char[] characters = word.toCharArray();
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(Character character : characters) {
			if(charMap.containsKey(character)) {
				charMap.put(character, (charMap.get(character) + 1));
			} else {
				charMap.put(character, 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
		System.out.printf("List of duplicate characters in String '%s' %n", word);
		for(Map.Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() > 1) {
				System.out.printf("%s: %d occurences %n", entry.getKey(), entry.getValue());
			}
		}
	}

}
