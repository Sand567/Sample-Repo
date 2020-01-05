package com.sandeep.linkedlists;

public class LinkedListExample1 {
	
	private Node head;

	public static void main(String[] args) {
		
		LinkedListExample1 example1 = new LinkedListExample1();
		
		example1.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		example1.head.next = second;
		second.next = third;
		
		example1.printList();

	}

	private void printList() {
		
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		
	}

}
