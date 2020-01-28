package com.sandeep.other.leetcode;

import java.util.Arrays;

/*

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].

Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].

Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.

Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length

 */
public class FruitIntoBaskets {
    public static void main(String[] args) {

        int[][] setTrees = {
                {1, 2, 1},
                {0, 1, 2, 2},
                {1, 2, 3, 2, 2},
                {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
        };

        System.out.println("trees");
        System.out.println(Arrays.deepToString(setTrees));
        System.out.println();

        for (int[] trees : setTrees) {
            System.out.println("Longest possible length of the continuous sub array is " + totalFruits(trees));
            System.out.println();
        }

    }

    private static int totalFruits(int[] trees) {
        System.out.println("Current tree: " + Arrays.toString(trees));

        if (trees == null || trees.length <= 0) {
            return -1;
        }

        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currentMaximum = 0;
        int maximum = 0;

        for (Integer fruit : trees) {

            // when a fruit is not equal to last or the second last fruit
            // current maximum will be the maximum of the current
            // continuous sub sequence
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentMaximum += 1;
            } else {
                currentMaximum = lastFruitCount + 1;
            }

            // increment the count if it is the same fruit
            if (fruit == lastFruit) {
                lastFruitCount += 1;
            } else {

                // else begin from 1 and
                // continue the process
                lastFruitCount = 1;

                // second last will be the last fruit
                secondLastFruit = lastFruit;

                // current fruit will be the last fruit
                lastFruit = fruit;
            }

            // finally set the maximum
            maximum = Math.max(currentMaximum, maximum);
        }

        return maximum;
    }
}
