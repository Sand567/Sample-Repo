package com.sandeep.other;

public class ReverseLinkedList {
	
	private Node head;
	
	class Node {
		private int data;
		private Node next;
		
		Node(int data) {
			this.data = data;
		}
		
	    public int getData() {
	    	return data;
	    }

		public Node getNext() {
			return next;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	public ReverseLinkedList(int data) {
		Node head = new Node(data);
		this.head = head;
	}

	public static void main(String[] args) {
		
		ReverseLinkedList list = new ReverseLinkedList(100);
		list.add(40);
		list.add(60);
		list.add(20);
		list.add(10);
		list.add(60);
		
		System.out.println("Original list");
		list.print();
		System.out.println();
		System.out.println();
		
		System.out.println("Reversed list");
		list.reverse();
		list.print();
		System.out.println();
		System.out.println();
		

	}
	
	private void add(int data) {
		Node node = new Node(data);
		Node current = head;
		
		while (current != null) {
			if (current.getNext() == null) {
				current.setNext(node);
				break;
			}
			
			current = current.getNext();
		}
	}
	
	private void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}
	
	private void reverse() {
		
		Node pointer = head;
		Node previous = null;
		Node current = null;
		
		while (pointer != null) {
			current = pointer;
			pointer = pointer.getNext();
			
			current.setNext(previous);
			previous = current;
			head = current;
		}
	}
	
}
