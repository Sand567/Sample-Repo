package com.sandeep.queues.challenge;

import java.util.LinkedList;

public class QueuesChallengeDemo {

	public static void main(String[] args) {
		
		String input = "I did, did I?";
		System.out.println(checkPalindrome(input));

	}

	private static boolean checkPalindrome(String input) {
		
		LinkedList<Character> stack = new LinkedList<>();
		LinkedList<Character> queue = new LinkedList<>();
		String lowerCase = input.toLowerCase();
		
		System.out.println(lowerCase);
		
		for (int i = 0; i < lowerCase.length(); i++) {
			char c = lowerCase.charAt(i);
			
			if (c >= 'a' && c <= 'z') {
				queue.addLast(c);
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			if (!stack.pop().equals(queue.removeFirst())) {
				return false;
			}
		}
		
		return true;
		
	}

}
