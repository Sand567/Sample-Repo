package com.sandeep.other;

/**
 * This class will check for palindrome by taking in a string
 * @author sandeepnagendra
 *
 */
public class PalindromeCheck {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome("aaa") ? "Palindrome \n" : "Not a Palindrome \n");
		System.out.println(isPalindrome("abc") ? "Palindrome \n" : "Not a Palindrome \n");
		
		System.out.println(isPalindromic("racecar") ? "Palindrome \n" : "Not a Palindrome \n");
		System.out.println(isPalindromic("hello") ? "Palindrome \n" : "Not a Palindrome \n");
		System.out.println(isPalindromic("IdiddidI") ? "Palindrome \n" : "Not a Palindrome \n");

	}
	
	/**
	 * This method will convert the word into ch[] and then 
	 * check loops from the last element back to the 1st element
	 * and then compare original and reversed string
	 * @param word
	 * @return
	 */
	private static boolean isPalindrome(String word) {
		
		if(word == null || word.isEmpty()) {
			return false;
		}
		
		System.out.println("Original: " + word);
		
		char[] cs = word.toCharArray();
		StringBuilder sBuilder = new StringBuilder(word.length());
		for(int i = word.length() - 1; i >= 0; i--) {
			sBuilder.append(cs[i]);
		}
		
		String reversedString = sBuilder.toString();
		System.out.println("Reverse: " + reversedString);
		
		return word.equals(reversedString);
		
	}
	
	private static boolean isPalindromic(String word) {
		for (int i = 0, j = word.length() - 1; i < j; ++i, --j) {
			System.out.println("i: " + i + ", j: " + j);
			System.out.println("charAt(" + i + ") is " + word.charAt(i) + ", charAt(" + j + ") is " + word.charAt(j));
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}

}
