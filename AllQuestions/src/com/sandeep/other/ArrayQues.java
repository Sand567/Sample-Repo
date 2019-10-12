package com.sandeep.other;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayQues {

	public static void main(String[] args) {
		
		findDuplicateElementInArray();
		System.out.println();
		
		findDuplicateElementInArrayHashSet();
		System.out.println();
		
		findSecondLargestElement();
		System.out.println();
		
		checkEqualityOfArrays();
		System.out.println();
		
	}
	
	/**
	 * This is a program to find duplicate elements in an array
	 */
	private static void findDuplicateElementInArray() {
		String [] strArray = {"Java", "JSP", "servlets", "java", "Struts", "JSP", "JDBC", "Servlets"};
		int [] intArray = {4, 5, 7, 2, 4, 1, 7};
		
		for(int i = 0; i < strArray.length-1; i++) {
			for(int j = i+1; j < strArray.length; j++) {
				if((strArray[i].equalsIgnoreCase(strArray[j])) && (i != j)) {
					System.out.println("Duplicate element is: " + strArray[i]);
				}
			}
		}
		
		for(int i = 0; i < intArray.length-1; i++) {
			for(int j = i+1; j < intArray.length; j++) {
				if((intArray[i] == intArray[j]) && (i != j)) {
					System.out.println("Duplicate element is: " + intArray[j]);
				}
			}
		}
	}
	
	/**
	 * This is a program to find duplicate elements in an array using HashSet
	 */
	private static void findDuplicateElementInArrayHashSet() {
		String [] strArray = {"Java", "JSP", "Servlets", "Java", "Struts", "JSP", "JDBC", "Servlets"};
		HashSet<String> stringSet = new HashSet<>();
		for(String s : strArray) {
			if(!stringSet.add(s)) {
				System.out.println("Duplicate: " + s);
			}
		}
	}
	
	/**
	 * This is a program to find the second largest element in an integer array
	 */
	private static void findSecondLargestElement() {
		
		int firstLargest;
		int secondLargest;
		int [] intArray = {47498, 14526, 74562, 42681, 75283, 45796};
		
		if(intArray[0] > intArray[1]) {
			firstLargest = intArray[0];
			secondLargest = intArray[1];
		} else {
			firstLargest = intArray[1];
			secondLargest = intArray[0];
		}
		
		for(int i = 2; i < intArray.length; i++) {
			
			if(intArray[i] > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = intArray[i];
			} else if(intArray[i] < firstLargest && intArray[i] > secondLargest) {
				secondLargest = intArray[i];
			}
		}
			
		System.out.println("Input Array:");
		System.out.println(Arrays.toString(intArray));
		System.out.println("Second Largest Element: ");
		System.out.println(secondLargest);
		
	}
	
	/**
	 * This program will check the equality of 2 arrays, iteratively
	 */
	private static void checkEqualityOfArrays() {
		
		int[] arr1 = {21, 57, 11, 34, 24};
		int[] arr2 = {21, 57, 11, 37, 24};
		boolean isEqual = true;
		
		if(arr1.length == arr2.length) {
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] != arr2[i]) {
					isEqual = false;
				}
			}
		} else {
			isEqual = false;
		}
		
		System.out.println("Input Arrays");
		System.out.println("First Array: " + Arrays.toString(arr1));
		System.out.println("Second Array: " + Arrays.toString(arr2));
		
		if(isEqual) {
			System.out.println("2 arrays are equal");
		} else {
			System.out.println("2 arrays are not equal");
		}
		
	}

}
