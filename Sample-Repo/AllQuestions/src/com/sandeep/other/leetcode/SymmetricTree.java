package com.sandeep.other.leetcode;

/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.

 */
public class SymmetricTree {

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
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println("Is the tree symmetric? " + isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        // if both the subtrees are null then
        // just return the result of left and right subtrees equality
        if (left == null || right == null) {
            return left == right;
        }

        // we also need to is the value
        // is same or different. If different return false
        if (left.val != right.val) {
            return false;
        }

        // else we have to compare
        // left subtree's left child with right subtree's right child
        // and
        // left subtree's right child with right subtree's left child
        // finally return the result of their equality
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
