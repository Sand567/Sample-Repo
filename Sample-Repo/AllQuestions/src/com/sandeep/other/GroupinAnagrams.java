package com.sandeep.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupinAnagrams {

	public static void main(String[] args) {
        String[] input ={"cheating","teaching","dale","alde","c"};
        System.out.println(groupAnagrams(input));
	}

	private static List<List<String>> groupAnagrams(String[] input) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for (String str : input) {
			
			char[] arr = new char[26];
			
			for (int i = 0; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				System.out.println("index: " + index);
				arr[index]++;
			}
			
			System.out.println("arr: " + Arrays.toString(arr));
			
		}
		
		return result;
		
	}

}
