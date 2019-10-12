package com.sandeep.other;

import java.util.Stack;

public class AncestorTree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
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
		root.left.right.right = new Node(9);
		root.right.right.left = new Node(10);
		
		int key = 9;
		findAncestor(root, key);
	}

	private static void findAncestor(Node root, int key) {
		
		Stack<Node> stack = new Stack<>();
		
		if (root == null) {
			return;
		}
		
		while (true) {
			while (root != null && root.data != key) {
				stack.push(root);
				root = root.left;
			}
			
			if (root != null && root.data == key) {
				break;
			}
			
			if (stack.peek().right == null) {
				root = stack.peek();
				stack.pop();
				
				while (!stack.empty() && stack.peek().right == root) {
					root = stack.peek();
					stack.pop();
				}
			}
			
			root = stack.empty() ? null : stack.peek().right;
		}
		
		while (!stack.empty()) {
			System.out.print(stack.peek().data + " ");
			stack.pop();
		}
		
	}
}
