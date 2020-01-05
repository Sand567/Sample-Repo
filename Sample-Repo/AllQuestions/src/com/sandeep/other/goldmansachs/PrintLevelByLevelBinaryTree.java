package com.sandeep.other.goldmansachs;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelByLevelBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(40);
        root.left = new Node(90);
        root.right = new Node(10);
        root.left.left = new Node(60);
        root.left.right = new Node(20);
        root.right.right = new Node(70);

//        printLevelByLevelMethod1(root);
        printLevelByLevelMethod2(root);
    }

    private static void printLevelByLevelMethod1(Node root) {
        int height = height(root);

        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    private static void printLevelByLevelMethod2(Node root) {

        if (root == null) {
            return;
        }

        // Create an empty queue for level order tarversal
        Queue<Node> queue = new LinkedList<>();

        // Enqueue Root and initialize height
        queue.add(root);

        while (true) {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = queue.size();

            if (nodeCount == 0) {
                break;
            }

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {

                Node node = queue.peek();
                System.out.print((node != null ? node.data : "No node") + " ");
                queue.remove();

                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                nodeCount--;
            }

            System.out.println();
        }

    }

    private static void printGivenLevel(Node root, int level) {

        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }

    }

    private static int height(Node root) {

        if (root == null) {
            return 0;
        }

        return (1 + Math.max(height(root.left), height(root.right)));

    }
}
