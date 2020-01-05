package com.sandeep.lists.challenge;

public class IntegerNode {
	
	private int value;
	private IntegerNode next;
	
	public IntegerNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public IntegerNode getNext() {
		return next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(IntegerNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
