package com.sandeep.arrays1;

import java.util.Arrays;

/**
 * This class checks if a value exists in an array
 */
public class CheckValueInArray {

	public static void main(String[] args) {
		
		Integer [] input = new Integer[] {1, 2, 3, 4, 5};
		System.out.printf("Does array %s isExists %s? %b %n", Arrays.toString(input), 3, isExists(input, 3));
		System.out.printf("Does array %s containsElement %s? %b %n", Arrays.toString(input), 3, containsElement(input, 3));
		System.out.printf("Does array %s isExists %s? %b %n", Arrays.toString(input), 6, isExists(input, 6));
		System.out.printf("Does array %s containsElement %s? %b %n", Arrays.toString(input), 6, containsElement(input, 6));
		System.out.println();
		
		String [] names = new String[] {"Sandeep", "Sharath", "Nagendra", "Mahima"};
		System.out.printf("Does array %s isExists %s? %b %n", Arrays.toString(names),
				"Nagendra", isExists(names, "Nagendra"));
		System.out.printf("Does array %s containsElement %s? %b %n", Arrays.toString(names),
				"Nagendra", containsElement(names, "Nagendra"));
		System.out.printf("Does array %s isExists %s? %b %n", Arrays.toString(names),
				"Shiva", isExists(names, "Shiva"));
		System.out.printf("Does array %s containsElement %s? %b %n", Arrays.toString(names),
				"Shiva", containsElement(names, "Shiva"));

	}

	/**
	 * This method converts array into a list
	 * and then checks for a certain value exists in the list
	 * @param input
	 * @param object
	 * @return boolean
	 */
	private static <T> boolean isExists(final T[] input, final T object) {
		return Arrays.asList(input).contains(object);
	}
	
	/**
	 * This method loops through the array and checks
	 * if the value in the 2nd parameter is present in the array
	 * @param input
	 * @param object
	 * @return boolean
	 */
	private static <T> boolean containsElement(final T[] input, final T object) {
		for(final T eT : input) {
			if(eT == object || object != null && object.equals(eT)) {
				return true;
			}
		}
		
		return false;
	}

}
