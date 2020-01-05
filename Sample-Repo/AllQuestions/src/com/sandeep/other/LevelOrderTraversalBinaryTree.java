package com.sandeep.other;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
	
	private Node root;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		
		LevelOrderTraversalBinaryTree tree = new LevelOrderTraversalBinaryTree();
		tree.root = new Node(1); 
		tree.root.right = new Node(2); 
		tree.root.right.right = new Node(5); 
		tree.root.right.right.right = new Node(6);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.left.right = new Node(4);
		
		System.out.println("Level order traversal of a binary tree");
		tree.levelOrderTraversal();
		
	}
	
	private void levelOrderTraversal() {
		
		if (root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			Node current = queue.poll();
			System.out.print(current.data + " ");
			
			if (current.left != null) {
				queue.add(current.left);
			}
			
			if (current.right != null) {
				queue.add(current.right);
			}
			
		}
		
	}

}
