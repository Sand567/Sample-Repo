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
		
		result.append(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				result.append(" ").append(s.charAt(i));
			} else {
				result.append(s.charAt(i));
			}
		}
		
		return result.toString().toLowerCase();
		
	}

}
