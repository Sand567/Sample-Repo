package com.sandeep.other.goldmansachs;

public class SecondLargestElementBinaryTree {

    private Node root;

    SecondLargestElementBinaryTree() {
        this.root = null;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Counter {
        int count = 0;
    }

    public static void main(String[] args) {

        /*
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80
       */

        SecondLargestElementBinaryTree tree = new SecondLargestElementBinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.secondLargest(tree.root);
    }

    private void secondLargest(Node root) {
        Counter counter = new Counter();
        secondLargestUtil(root, counter);
    }

    private void secondLargestUtil(Node node, Counter counter) {

        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || counter.count >= 2) {
            return;
        }

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        secondLargestUtil(node.right, counter);

        // Increment count of visited nodes
        counter.count++;

        // If c becomes 2 now, then this is the 2nd largest
        if (counter.count == 2) {
            System.out.println("2nd largest element is: " + node.data);
            return;
        }

        secondLargestUtil(node.left, counter);
    }

    private void insert(int elem) {
        this.root = insertRecord(root, elem);
    }

    private Node insertRecord(Node node, int elem) {
        if (node == null) {
            this.root = new Node(elem);
            return this.root;
        }

        if (elem < node.data) {
            node.left = insertRecord(node.left, elem);
        } else {
            node.right =  insertRecord(node.right, elem);
        }

        return node;
    }
}
