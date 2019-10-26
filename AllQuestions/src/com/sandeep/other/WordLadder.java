package com.sandeep.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		
		String start = "hit";
		String end = "cog";
		
		Set<String> input = new HashSet<>();
		
		input.add("log");
		input.add("lot");
		input.add("dog");
		input.add("dot");
		input.add("hot");
		
		System.out.println(ladderLength(input, start, end));

	}

	private static int ladderLength(Set<String> dict, String start, String end) {
		
		if (dict.size() == 0) {
			return 0;
		}
		
		dict.add(end);
		
		LinkedList<String> wordQueue = new LinkedList<>();
		LinkedList<Integer> distanceQueue = new LinkedList<>();
		
		wordQueue.add(start);
		distanceQueue.add(1);
		
		int result = Integer.MAX_VALUE;
		
		dict.forEach(System.out::println);
		System.out.println("==========================");
		
		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			
			System.out.println("currWord: " + currWord + ", currDistance: " + currDistance);
			
			if (currWord.equals(end)) {
				result = Math.min(result, currDistance);
			}
			
			for (int i = 0; i < currWord.length(); i++) {
				System.out.println("=========================");
				System.out.println("Iteration " + i);
				char[] currCharArr = currWord.toCharArray();
				System.out.println("currCharArr: " + Arrays.toString(currCharArr));
				
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					System.out.println("currCharArr[" + i + "]: " + currCharArr[i]);
					
					String newWord = new String(currCharArr);
					System.out.println("newWord: " + newWord);
					
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
				
				System.out.println("currCharArr after loop: " + Arrays.toString(currCharArr));
				System.out.println("=========================");
				
			}
			
		}
		
		System.out.println("wordQueue");
		wordQueue.forEach(System.out::println);
		System.out.println("=========================");
		System.out.println("distanceQueue");
		distanceQueue.forEach(System.out::println);
		System.out.println("=========================");
		System.out.println("dict");
		dict.forEach(System.out::println);
			
		
		if (result < Integer.MAX_VALUE) {
			return result;
		} else {
			return 0;
		}
		
	}

}
