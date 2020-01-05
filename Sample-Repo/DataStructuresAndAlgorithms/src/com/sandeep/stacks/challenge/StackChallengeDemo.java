package com.sandeep.stacks.challenge;

import java.util.Arrays;

public class StackChallengeDemo {

	public static void main(String[] args) {
		
		String source = "Racecar";
		String[] srcArray = source.replaceAll("\\p{Punct}", "")
									.replaceAll(" ", "")
									.split("");

		System.out.println(Arrays.toString(srcArray));
		
		LinkedStack stack = new LinkedStack();
		for (int i = 0; i < srcArray.length; i++) {
			stack.push(srcArray[i]);
		}
		
		stack.printStack();
		
		System.out.println();
		for (int i = 0; i < srcArray.length; i++) {
			System.out.println("Comparing " + srcArray[i] + " with " + stack.peek());
			if (srcArray[i].equalsIgnoreCase(stack.peek())) {
				stack.pop();
			}
		}
		
		System.out.println(stack.isEmpty() ? "\nPalindrome" : "\nNot a Palindrome");
		
		

	}

}
