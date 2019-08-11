package com.sandeep.lists.challenge;

public class LinkedListChallenge1 {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		
		// new node to addedBefore()
		Employee jackDoe = new Employee("Jack", "Doe", 567);
		
		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
		
		list.addToFront(janeDoe);
		list.addToFront(johnDoe);
		list.addToFront(jillDoe);
		list.addToFront(jimDoe);
		list.printList();
		System.out.println("Size: " + list.getSize());
		System.out.println();
		
		list.addBefore(jackDoe, johnDoe);
		list.printList();
		System.out.println("Size: " + list.getSize());
		System.out.println();
		
		list.addBefore(new Employee("someone", "else", 1111), jimDoe);
		list.printList();
		System.out.println("Size: " + list.getSize());
		System.out.println();

	}

}
