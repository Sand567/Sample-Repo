package com.sandeep.other;

public class SecondSmallest {

	public static void main(String[] args) {
		
		int[] a = new int[] {35, 12, -15, 21, 3, -10, 12};
		
		int firstSmallest;
		int secondSmallest;
		
		if (a[0] > a[1]) {
			firstSmallest = a[1];
			secondSmallest = a[0];
		} else {
			firstSmallest = a[0];
			secondSmallest = a[1];
		}
		
		for (int i = 2; i < a.length; i++) {
			
			if (a[i] < firstSmallest) {
				secondSmallest = firstSmallest;
				firstSmallest = a[i];
			} else if (a[i] > firstSmallest && a[i] < secondSmallest) {
				secondSmallest = a[i];
			}
			
		}
		
		System.out.println("First Smallest: " + firstSmallest);
		System.out.println("Second Smallest: " + secondSmallest);


	}

}
