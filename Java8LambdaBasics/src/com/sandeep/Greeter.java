package com.sandeep;

import org.omg.CORBA.PUBLIC_MEMBER;

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
		
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.println("Hello World!");
			}
		};
		
		greeter.greet(myLambdaFunction);
		greeter.greet(innerClassGreeting);
		
	}

}

