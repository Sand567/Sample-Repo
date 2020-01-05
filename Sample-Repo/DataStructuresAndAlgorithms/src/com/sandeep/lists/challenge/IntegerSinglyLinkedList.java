package com.sandeep.lists.challenge;

public class IntegerSinglyLinkedList {
	
	private IntegerNode head;
	private int size;
	
	public void addToFront(int value) {
		IntegerNode node = new IntegerNode(value);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public void addSortedOrder(int value) {
		
		// check if the list is empty 
		// or if the value at head is the greater than the value 
		// we are inserting. Then we insert the new node
		// at the front by calling the addToFront()
		if (head == null || head.getValue() >= value) {
			addToFront(value);
			return;
		}
		
		// as we are already checking value of head 
		// in the above if statement, we do not need to check it again
		// hence we set the current to head's next node
		IntegerNode current = head.getNext();
		
		// we have to have the previous pointer because the node
		// we insert may be in between 2 nodes and hence the previous's 
		// next field should point to the new node we insert
		IntegerNode previous = head;
		
		// loop as long as the current is not null and 
		// current's value is less than value
		while (current != null && current.getValue() < value) {
			previous = current;
			current = current.getNext();
		}
		
		// when it comes out of the loop we have, it can either be that
		// current is null or current's value is greater than the new node's value
		// if current's value is greater: then we insert new node 
		// before the current node and previous node will point to the new node
		// if current is null: the new node will be the last node in the list
		IntegerNode newNode = new IntegerNode(value);
		newNode.setNext(current);
		previous.setNext(newNode);
		size++;
		
	}
	
	public IntegerNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}
		
		IntegerNode nodeToBeRemoved = head;
		head = head.getNext();
		nodeToBeRemoved.setNext(null);
		size--;
		return nodeToBeRemoved;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	public void printList() {
		IntegerNode current = head;
		System.out.print("HEAD -> ");
		
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		
		System.out.println("null");
	}

}
