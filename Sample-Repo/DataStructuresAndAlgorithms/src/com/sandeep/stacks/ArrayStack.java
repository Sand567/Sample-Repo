package DataStructuresAndAlgorithms.src.com.sandeep.stacks;

import java.util.EmptyStackException;

public class ArrayStack {
	
	private Employee[] stack;
	
	// top is by default initialized to 0
	private int top;
	
	public ArrayStack(int capacity) {
		stack = new Employee[capacity];
	}
	
	public void push(Employee employee) {
		
		if (top == stack.length) {
			// resize the array
			Employee[] newArray = new Employee[2 * stack.length];
			
			// copy all the elements from stack to newArray
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			
			// finally assign the newArray back to stack
			stack = newArray;
		}
		
		// once above operation is complete 
		// assign the employee to whatever top is pointing to
		stack[top++] = employee;
		
	}
	
	public Employee pop() {
		
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		// here the top will always be pointing to the index 1 greater than the last element
		// hence we decrement the top to get the last element
		Employee employee = stack[--top];
		
		// set this to null as there is nothing at this index
		stack[top] = null;
		return employee;
		
	}
	
	public Employee peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack[top - 1];
	}
	
	private boolean isEmpty() {
		return top == 0;
	}
	
	public int size() {
		return top;
	}
	
	public void printStack() {
		
		for (int i = top - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
		
	}

}
