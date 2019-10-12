package com.sandeep.other;

import java.util.Stack;

public class CheckBalancedBrackets {

	public static void main(String[] args) {
		
		System.out.println((isBalancedString("{([])}")) ? "Balanced" : "Not Balanced" );
		System.out.println((isBalanced("a*(b+c)-(d*e)")) ? "Balanced" : "Not Balanced");
		System.out.println((isBalanced("a*((b+c)-(d*e)")) ? "Balanced" : "Not Balanced");

	}

	private static boolean isBalanced(String expression) {
		
		if (expression.isEmpty()) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < expression.length(); i++) {
			
			char current = expression.charAt(i);
			
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}
			
			if (current == '}' || current == ')' || current == ']') {
				
				if (stack.isEmpty()) {
					return false;
				}
				
				char last = stack.peek();
				
				if (current == '}' && last == '{' 
						|| current == ')' && last == '(' || current == ']' && last == '[') {
					stack.pop();
				} else {
					return false;
				}

			}
			
		}
		
		return stack.isEmpty();
	}

	private static boolean isBalancedString(String string) {
		
		System.out.println("Orignal: " + string);
		return string.split("").length % 2 == 0;

	}

}
