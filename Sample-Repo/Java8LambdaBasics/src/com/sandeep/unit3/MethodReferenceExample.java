package com.sandeep.unit3;

public class MethodReferenceExample {

	public static void main(String[] args) {
//		Thread t1 = new Thread(() -> printMessage());
		Thread t1 = new Thread(MethodReferenceExample::printMessage);
		t1.start();
	}

	private static void printMessage() {
		System.out.println("Hello!");
	}

}
