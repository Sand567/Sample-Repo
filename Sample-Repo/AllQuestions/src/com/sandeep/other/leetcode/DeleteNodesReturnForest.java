package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:

                1
              /   \
             2     3
           /   \ /   \
          4    5 6    7

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.

 */
public class DeleteNodesReturnForest {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3, 5};

        System.out.println(deleteNodes(root, to_delete));
    }

    private static List<TreeNode> deleteNodes(TreeNode root, int[] to_delete) {

        // this will hold the final result list
        List<TreeNode> remaining = new ArrayList<>();

        // to hold the elements of to_delete as a set
        Set<Integer> toDelete = new HashSet<>();

        for (int i : to_delete) {
            toDelete.add(i);
        }

        removeNodes(root, toDelete, remaining);

        // once we return from the recursive method we would be at the root
        // now we check if root is one of the
        // elements in toDelete HashSet
        // if it is not then add root also to remaining
        // else just return the elements without the root
        if (!toDelete.contains(root.val)) {
            remaining.add(root);
        }

        return remaining;
    }

    private static TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
        if (root == null) {
            return null;
        }

        // we use DFS to move down the tree
        // even below leaf nodes and we return null the first time
        // same thing happens for both the left and right subtree
        root.left = removeNodes(root.left, toDelete, remaining);
        root.right = removeNodes(root.right, toDelete, remaining);

        // this is to check if the node that is
        // in the toDelete has a left or right child
        if (toDelete.contains(root.val)) {

            // if left is not null then
            // add it to remaining
            if (root.left != null) {
                remaining.add(root.left);
            }

            // if right is not null then
            // add it to remaining
            if (root.right != null) {
                remaining.add(root.right);
            }

            // else return null
            // which is like removing a node
            return null;
        }

        // finally return root
        return root;
    }
}
