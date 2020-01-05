package com.sandeep.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		
		int[] numbers = {2, 6, 7, 4};
		int key = 0;
		
		process(numbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

	}

	// This is a wrapper to the existing lambda which will 
	// move the part of handling the exceptions from the place where
	// the lambda actually gets called which will catch the exception if it occurs
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		return (v, k) -> {
			try {
				biConsumer.accept(v, k);
			} catch(ArithmeticException e) {
				System.out.println("Exception caught in wrapperLambda");
			}
		};
	}

	// This method will accept the lambda and invoke the method to execute the lambda
	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for(int i : numbers) {
			biConsumer.accept(i, key);
		}
	}

}
