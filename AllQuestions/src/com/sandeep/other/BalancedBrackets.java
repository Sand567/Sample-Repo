package com.sandeep.other;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < n; i++) {
			String s = scanner.nextLine();
			System.out.println(isMatched(s) ? "YES" : "NO");
		}
		
		scanner.close();

	}

	private static boolean isMatched(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray()) {
			
			// initially push new bracket characters 
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				
				char top = stack.pop();
				
				// if top does not match the new character return false
				if (!((c == '}' && top == '{') || (c == ')' && top == '(') || (c == ']' && top == '['))) {
					return false;
				}
			}
			
		}
		
		// if the list is empty that means that
		// there were balanced brackets
		return stack.isEmpty();
	}

}
