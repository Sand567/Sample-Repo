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
		
		int[][] matrix = {{15, 19, -1, 0, 20}, {10, 21, 16, 49, 52}, {90, -70, -2, -5, -7}, {11, 10, -50, 0 , -40}};
		setZeroes(matrix);
		setZeroesMethod2(matrix);

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

	private static void setZeroesMethod2(int[][] matrix) {

		boolean firstColZero = false;
		boolean firstRowZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstColZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		if (firstRowZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		System.out.println(Arrays.deepToString(matrix));

	}

}
