package com.sandeep.countingSort;

import java.util.Arrays;

public class CountingSortDemo {

	public static void main(String[] args) {
		
		int[] input = {60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40};
		int k = 60;
		
		csort(input, k);

	}

	private static void csort(int[] input, int k) {
		
		System.out.println("Input array");
		System.out.println(Arrays.toString(input));
		
		int counter[] = new int[k + 1];
		
	    for (int i : input) {
	        counter[i] = counter[i] + 1;
	    }
	    
	    System.out.println(Arrays.toString(counter));
	    
	    int ndx = 0;
	    for (int i = 0; i < counter.length; i++) {
	    	while (0 < counter[i]) {
	    		input[ndx++] = i;
	    		counter[i] = counter[i] - 1;
	    	}
	    }
	    
	    System.out.println("input array after sort");
	    System.out.println(Arrays.toString(input));
		
	}

}
