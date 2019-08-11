package com.sandeep.lists.doublylinkedlists;

public class EmployeeDoublyLinkedList {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	public void addToFront(Employee employee) {
		
		EmployeeNode node = new EmployeeNode(employee);
		
		// we do not need to set the previous for the new 
		// node as it is automatically initialized to null
		
		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
		}
		
		head = node;
		size++;
		
	}
	
	public void addToEnd(Employee employee) {
		
		EmployeeNode node = new EmployeeNode(employee);
		
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		
		tail = node;
		size++;
		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public EmployeeNode removeFromFront() {
		
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode nodeToBeRemoved = head;
		
		// this condition occurs when head is the only node in the list
		// i.e. there is just one node in the list
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(head.getPrevious());
		}
		
		head = head.getNext();
		nodeToBeRemoved.setNext(null);
		
		size--;
		return nodeToBeRemoved;
	}
	
	public EmployeeNode removeFromEnd() {
		
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode nodeToBeRemoved = tail;
		
		if (tail.getPrevious() == null) {
			head = null;
		} else {
			tail.getPrevious().setNext(tail.getNext());
		}
		
		tail = tail.getPrevious();
		nodeToBeRemoved.setPrevious(null);
		
		size--;
		return nodeToBeRemoved;
		
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		
		while (current != null) {
			System.out.print(current);
			System.out.print(" <=> ");
			current = current.getNext();
		}
		
		System.out.println("null");
	}

}
