package DataStructuresAndAlgorithms.src.com.sandeep.queues;

import java.util.NoSuchElementException;

public class ArrayQueue {
	
	private Employee[] queue;
	private int front;
	private int back;
	
	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		if (back == queue.length) {
			// resize the array
			// in this case too, back will be one greater than the 
			// last valid index
			Employee[] newArray = new Employee[2 * queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		
		queue[back++] = employee;
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
		return back - front;
	}
	
	public void printQueue() {
		for (int i = front; i < back; i++) {
			System.out.println(queue[i]);
		}
	}
	
}
