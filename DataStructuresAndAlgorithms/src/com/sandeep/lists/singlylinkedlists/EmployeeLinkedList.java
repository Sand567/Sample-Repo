package com.sandeep.lists.singlylinkedlists;

public class EmployeeLinkedList {
	
	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
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
		head = head.getNext();
		nodeToBeRemoved.setNext(null);
		size--;
		return nodeToBeRemoved;
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		
		while (current != null) {
			System.out.print(current.getEmployee().getFirstName());
			System.out.print(" -> ");
			current = current.getNext();
		}
		
		System.out.print("null");
	}
	
	public void reverse() {
		EmployeeNode pointer = head;
		EmployeeNode current = null;
		EmployeeNode previous = null;
		
		while (pointer != null) {
			current = pointer;
			pointer = pointer.getNext();
			
			current.setNext(previous);
			previous = current;
			head = current;
		}
	}
	
	public Employee getNthNodeFromTail(int n) {
		EmployeeNode fast = head;
		EmployeeNode slow = head;
		int start = 1;
		
		while (fast.getNext() != null) {
			fast = fast.getNext();
			start++;
			
			if (start > n) {
				slow = slow.getNext();
			}
		}
		
		return slow.getEmployee();
	}

}
