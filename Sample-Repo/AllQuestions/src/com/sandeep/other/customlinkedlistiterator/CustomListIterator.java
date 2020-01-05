package com.sandeep.other.customlinkedlistiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomListIterator<T> implements Iterator<Node<T>> {
	
	private Node<T> current;
	
	public CustomListIterator(Node<T> head) {
		current = head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Node<T> next() {
		
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		Node<T> temp = current;
		current = current.getNext();
		return temp;
	   
	}

}
