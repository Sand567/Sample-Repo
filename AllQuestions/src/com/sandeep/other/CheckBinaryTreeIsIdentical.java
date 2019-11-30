package com.sandeep.other;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckBinaryTreeIsIdentical {

    static class Node {
        int key;
        Node right;
        Node left;

        Node(int key) {
            this.key = key;
            right = left = null;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        // constructs new pair with specified values
        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        // factory method for creating a typed pair immutable instance
        public static <U, V> Pair<U, V> of(U a, V b) {
            return new Pair<>(a, b);
        }
    }

    public static void main(String[] args) {

        /*          15
                   /  \
                 10    20
                /  \  /  \
               8   1216   25
         */

        Node rootX = new Node(15);
        rootX.left = new Node(10);
        rootX.right = new Node(20);
        rootX.left.left = new Node(8);
        rootX.left.right = new Node(12);
        rootX.right.left = new Node(16);
        rootX.right.right = new Node(25);

        Node rootY = new Node(15);
        rootY.left = new Node(10);
        rootY.right = new Node(20);
        rootY.left.left = new Node(8);
        rootY.left.right = new Node(12);
        rootY.right.left = new Node(16);
        rootY.right.right = new Node(25);

        if (isIdenticalRecursive(rootX, rootY)) {
            System.out.println("(Recursive) Given binary trees are identical");
        } else {
            System.out.println("(Recursive) Given binary trees are not identical");
        }

        if (isIdenticalIterative(rootX, rootY)) {
            System.out.println("(Iterative) Given binary trees are identical");
        } else {
            System.out.println("(Iterative) Given binary trees are not identical");
        }

    }

    // Recursive method to check if 2 binary trees are identical
    private static boolean isIdenticalRecursive(Node x, Node z) {

        // if both trees are empty, return true
        if (x == null && z == null) {
            return true;
        }

        // if both the trees are non-empty and their root match
        // recursively check if its left and right subtrees match
        return (x != null && z != null) && (x.key == z.key) &&
                isIdenticalRecursive(x.left, z.left) &&
                isIdenticalRecursive(x.right, z.right);

    }

    // Iterative method to check if 2 binary trees are identical
    private static boolean isIdenticalIterative(Node x, Node z) {

        // if both trees are empty, return true
        if (x == null && z == null) {
            return true;
        }

        // if first tree is empty and second is not empty, return false
        if (x == null) {
            return false;
        }

        // if second tree is empty and first is not empty, return falses
        if (z == null) {
            return false;
        }

        // create a stack to hold Node pairs
        Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
        stack.add(new Pair<>(x, z));

        // loop until stack is empty
        while (!stack.isEmpty()) {

            // pop top pair from the stack and process it
            x = stack.peek().first;
            z = stack.peek().second;
            stack.poll();

            // if the value are root does not match return false
            if (x.key != z.key) {
                return false;
            }

            // if left subtree of both x and z exists, push their addresses
            // onto the stack, else return false only if one left child exists
            if (x.left != null && z.left != null) {
                stack.add(new Pair<>(x.left, z.left));
            } else if (x.left != null || z.left != null) {
                return false;
            }

            // if right subtree of both x and z exists, push their addresses
            // onto the stack, else return false only if one right child exists
            if (x.right != null && z.right != null) {
                stack.add(new Pair<>(x.right, z.right));
            } else if (x.right != null || z.right != null) {
                return false;
            }

        }

        // at this point both binary trees exist
        return true;

    }
}
