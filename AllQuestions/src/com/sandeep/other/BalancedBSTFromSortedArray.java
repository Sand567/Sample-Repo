package com.sandeep.other;

public class BalancedBSTFromSortedArray {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	private static Node root;

	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		int n = arr.length;
		
		root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST"); 
        preOrder(root);
	}

	private static Node sortedArrayToBST(int[] arr, int start, int end) {
		
		if (start > end) {
			return null;
		}
		
		// Get the middle element and make it root
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		
        // Recursively construct the left subtree and make it 
        // left child of root 
		node.left = sortedArrayToBST(arr, start, mid - 1);
		
        // Recursively construct the right subtree and make it 
        // right child of root 
		node.right = sortedArrayToBST(arr, mid + 1, end);
		
		return node;
		
	}
	
	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	

}
