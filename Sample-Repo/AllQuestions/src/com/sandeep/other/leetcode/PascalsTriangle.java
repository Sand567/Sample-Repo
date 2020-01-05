package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/*

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // if numRows is 0 just return the triangle
        if (numRows == 0) {
            return triangle;
        }

        // we know the first row always begins with a 1, so add 1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        // add the firstRow to triangle
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {

            // get the previous row of the current row
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // we are adding 1 because we know each row
            // begin with a 1
            currentRow.add(1);

            // we are looping until because i represent
            // in a triangle
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            // we also know that each ends with a 1
            // so add 1 at the end of each row
            currentRow.add(1);

            // finally add the currentRow to the triangle
            triangle.add(currentRow);
        }

        return triangle;
    }
}
