package DataStructuresAndAlgorithms.src.com.sandeep.stacks;

public class LinkedStackDemo {

	public static void main(String[] args) {
		
		Employee janeDoe = new Employee("Jane", "Doe", 123);
		Employee johnDoe = new Employee("John", "Doe", 234);
		Employee jillDoe = new Employee("Jill", "Doe", 345);
		Employee jimDoe = new Employee("Jim", "Doe", 456);
		Employee jackDoe = new Employee("Jack", "Doe", 567);
		
		LinkedStack stack = new LinkedStack();
		
		System.out.println("Is stack empty? " + stack.isEmpty());
		
		stack.push(janeDoe);
		stack.push(johnDoe);
		stack.push(jillDoe);
		stack.push(jimDoe);
		stack.push(jackDoe);
		
		stack.printStack();
		System.out.println("Is stack empty? " + stack.isEmpty());
		System.out.println();
		
		System.out.println("top of the stack: " + stack.peek());
		System.out.println("popped: " + stack.pop());
		System.out.println("top of the stack: " + stack.peek());
		System.out.println();
		
		stack.printStack();
		

	}

}
