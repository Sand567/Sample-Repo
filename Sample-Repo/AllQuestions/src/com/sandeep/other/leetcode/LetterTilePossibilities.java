package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Letter Tile Possibilities
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.
 * Return the number of possible non-empty sequences of letters you can make.
 *
 * Example 1:
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * Example 2:
 * Input: "AAABBC"
 * Output: 188
 *
 * Note:
 * 1. 1 <= tiles.length <= 7
 * 2. tiles consists of uppercase English letters.
 * */
public class LetterTilePossibilities {

	public static void main(String[] args) {
		
		String tiles = "AAB";
		List<String> output = numTilePossibilities(tiles);
		output.forEach(out -> {
			System.out.println("\n"+out + " ");
		});

	}

	private static List<String> numTilePossibilities(String tiles) {
		
		char[] chars = tiles.toCharArray();
		System.out.println(Arrays.toString(chars));
		
		Arrays.sort(chars);
		boolean[] used = new boolean[chars.length];
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		dfs(chars, used, sb, result);
		return result;
		
	}

	private static void dfs(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
		
		if (sb.length() != 0) {
			result.add(sb.toString());
		}
		
		IntStream.range(0, chars.length)
				.filter(i -> !used[i])
				.filter(i -> i <= 0 || chars[i - 1] != chars[i] || used[i - 1])
				.forEach(i -> {
					System.out.print(i + " ");
					used[i] = true;
					sb.append(chars[i]);
					dfs(chars, used, sb, result);
					used[i] = false;
					sb.deleteCharAt(sb.length() - 1);
				});
		
		
		
	}

}
