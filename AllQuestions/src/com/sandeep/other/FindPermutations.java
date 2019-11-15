package com.sandeep.other;

import java.util.ArrayList;
import java.util.List;

public class FindPermutations {

	public static void main(String[] args) {
		
        int[] arr = {1, 2, 3};
//        System.out.println(permute(arr));
        
        String input = "geek";
        printPermutations(input, "");
        System.out.println();
        printDistinctPermutations(input, "");
		
	}

	private static void printDistinctPermutations(String input, String result) {
		
		// If string is empty 
		if (input.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		
		System.out.println();
		
        // Make a boolean array of size '26' which 
        // stores false by default and make true  
        // at the position which alphabet is being 
        // used 
        boolean alpha[] = new boolean[26];
        
        for (int i = 0; i < input.length(); i++) {
        	
			// ith character of str 
			char ch = input.charAt(i);
			
            // Rest of the string after excluding  
            // the ith character 
			String rest = input.substring(0, i) + input.substring(i+1);
			
			boolean isUsed = alpha[ch - 'a'];
			
            // If the character has not been used  
            // then recursive call will take place.  
            // Otherwise, there will be no recursive 
            // call 
			if (!isUsed) {
				printDistinctPermutations(rest, result + ch);
			} 
			
			alpha[ch - 'a'] = true; 
        	
        }
		
	}

	private static void printPermutations(String input, String result) {
		
		// If string is empty 
		if (input.length() == 0) {
			System.out.print(result + " ");
			return;
		}
		
		for (int i = 0; i < input.length(); i++) {
			
			// ith character of str 
			char ch = input.charAt(i);
			
            // Rest of the string after excluding  
            // the ith character 
			String rest = input.substring(0, i) + input.substring(i+1);
			
			printPermutations(rest, result + ch);
		}
		
	}

	private static List<List<Integer>> permute(int[] arr) {
		
		List<List<Integer>> results = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return results;
		}
		
		List<Integer> result = new ArrayList<>();
		find(arr, results, result);
		return results;
		
	}

	private static void find(int[] arr, List<List<Integer>> results, List<Integer> result) {
		
		if (arr.length == result.size()) {
			List<Integer> temp = new ArrayList<>(result);
			results.add(temp);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!result.contains(arr[i])) {
				result.add(arr[i]);
				find(arr, results, result);
				result.remove(result.size() - 1);
			}
		}
		
	}

}
