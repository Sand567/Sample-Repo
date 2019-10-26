package com.sandeep.other.customlinkedlistiterator;

import java.util.Iterator;

public class CustomLinkedListIteratorDemo {

	public static void main(String[] args) {
		
		CustomList<Person> customList = new CustomList<>();
		
		customList.add(new Person("John", 10, "Chicago"));
		customList.add(new Person("Jane", 15, "Boston"));
		customList.add(new Person("Jim", 20, "San Jose"));
		
		Iterator<Node<Person>> pIterator = customList.iterator();
		
		while (pIterator.hasNext()) {
			System.out.println(pIterator.next());
		}
		
		System.out.println();
		
		CustomList<Integer> customList2 = new CustomList<>();
		
		customList2.add(90);
		customList2.add(20);
		customList2.add(60);
		
		Iterator<Node<Integer>> intIterator = customList2.iterator();
		
		while (intIterator.hasNext()) {
			System.out.println(intIterator.next());
		}

	}

}
