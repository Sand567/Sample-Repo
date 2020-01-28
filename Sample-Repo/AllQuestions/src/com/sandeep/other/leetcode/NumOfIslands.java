package com.sandeep.other.leetcode;

import java.util.Arrays;

/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
assume all four edges of the grid are all surrounded by water.

Example 1:

Input:

11110
11010
11000
00000

Output: 1

Example 2:

Input:

11000
11000
00100
00011

Output: 3

 */
public class NumOfIslands {
    public static void main(String[] args) {

//        char[][] grid = new char[][] {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };

        char[][] grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + numIslands(grid));

    }

    private static int numIslands(char[][] grid) {

        // to keep track of number of islands
        int count = 0;

        // loop through the 2D array and increment the count
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }

        System.out.println("grid after update: " + Arrays.deepToString(grid));

        return count;
    }

    private static void callBFS(char[][] grid, int i, int j) {

        // checking for boundary cases, if found just return out of the method
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        // element below
        callBFS(grid, i + 1, j);
        // element above
        callBFS(grid, i - 1, j);
        // element to the left
        callBFS(grid, i, j - 1);
        // element to the right
        callBFS(grid, i, j + 1);

    }
}
