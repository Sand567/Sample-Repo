package com.sandeep.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.sandeep.common.Person;

public class MethodReferenceExample2 {

public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
			new Person("Dan", "Brown", 35),
			new Person("Charles", "River", 40),
			new Person("Rick", "Castle", 50),
			new Person("Kate", "Beckett", 35),
			new Person("Abraham", "Lincoln", 25),
			new Person("Winston", "Churchill", 45)
		);
		
		// Similar to person -> method(person) i.e. person -> System.out.println(person)
		// As System.out::println is taking the place of consumer, it knows that
		// it should accept an input argument
		performConditionally(people, person -> true, System.out::println);

	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		people.forEach(person -> {
			if(predicate.test(person)) {
				consumer.accept(person);
			}
		});
	}

}
