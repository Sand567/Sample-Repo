package com.sandeep.stacks.challenge;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
	
	private LinkedList<String> stack;
	
	public LinkedStack() {
		stack = new LinkedList<>();
	}
	
	public void push(String employee) {
		stack.push(employee);
	}
	
	public String pop() {
		return stack.pop();
	}
	
	public String peek() {
		return stack.peek();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void printStack() {
		ListIterator<String> iterator = stack.listIterator();
		System.out.print("[ ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.print("]");
	}
	
}
