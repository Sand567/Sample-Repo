package com.sandeep.lists.singlylinkedlists;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		
		System.out.println("Is the list empty? " + list.isEmpty());
		
		list.addToFront(janeDoe);
		list.addToFront(johnDoe);
		list.addToFront(jillDoe);
		list.addToFront(jimDoe);
		
		System.out.println("Size: " + list.getSize());
		
		list.printList();
		
		System.out.println();
		list.removeFromFront();
		System.out.println("Size: " + list.getSize());
		list.printList();

	}

}
