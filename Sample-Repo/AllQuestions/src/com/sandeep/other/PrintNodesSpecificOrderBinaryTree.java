package com.sandeep.other;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class PrintNodesSpecificOrderBinaryTree {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        printNodesTopDown(root);

    }

    private static void printNodesTopDown(Node root) {

        // return if tree is empty
        if (root == null) {
            return;
        }

        // print root node
        System.out.print(root.key + " ");

        // create 2 empty queues and enqueue root's left and right child respectively
        Queue<Node> Q1 = new ArrayDeque<>();
        Queue<Node> Q2 = new ArrayDeque<>();

        Q1.add(root.left);
        Q2.add(root.right);

        // run until queue is not empty
        while (!Q1.isEmpty()) {

            // calculate number of nodes at the current level
            int n = Q1.size();

            // process every node at current level
            while (n > 0) {

                // pop front node from Q1 and print it
                Node x = Q1.poll();
                System.out.print(Objects.requireNonNull(x).key + " ");

                // push left and right child of x to Q1
                if (x.left != null) {
                    Q1.add(x.left);
                }

                if (x.right != null) {
                    Q1.add(x.right);
                }

                // pop front node from Q2 and print it
                Node y = Q2.poll();
                System.out.print(Objects.requireNonNull(y).key + " ");

                // push left and right child of y to Q2
                if (y.right != null) {
                    Q2.add(y.right);
                }

                if (y.left != null) {
                    Q2.add(y.left);
                }

                n--;
            }

        }

    }
}
