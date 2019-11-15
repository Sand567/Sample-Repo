package com.sandeep.other;

public class AmendSentence {

	public static void main(String[] args) {
		
        String s = "ThisIsMyLife";
        System.out.println(amendThisSentence(s));

	}

	private static String amendThisSentence(String s) {
		
		if (s.length() == 0) {
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && i == 0) {
				result.append(s.charAt(i));
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				result.append(" ").append(s.charAt(i));
			} else {
				result.append(s.charAt(i));
			}
		}
		
		return result.toString().toLowerCase();
		
	}

}
