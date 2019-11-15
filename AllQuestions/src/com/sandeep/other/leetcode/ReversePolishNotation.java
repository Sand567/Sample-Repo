package com.sandeep.other.leetcode;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		
		String[] tokens = new String[] { "2", "1", "+", "3", "*", "20", "/"};
		System.out.println("Final result: " + evalRPN(tokens));

	}

	private static int evalRPN(String[] tokens) {
		
		String operators = "+-*/";
		Stack<String> stack = new Stack<>();
		
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				
				int index = operators.indexOf(token);
				
				switch (index) {
					case 0: 
						stack.push(String.valueOf(a + b));
						break;
					case 1: 
						stack.push(String.valueOf(a - b));
						break;
					case 2:
						stack.push(String.valueOf(a * b));
						break;
					case 3:
						stack.push(String.valueOf(a / b));
						break;
					default: 
						
				}
			}
		}
		
		return Integer.parseInt(stack.pop());
	}

}
