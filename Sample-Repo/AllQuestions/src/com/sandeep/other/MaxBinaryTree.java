package com.sandeep.other;

public class MaxBinaryTree {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}

	public static void main(String[] args) {
		
		int arr[] = {3,2,1,6,5,0};
		
		System.out.println(maxBinaryTree(arr));

	}

	private static Node maxBinaryTree(int[] arr) {
		if (arr == null) {
			return null;
		}
		
		return build(arr, 0, arr.length - 1);
	}

	private static Node build(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		
		int maxIndex = start;
		for (int i = start + 1; i <= end; i++) {
			if (i > maxIndex) {
				maxIndex = i;
			}
		}
		
		Node newNode = new Node(arr[maxIndex]);
		
		newNode.left = build(arr, 0, (maxIndex - 1));
		newNode.right = build(arr, (maxIndex + 1), end);
		
		return newNode;
	}

}
