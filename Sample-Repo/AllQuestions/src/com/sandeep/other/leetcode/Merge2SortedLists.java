package com.sandeep.other.leetcode;

import java.util.function.Consumer;

public class Merge2SortedLists {
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		
		Merge2SortedLists merge2SortedLists = new Merge2SortedLists();
		
		Node head1 = new Node(40);
		head1.next = new Node(60);
		head1.next.next = new Node(70);
		head1.next.next.next = new Node(80);
		head1.next.next.next.next = new Node(100);
		head1.next.next.next.next.next = new Node(120);
		
		Node head2 = new Node(20);
		head2.next = new Node(30);
		head2.next.next = new Node(50);
		head2.next.next.next = new Node(60);
		
		printList(head1, System.out::println, false);
		System.out.println();
		printList(head2, System.out::println, false);
		
		mergeTwoLists(head1, head2);
	}

	private static void mergeTwoLists(Node head1, Node head2) {
		
		Node h1 = head1;
		Node h2 = head2;
		
		Node fakeHead = new Node(0);
		Node pNode = fakeHead;
		
		while (h1 != null && h2 != null) {
			
			if (h1.data <= h2.data) {
				pNode.next = h1;
				h1 = h1.next;
			} else {
				pNode.next = h2;
				h2 = h2.next;
			}
			
			pNode = pNode.next;
		}

		// if there are elements remaining
		// in list pointed by h1
		while (h1 != null) {
			pNode = h1;
			h1 = h1.next;
		}

		while (h2 != null) {
			// if there are elements remaining
			// in list pointed by h2
			pNode = h2;
			h2 = h2.next;
		}
		
		System.out.println();
		System.out.println("Final list");
		printList(fakeHead, System.out::println, true);
		
	}

	private static void printList(Node head, Consumer<Integer> consumer, boolean finalList) {
		
		Node temp = head;
		
		if (!finalList) {
			while (temp != null) {
				consumer.accept(temp.data);
				temp = temp.next;
			}
		} else {
			temp = head.next;
			while (temp != null) {
				consumer.accept(temp.data);
				temp = temp.next;
			}
		}
		
	}

}
