package DataStructuresAndAlgorithms.src.com.sandeep.lists.arrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("John", "Doe", 123));
		employeeList.add(new Employee("Jane", "Doe", 234));
		employeeList.add(new Employee("Bane", "Doe", 345));
		employeeList.add(new Employee("Jill", "Doe", 456));
		
		System.out.println(employeeList.set(2, new Employee("Bill", "Doe", 345)));
		
		
//		employeeList.add(2, new Employee("Jenn", "Doe", 567));
//		employeeList.forEach(e -> System.out.println(e));
		
		System.out.println();
		Object[] empArray = employeeList.toArray();
		for (Object employee : empArray) {
			System.out.println(employee);
		}
		
		System.out.println();
		// this is false as we haven't implemented the equals method
		System.out.println(employeeList.contains(new Employee("Jill", "Doe", 456)));
		System.out.println(employeeList.indexOf(new Employee("Jane", "Doe", 234)));
		
		employeeList.remove(0);
		employeeList.forEach(e -> System.out.println(e));
		
		// Vector - thread safe
		// ArrayList - Not thread safe
		List<Integer> vectorList = new Vector<>();
		vectorList.add(10);
		vectorList.add(30);
		vectorList.add(50);
		
		System.out.println("Vector");
		vectorList.forEach(i -> System.out.println(i));

	}

}
