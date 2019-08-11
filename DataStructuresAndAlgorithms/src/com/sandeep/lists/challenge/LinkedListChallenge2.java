package com.sandeep.lists.challenge;

public class LinkedListChallenge2 {

	public static void main(String[] args) {
		
		IntegerSinglyLinkedList list = new IntegerSinglyLinkedList();
		
		int one = 1;
		int two = 2;
		int three = 3;
		int four = 4;
		
		list.addSortedOrder(three);
		list.printList();
		list.addSortedOrder(two);
		list.printList();
		list.addSortedOrder(one);
		list.printList();
		list.addSortedOrder(four);
		list.printList();

	}

}
