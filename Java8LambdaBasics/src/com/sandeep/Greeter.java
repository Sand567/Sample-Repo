package com.sandeep;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		
		Greeter greeter = new Greeter();
		Greeting helloworldGreeting = new HelloWorldGreeting();
		greeter.greet(helloworldGreeting);
		
		// The type of myLambdaFunction should be an interface which 
		// takes in no arguments and should return a void
		// The interface should be a functional interface
		// which means it should just contain one single method declaration
		Greeting myLambdaFunction = () -> System.out.println("Hello World!");
		
//		MyAdd myAddFunction = (int a, int b) -> a + b;

	}

}

