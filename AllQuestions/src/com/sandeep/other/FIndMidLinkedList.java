package com.sandeep.other;

public class FIndMidLinkedList {
	
	private Node head;
	private Node tail;
	
	public FIndMidLinkedList() {
		this.head = new Node("HEAD");
		tail = head;
	}
	
	private Node head() {
		return head;
	}
	
	private void add(Node node) {
		tail.setNext(node);
		tail = node;
	}
	
	static class Node {
		
		private String data;
		private Node next;
		
		Node(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return data;
		}
		
	}

	public static void main(String[] args) {
		
		FIndMidLinkedList list = new FIndMidLinkedList();
		Node head = list.head();
		
		list.add(new Node("John"));
		list.add(new Node("Jane"));
		list.add(new Node("Jim"));
		list.add(new Node("Jill"));
		
		Node temp = head;
		while (temp != null) {
			System.out.print(temp + " -> ");
			temp = temp.getNext();
		}
		
		System.out.println("NULL");
		
		Node current = head;
		Node middle = head;
		int length = 0;
		
		while (current.getNext() != null) {
			
			length++;
			System.out.println("length: " + length);
			
			if (length % 2 == 0) {
				middle = middle.getNext();
			}
			
			current = current.getNext();
			
		}
		
		if (length % 2 == 1) {
			middle = middle.getNext();
		}
		
		System.out.println("final length: " + length);
		System.out.println("Middle element: " + middle);
		
	}

}
