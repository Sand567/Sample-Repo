package com.sandeep.other;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfATree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.left.left.left = new Node(0);
        
        System.out.println("heightOfTree (Recursive): " + heightOfTreeRecursive(node));
		System.out.println("heightOfTree (Iterative): " + heightOfTreeIterative(node));
        
	}
	
	private static int heightOfTreeRecursive(Node root) {
		
		if (root == null) {
			return 0;
		}
		
		return (1 + Math.max(heightOfTreeRecursive(root.left), heightOfTreeRecursive(root.right)));
		
	}

	private static int heightOfTreeIterative(Node root) {

		if (root == null) {
			return 0;
		}

		// create an empty queue and enqueue root nodes
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		Node front;
		int height = 0;

		// loop until queue isn't empty
		while (!queue.isEmpty()) {

			// calculate number of nodes at the current level
			int size = queue.size();

			// process each node at the current level ane enqueue their
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
