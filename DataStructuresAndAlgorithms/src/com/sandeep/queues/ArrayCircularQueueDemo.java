package com.sandeep.queues;

public class ArrayCircularQueueDemo {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		Employee jackDoe = new Employee("Jack", "Doe", 567);
		
		ArrayQueue queue = new ArrayQueue(5);
		
		queue.add(janeDoe);
		queue.add(johnDoe);
		queue.remove();
		queue.add(jillDoe);
		queue.remove();
		queue.add(jimDoe);
		queue.remove();
		queue.add(jackDoe);
		queue.remove();
		queue.add(janeDoe);
		
		queue.size();
		queue.printQueue();
		
	}

}
