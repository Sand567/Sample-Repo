package com.sandeep.other;

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
        
        System.out.println("heightOfTree: " + heightOfTree(node));
        System.out.println("path: " + path(node));
        
	}
	
	private static int heightOfTree(Node root) {
		
		if (root == null) {
			return 0;
		}
		
		return (1 + Math.max(heightOfTree(root.left), heightOfTree(root.right)));
		
	}
	
	private static int path(Node root) {
		
		if (root == null) {
			return 0;
		}
		
		int left = path(root.left);
		int right = path(root.right);
		
		return Math.max(left, right) + 1;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
