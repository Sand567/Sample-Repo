package com.sandeep.other.customlinkedlistiterator;

import java.util.Iterator;

public class CustomList<T> implements Iterable<Node<T>> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public CustomList() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void add(T data) {
		
		Node<T> temp = new Node<>(data);
		
		if (head == null) {
			temp.setPrevious(null);
			head = tail = temp;
		} else {
			tail.setNext(temp);
			temp.setPrevious(tail);
			tail = temp;
		}
	}

	@Override
	public Iterator<Node<T>> iterator() {
		return new CustomListIterator<T>(head);
	}

}
