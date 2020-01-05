package com.sandeep.unit1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.sandeep.common.Person;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		
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
		printConditionally(people, person -> true);
		System.out.println();
		
		// Step-3: Create a method that prints all people that have last name beginning with C
		printConditionally(people, person -> person.getLastName().startsWith("C"));

	}

	// This will print all people whose lastName begin with a "C"
	private static void printConditionally(List<Person> people, Condition condition) {
//		people.stream().filter(person -> person.getLastName().startsWith("C")).forEach(System.out::println);
		people.forEach(person -> {
			if(condition.test(person)) {
				System.out.println(person);
			}
		});
	}

	// this will sort the list
	private static void sortList(List<Person> people) {
		people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
	}

}
