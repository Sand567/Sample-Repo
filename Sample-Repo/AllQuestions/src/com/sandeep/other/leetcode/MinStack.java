package com.sandeep.other.leetcode;

import java.util.Arrays;

public class MinStack {
	
	private int[] arr = new int[100];
	private int index = -1;

	public static void main(String[] args) {
		
		MinStack stack = new MinStack();
		stack.push(40);
		stack.push(10);
		stack.push(50);
		stack.push(20);
		stack.push(90);
		stack.printStack();
		System.out.println();
		System.out.println("top of stack is: " + stack.top());
		
		stack.pop();
		System.out.println("top of stack is: " + stack.top());
		stack.printStack();
		System.out.println();
		
		System.out.println("minimum value in stack: " + stack.getMin());

	}
	
	private void push(int element) {
		if (index == arr.length - 1) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		
		arr[++index] = element;
	}
	
	private int top() {
		System.out.println("index of top of the stack is: " + index);
		if (index > -1) {
			return arr[index];
		} else {
			return 0;
		}
	}
	
	private void pop() {
		if (index > -1) {
			if ((index == (arr.length / 2)) && arr.length > 100) {
				arr = Arrays.copyOf(arr, arr.length / 2);
			}
			
			arr[index] = 0;
			index--;
		}
	}
	
	private int getMin() {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i <= index; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		return min;
	}
	
	private void printStack() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
