package com.sandeep.other;

public class FlattenLinkedList {
	
	private Node head;

	static class Node {
		int data;
		Node right;
		Node down;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		FlattenLinkedList list = new FlattenLinkedList();

		list.head = list.push(list.head, 30);
		list.head = list.push(list.head, 8);
		list.head = list.push(list.head, 7);
		list.head = list.push(list.head, 5);

		list.head.right = list.push(list.head.right, 20);
		list.head.right = list.push(list.head.right, 10);

		list.head.right.right = list.push(list.head.right.right, 50);
		list.head.right.right = list.push(list.head.right.right, 22);
		list.head.right.right = list.push(list.head.right.right, 19);

		list.head.right.right.right = list.push(list.head.right.right.right, 45);
		list.head.right.right.right = list.push(list.head.right.right.right, 40);
		list.head.right.right.right = list.push(list.head.right.right.right, 35);
		list.head.right.right.right = list.push(list.head.right.right.right, 30);

		list.head = list.flatten(list.head);
		list.printList();

	}

	private Node merge(Node a, Node b) {

		// if first linked list is empty then second
		// is the result
		if (a == null) {
			return b;
		}

		// if second linked list is empty then first
		// is the result
		if (b == null) {
			return a;
		}

		// compare the data members of the two linked lists
		// and sort them and put it into result
		Node result;

		if (a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(b.down, a);
		}

		return result;
	}

	private Node flatten(Node root) {

		if (root == null || root.right == null) {
			return root;
		}

		root.right = flatten(root.right);

		// merge lists
		root = merge(root, root.right);

		// return the root
		// it will be in turn merged with its left
		return root;

	}

	private Node push(Node head, int data) {

		Node node = new Node(data);
		node.down = head;
		head = node;
		return head;

	}

	private void printList() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
		System.out.println();

	}

}
