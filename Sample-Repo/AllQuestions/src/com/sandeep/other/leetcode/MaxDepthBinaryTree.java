package com.sandeep.other.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

 */
public class MaxDepthBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("The maximum depth of binary tree is (Recursive): " + maxDepth(root));
        System.out.println("The maximum depth of binary tree is (Iterative): " + maxDepthIterative(root));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    private static int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // create an empty queue and enqueue root nodes
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode front;
        int height = 0;

        // loop until queue isn't empty
        while (!queue.isEmpty()) {

            // calculate number of nodes at the current level
            int size = queue.size();

            // process each node at the current level and enqueue their
            // non-empty left and right child to queue
            while (size > 0) {
                front = queue.poll();

                if (front != null) {
                    if (front.left != null) {
                        queue.add(front.left);
                    }

                    if (front.right != null) {
                        queue.add(front.right);
                    }

                    size--;
                }
            }

            height++;
        }

        return height;

    }
}
