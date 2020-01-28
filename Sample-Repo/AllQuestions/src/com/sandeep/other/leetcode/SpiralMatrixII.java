package com.sandeep.other.leetcode;

import java.util.Arrays;

/*

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);

        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    private static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n - 1;
        int columnBegin = 0;
        int columnEnd = n - 1;
        int counter = 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // this is to move from first column to last column
            // this will happen for every row starting from rowBegin
            for (int i = columnBegin; i <= columnEnd; i++) {
                matrix[rowBegin][i] = counter++;
            }

            rowBegin++;

            // this is move from first row to the last row
            // this will happen for every column starting from columnEnd
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][columnEnd] = counter++;
            }

            columnEnd--;

            // we make this check to verify
            // even after we modified rowBegin and columnEnd
            // rowBegin is still <= rowEnd
            if (rowBegin <= rowEnd) {

                // this is to move from last column to first column
                // this will happen for every row beginning from rowEnd
                for (int i = columnEnd; i >= columnBegin; i--) {
                    matrix[rowEnd][i] = counter++;
                }
            }

            rowEnd--;

            // we make this check to verify
            // even after we modified rowBegin and columnEnd
            // columnBegin is still <= columnEnd
            if (columnBegin <= columnEnd) {

                // this is to move from last row to first row
                // this will happen for every column beginning from columnBegin
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][columnBegin] = counter++;
                }
            }

            columnBegin++;
        }

        return matrix;
    }
}
