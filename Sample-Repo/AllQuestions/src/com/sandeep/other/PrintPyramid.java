package com.sandeep.other;

public class PrintPyramid {

	public static void main(String[] args) {
		
		int numOfRows = 9;
		int rowCount = 1;
		
		pyramidPattern1(numOfRows, rowCount);
		pyramidPattern2(numOfRows, rowCount);
		pyramidPattern3(numOfRows, rowCount);
		pyramidPattern4(numOfRows, rowCount);
		pyramidPattern5(numOfRows, rowCount);

	}

	private static void pyramidPattern5(int numOfRows, int rowCount) {
		
		int rowCountNew = numOfRows;

		for (int i = 1; i <= numOfRows; i++) {
			
			// displaying double the spaces
			for (int j = 0; j < i * 2; j++) {
				System.out.print(" ");
			}
			
			// counting from 0 to rowCount
			for (int j = 0; j < rowCountNew; j++) {
				System.out.print((j+1) + " ");
			}
			
			// counting from rowCount-1 to 0
			for (int j = rowCountNew-1; j > 0; j--) {
				System.out.print((j) + " ");
			}
			
			System.out.println();
			
			rowCountNew--;
			
		}
		
		System.out.println();
		
	}

	private static void pyramidPattern4(int numOfRows, int rowCount) {
		
		for (int i = numOfRows; i > 0; i--) {
			
			// displaying double the spaces
			for (int j = 0; j < i * 2; j++) {
				System.out.print(" ");
			}
			
			// counting from 0 to rowCount
			for (int j = 0; j < rowCount; j++) {
				System.out.print((j+1) + " ");
			}
			
			// counting from rowCount-1 to 0
			for (int j = rowCount-1; j > 0; j--) {
				System.out.print((j) + " ");
			}
			
			System.out.println();
			
			rowCount++;
			
		}
		
		System.out.println();
		
	}

	private static void pyramidPattern3(int numOfRows, int rowCount) {
		
		for (int i = numOfRows; i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < rowCount; j++) {
				System.out.print("* ");
			}
			
			System.out.println();
			
			rowCount++;
			
		}
		
		System.out.println();
		
	}

	private static void pyramidPattern2(int numOfRows, int rowCount) {
		
		for (int i = numOfRows; i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < rowCount; j++) {
				System.out.print((j+1) + " ");
			}
			
			System.out.println();
			
			rowCount++;
			
		}
		
		System.out.println();
		
	}

	private static void pyramidPattern1(int numOfRows, int rowCount) {
		
		for (int i = numOfRows; i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < rowCount; j++) {
				System.out.print(rowCount + " ");
			}
			
			System.out.println();
			rowCount++;
			
		}
		
		System.out.println();
		
	}

}
