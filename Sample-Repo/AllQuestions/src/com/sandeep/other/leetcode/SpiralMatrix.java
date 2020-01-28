package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]

Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> output = new ArrayList<>(spiralOrder(matrix));
        System.out.println(output);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // this is to move from first column to last column
            // this will happen for every row starting from beginning
            for (int i = columnBegin; i <= columnEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            // this is move from first row to the last row
            // this will happen for every column starting from the end
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            // we make this check to verify
            // even after we modified rowBegin and columnEnd
            // rowBegin is still <= rowEnd
            if (rowBegin <= rowEnd) {

                // this is to move from last column to first column
                // this will happen for every row beginning from the last row
                for (int i = columnEnd; i >= columnBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            // we make this check to verify
            // even after we modified rowBegin and columnEnd
            // columnBegin is still <= columnEnd
            if (columnBegin <= columnEnd) {

                // this is to move from last row to first row
                // this will happen for every column beginning from the first column
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][columnBegin]);
                }
            }

            columnBegin++;
        }

        return result;
    }
}
