package com.sandeep.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFromRootToNode {
	
	static class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);
        
        printPath(root, 7);

	}

	private static void printPath(Node node, int key) {
		
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		if (hasPath(node, key, list)) {
			Collections.reverse(list);
			System.out.println("Final list");
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
				System.out.print(list.get(i) + " ");
			}
		}
		
		System.out.println();
		System.out.println("sum: " + sum);
		
	}

	private static boolean hasPath(Node node, int key, List<Integer> list) {
		
		if (node == null) {
			return false;
		}
		
		if (node.data == key || hasPath(node.left, key, list) || hasPath(node.right, key, list)) {
			list.add(node.data);
			return true;
		}
		
		return false;
		
	}

}
