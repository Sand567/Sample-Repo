package com.sandeep.other.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row
 * and column to 0. Do it in place.
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		
		int[][] matrix = {{0, 8, 7}, {9, 0, 8}, {9, 9, 8}};
		setZeroes(matrix);

	}

	private static void setZeroes(int[][] matrix) {
		
		System.out.println("Original");
		System.out.println(Arrays.deepToString(matrix));
		
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		System.out.println();
		System.out.println("rows");
		rows.forEach(System.out::println);
		
		System.out.println();
		System.out.println("cols");
		cols.forEach(System.out::println);
		
		for (int r : rows) {
			for (int j = 0; j < n; j++) {
				matrix[r][j] = 0;
			}
		}
		
		for (int c : cols) {
			for (int j = 0; j < m; j++) {
				matrix[j][c] = 0;
			}
		}
		
		System.out.println();
		System.out.println("After update");
		System.out.println(Arrays.deepToString(matrix));
		
	}

}
