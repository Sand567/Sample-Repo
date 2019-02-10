package com.sandeep.strings1;

import java.util.Arrays;

/**
 * This class will check for anagrams by taking
 * in 2 string variables as parameters
 * @author sandeepnagendra
 *
 */
public class AnagramCheck {

	public static void main(String[] args) {
		System.out.println(areAnagrams("test", "etst") ? "They are anagrams \n" : "They are not anagrams \n");
		System.out.println(areAnagrams("test", "etstj") ? "They are anagrams \n" : "They are not anagrams \n");
		System.out.println(areAnagrams("test", "eemt") ? "They are anagrams \n" : "They are not anagrams \n");
	}
	
	/**
	 * This method converts the string to a character array
	 * and then sorts it and checks the length and characters are same or not
	 * @param word1
	 * @param word2
	 * @return
	 */
	private static boolean areAnagrams(String word1, String word2) {
		char[] str1 = word1.toCharArray();
		char[] str2 = word2.toCharArray();
		
		System.out.println("Before sorting");
		System.out.println("str1: " + Arrays.toString(str1) + ", str2: " + Arrays.toString(str2));
		
		if(str1.length != str2.length) {
			return false;
		}
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		System.out.println("After sorting");
		System.out.println("str1: " + Arrays.toString(str1) + ", str2: " + Arrays.toString(str2));
		
		for(int i = 0; i < str1.length; i++) {
			if(str1[i] != str2[i]) {
				return false;
			}
		}
		
		return true;
		
	}

}
