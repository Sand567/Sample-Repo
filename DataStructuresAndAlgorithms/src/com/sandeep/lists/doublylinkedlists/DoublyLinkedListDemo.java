package com.sandeep.lists.doublylinkedlists;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		
		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
		
		list.addToFront(janeDoe);
		list.addToFront(johnDoe);
		list.addToFront(jillDoe);
		list.addToFront(jimDoe);
		
		list.printList();
		System.out.println("Size: " + list.getSize());
		
		Employee jackDoe = new Employee("Jack", "Doe", 567);
		
		System.out.println();
		list.addToEnd(jackDoe);
		list.printList();
		System.out.println("Size: " + list.getSize());
		
		System.out.println();
		list.removeFromFront();
		list.printList();
		System.out.println("Size: " + list.getSize());
		
		System.out.println();
		list.removeFromEnd();
		list.printList();
		System.out.println("Size: " + list.getSize());
		

	}

}
