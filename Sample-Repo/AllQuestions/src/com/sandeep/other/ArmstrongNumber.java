package com.sandeep.other;

public class ArmstrongNumber {

	public static void main(String[] args) {
		
        checkArmstrongNumber(153);
        checkArmstrongNumber(371);
        checkArmstrongNumber(9474);
        checkArmstrongNumber(54748);
        checkArmstrongNumber(407);
        checkArmstrongNumber(1674);

	}

	private static void checkArmstrongNumber(int number) {
		
		int copyOfNumber = number;
		int numOfDigits = String.valueOf(number).length();
		int sum = 0;
		
		while (copyOfNumber != 0) {

			System.out.println("copyOfNumber: " + copyOfNumber);

			int lastDigit = copyOfNumber % 10;
			int lastDigitToThePowerOfNoOfDigits = 1;
			
			for (int i = 0; i < numOfDigits; i++) {
				lastDigitToThePowerOfNoOfDigits *= lastDigit;
			}

			System.out.println("lastDigitToThePowerOfNoOfDigits: " + lastDigitToThePowerOfNoOfDigits);
			
			sum += lastDigitToThePowerOfNoOfDigits;

			System.out.println("sum: " + sum);
			copyOfNumber /= 10;
		}
		
		if (sum == number) {
            System.out.println(number + " is an armstrong number");
        } else {
            System.out.println(number + " is not an armstrong number");
        }

		System.out.println();
		
	}

}
