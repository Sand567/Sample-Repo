package com.sandeep.queues;

import java.util.NoSuchElementException;

public class ArrayCircularQueue {
	
	private Employee[] queue;
	private int front;
	private int back;
	
	public ArrayCircularQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		
		// we check the size rather than the back pointer
		// because when we remove we are setting the value at front to null and
		// incrementing the front pointer and hence we have free spaces 
		// at the front of the queue and as a result back would 
		// point to the number of elements + 1 from the front pointer
		// even though we had few elements we were resizing the array when 
		// back is equal to the length of the queue
		if (size() == queue.length) {
			
			System.out.println("Resizing the queue");
			
			// we save the original size of the array before we
			// copy over the elements from queue to newArray
			int numItems = size();
			
			// resize the array
			// in this case too, back will be one greater than the 
			// last valid index
			Employee[] newArray = new Employee[2 * queue.length];
			
			// 0 - jill
			// 1 - jim
			// 2 -			-back - place to add jack
			// 3 - jane		-front
			// 4 - john
			
			// queue after copy
			// 0 - jane		-front
			// 1 - john
			// 2 - jill
			// 3 - jim
			// 4 - 			-back
			
			// This will copy all the elements in the 'queue' from the front pointer 
			// to queue.length - front elements
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			
			// This will copy all the elements in the 'queue' from 0
			// to back elements
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			
			queue = newArray;
			
			// finally set front to 0
			front = 0;
			
			// back to numItems which is actual number of elements
			back = numItems;
		}
		
		queue[back] = employee;
		
		// we only increment back only
		// when we actually have queue.length - 1 number of elements
		// the queue
		if (back < queue.length - 1) {
			back++;
		} else {
			
			// else this is the case when
			// there are fewer number of elements
			// we wrap around the back pointer to 0th index
			back = 0;
		}
	}
	
	public Employee remove() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		
		Employee employeeRemoved = queue[front];
		queue[front] = null;
		front++;
		
		if (size() == 0) {
			front = 0;
			back = 0;
		} else if (front == queue.length) {
			front = 0;
		}
		
		return employeeRemoved;
	}
	
	public Employee peek() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	public int size() {
		int queueSize = 0;
		
		if (front <= back) {
			queueSize = back - front;
		} else {
			queueSize = back - front + queue.length;
		}
		
		return queueSize;
	}
	
	public void printQueue() {
		
		if (front <= back) {
			for (int i = front; i < back; i++) {
				System.out.println(queue[i]);
			}
		} else {
			for (int i = front; i < queue.length; i++) {
				System.out.println(queue[i]);
			}
			
			for (int i = 0; i < back; i++) {
				System.out.println(queue[i]);
			}
		}

	}
	
}
