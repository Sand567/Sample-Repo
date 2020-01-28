package com.sandeep.other;

public class SecondLargest {

	public static void main(String[] args) {
		
		int[] a = new int[] {35, 12, -15, 21, 3, -10, 12};
		
		int firstLargest;
		int secondLargest;
		
		if (a[0] > a[1]) {
			firstLargest = a[0];
			secondLargest = a[1];
		} else {
			firstLargest = a[1];
			secondLargest = a[0];
		}
		
		for (int i = 2; i < a.length; i++) {
			
			if (a[i] > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = a[i];
			} else if (a[i] < firstLargest && a[i] > secondLargest) {
				secondLargest = a[i];
			}
			
		}
		
		System.out.println("First Largest: " + firstLargest);
		System.out.println("Second Largest: " + secondLargest);

	}

}
