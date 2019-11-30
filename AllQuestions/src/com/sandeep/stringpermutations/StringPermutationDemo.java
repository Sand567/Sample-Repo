package com.sandeep.stringpermutations;

public class StringPermutationDemo {

	public static void main(String[] args) {
		permutation("GOD");
	}

	private static void permutation(String input) {
		permutation("", input);
	}

	private static void permutation(String perm, String input) {
		
		if (input.isEmpty()) {
			System.out.println(perm + input);
		} else {
			
			for (int i = 0; i < input.length(); i++) {
				permutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));
			}
			
		}
		
	}

}
