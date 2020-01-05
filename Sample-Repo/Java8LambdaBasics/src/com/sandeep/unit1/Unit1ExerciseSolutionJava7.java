package com.sandeep.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import com.sandeep.common.Person;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		
		// Stub list
		List<Person> people = Arrays.asList(
			new Person("Dan", "Brown", 35),
			new Person("Charles", "River", 40),
			new Person("Rick", "Castle", 50),
			new Person("Kate", "Beckett", 35),
			new Person("Abraham", "Lincoln", 25),
			new Person("Winston", "Churchill", 45)
		);
			
		// Step-1: Sort a list by last name
		sortList(people);
		
		// Step-2: Create a method that prints all elements in the list
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person person) {
				return true;
			}
		});
		System.out.println();
		
		// Step-3: Create a method that prints all people that have last name beginning with C
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getLastName().startsWith("C");
			}
		});

	}

	// This will sort the list
	private static void sortList(List<Person> people) {
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
	}

	// This will print people with the lastName beginning with "C"
	private static void printConditionally(List<Person> people, Condition condition) {
		ListIterator<Person> listIterator = people.listIterator();
		while(listIterator.hasNext()) {
			Person person = listIterator.next();
			if(condition.test(person)) {
				System.out.println(person);
			}
		}
		
	}

	// This will print all the people
//	private static void printAll(List<Person> people) {
//		ListIterator<Person> listIterator = people.listIterator();
//		while(listIterator.hasNext()) {
//			Person person = listIterator.next();
//			System.out.println(person);
//		}
//	}

}

interface Condition {
	boolean test(Person person);
}
