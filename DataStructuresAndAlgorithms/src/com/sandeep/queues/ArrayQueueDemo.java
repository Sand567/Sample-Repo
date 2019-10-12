package com.sandeep.queues;

import com.sandeep.queues.Employee;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		Employee jackDoe = new Employee("Jack", "Doe", 567);
		
		ArrayQueue queue = new ArrayQueue(10);
		queue.add(janeDoe);
		queue.add(johnDoe);
		queue.add(jillDoe);
		queue.add(jimDoe);
		queue.add(jackDoe);
		
		queue.printQueue();
		System.out.println();
		
		queue.remove();
		queue.remove();
		queue.printQueue();
		System.out.println();
		
		System.out.println("Peek: " + queue.peek());
		System.out.println();
		
		queue.remove();
		queue.remove();
		queue.remove();
//		queue.remove();
		System.out.println("Queue after all elements being removed");
		queue.printQueue();
		System.out.println();
		
		queue.add(johnDoe);
		queue.printQueue();
		
		
	}

}
