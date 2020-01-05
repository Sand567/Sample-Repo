package DataStructuresAndAlgorithms.src.com.sandeep.sorting.selectionSort;

import java.util.Arrays;

import com.sandeep.common.Helper;

/**
 * Selection Sort
 * Time Complexity: Quadratic => O(n^2)
 * Unstable Algorithm
 * In place algorithm
 */
public class SelectionSortDemo {

	public static void main(String[] args) {
		
		int[] intArray = {20, 35, -15, 7, 55, 1, -22};
		
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			
			int largestIndex = 0;
			
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[largestIndex]) {
					largestIndex = i;
				}
			}
			
			Helper.swap(intArray, largestIndex, lastUnsortedIndex);
			System.out.println("intArray: " + Arrays.toString(intArray));
		}
		
		System.out.println("\nSelection Sort");
		System.out.println("Final intArray: " + Arrays.toString(intArray));

	}
	
	/*	
	 	Sample Output:
	 	intArray: [20, -15, 7, 35, 1, -22, 55]
		intArray: [-15, 7, 20, 1, -22, 35, 55]
		intArray: [-15, 7, 1, -22, 20, 35, 55]
		intArray: [-15, 1, -22, 7, 20, 35, 55]
		intArray: [-15, -22, 1, 7, 20, 35, 55]
		intArray: [-22, -15, 1, 7, 20, 35, 55]
		
		Selection Sort
		Final intArray: [-22, -15, 1, 7, 20, 35, 55]
	 */

}
