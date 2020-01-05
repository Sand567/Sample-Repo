package com.sandeep.hashtables;

public class SimpleHashTableDemo {

	public static void main(String[] args) {
		
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillJohnson = new Employee("Jill", "Johnson", 345);
		Employee jimPoleski = new Employee("Jim", "Poleski", 456);
		Employee jackReed = new Employee("Jack", "Reed", 567);
		
		SimpleHashTable hashTable = new SimpleHashTable();
		
		hashTable.put(janeJones.getLastName(), janeJones);
		hashTable.put(johnDoe.getLastName(), johnDoe);
		hashTable.put(jillJohnson.getLastName(), jillJohnson);
		hashTable.put(jimPoleski.getLastName(), jimPoleski);
		hashTable.put(jackReed.getLastName(), jackReed);
		
		hashTable.printHashTable();
		
		System.out.println();
		System.out.println("Retrieving record with key 'Poleski': " + hashTable.get(jimPoleski.getLastName()));
		System.out.println("Retrieving record with key 'Johnson': " + hashTable.get(jillJohnson.getLastName()));
		System.out.println("Retrieving record with key 'Doe': " + hashTable.get(johnDoe.getLastName()));
		System.out.println("Retrieving record with key 'Reed': " + hashTable.get(jackReed.getLastName()));
		System.out.println("Retrieving record with key 'Jones': " + hashTable.get(janeJones.getLastName()));
		
		System.out.println();
		System.out.println("Removing record with key 'Reed': " + hashTable.remove(jackReed.getLastName()));
		System.out.println("Removing record with key 'Johnson': " + hashTable.remove(jillJohnson.getLastName()));
		hashTable.printHashTable();
		
		

	}

}
