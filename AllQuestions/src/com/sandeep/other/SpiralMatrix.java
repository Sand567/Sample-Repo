package com.sandeep.other;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of columns: ");
		int cols = scanner.nextInt();
		
		int[][] matrix = new int[rows][cols];
		System.out.println("Enter the elements for each row and column");
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
			System.out.println("\n");
		}
		
		System.out.println(Arrays.deepToString(matrix));
		
		display(matrix, rows, cols);

	}

	private static void display(int[][] matrix, int rows, int cols) {
		
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        int dir = 0;
        
        while (top <= bottom && left <= right) {
        	
        	if (dir == 0) {
        		for (int i = top; i <= right; i++) {
        			System.out.println(matrix[top][i]);
        		}
        		
        		top++;
        	}
        	
        	dir = (dir + 1) % 4;
        	
        }
		
	}

}
