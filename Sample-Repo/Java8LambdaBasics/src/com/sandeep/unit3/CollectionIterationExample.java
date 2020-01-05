package com.sandeep.unit3;

import java.util.Arrays;
import java.util.List;

import com.sandeep.common.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Dan", "Brown", 35),
				new Person("Charles", "River", 40),
				new Person("Rick", "Castle", 50),
				new Person("Kate", "Beckett", 35),
				new Person("Abraham", "Lincoln", 25),
				new Person("Winston", "Churchill", 45)
			);
		
		System.out.println("Using for loop");
		// Sequential Iterators
		for(int i = 0; i < people.size(); i++) {
			System.out.println(i);
		}
		
		System.out.println("Using for in loop");
		// Sequential Iterators
		for(Person person : people) {
			System.out.println(person);
		}
		
		System.out.println("Using forEach loop");
		// Parallel Iterators
		people.forEach(System.out::println);

	}

}
