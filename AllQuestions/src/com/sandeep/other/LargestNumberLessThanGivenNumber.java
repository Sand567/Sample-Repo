package com.sandeep.other;

public class LargestNumberLessThanGivenNumber {

	public static void main(String[] args) {
		
		getLessThanN(123, 2);
		getLessThanN(4582, 5);
		getLessThanN(98512, 9);
		getLessThanN(548624, 8);
		
	}

	private static void getLessThanN(int number, int digit) {
		
		// get the digit as a character for easier comparison
		char c = Integer.toString(digit).charAt(0);
		
		for (int i = number; i > 0; --i) {
			if (Integer.toString(i).indexOf(c) == -1) {
				// this condition will be satisfied when
				// a number does not contain the digit
				// then we display the number
				System.out.println("Next largest number which does not contain " + digit + " is " + i); 
				return;
			}
		}
		
	}

}
