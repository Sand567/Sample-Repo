package DataStructuresAndAlgorithms.src.com.sandeep.stacks;

public class ArrayStackDemo {

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(new Employee("John", "Doe", 123));
		stack.push(new Employee("Jane", "Doe", 234));
		stack.push(new Employee("Jill", "Doe", 345));
		stack.push(new Employee("Jim", "Doe", 456));
		stack.push(new Employee("Jay", "Doe", 567));
		
		stack.printStack();
		System.out.println();
		
		System.out.println("top of the stack: " + stack.peek());
		System.out.println();
		
		System.out.println("popped: " + stack.pop());
		System.out.println("top of the stack: " + stack.peek());
		System.out.println();
		
		stack.printStack();

	}

}
