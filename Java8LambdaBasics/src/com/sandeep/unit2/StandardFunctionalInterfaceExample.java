package com.sandeep.unit2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.sandeep.common.Person;

public class StandardFunctionalInterfaceExample {

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
		performConditionally(people, person -> true, person -> System.out.println(person));
		System.out.println();
		
		// Step-3: Create a method that prints all people that have last name beginning with C
		performConditionally(people, person -> person.getLastName().startsWith("C"), person -> System.out.println(person));
		System.out.println();
		
		// Step-3: Create a method that prints all people that have first name beginning with A
		performConditionally(people, person -> person.getFirstName().startsWith("A"), person -> System.out.println(person));

	}

	// This will print all people whose lastName begin with a "C"
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
//		people.stream().filter(person -> person.getLastName().startsWith("C")).forEach(System.out::println);
		people.forEach(person -> {
			if(predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}

	// this will sort the list
	private static void sortList(List<Person> people) {
		people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
	}

}
