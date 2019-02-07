package com.sandeep;

public class MyRunnableExample {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printed from within Runnable");
			}
		});
		
		myThread.run();
		
		Thread myLambdaThread = new Thread(() -> System.out.println("Printed from within Lambda Runnable"));
		myLambdaThread.run();

	}

}
