package com.sandeep.other;

import java.util.Arrays;
import java.util.Scanner;

public class Contacts {
	
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		
		int queryRows = Integer.parseInt(SCANNER.nextLine().trim());
		String[][] queries = new String[queryRows][2];
		
		for (int qRow = 0; qRow < queryRows; qRow++) {
			String[] queryRowItems = SCANNER.nextLine().split(" ");
			
			for (int qCol = 0; qCol < 2; qCol++) {
				String queryItem = queryRowItems[qCol];
				queries[qRow][qCol] = queryItem;
			}
		}
		
		SCANNER.close();
		
		System.out.println(Arrays.deepToString(queries));
		
		int[] result = contacts(queries);

	}

	private static int[] contacts(String[][] queries) {
		
		return null;
		
	}

}
