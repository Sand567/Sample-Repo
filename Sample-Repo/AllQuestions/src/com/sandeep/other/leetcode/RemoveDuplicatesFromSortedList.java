package com.sandeep.other.leetcode;

/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

 */
public class RemoveDuplicatesFromSortedList {

    private Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedList duplicates = new RemoveDuplicatesFromSortedList();
        duplicates.add(1);
        duplicates.add(1);
        duplicates.add(2);
        duplicates.add(3);
        duplicates.add(3);

        duplicates.display(duplicates.head);

        Node removed = deleteDuplicates(duplicates.head);

        duplicates.display(removed);

    }

    private static Node deleteDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


    private void add(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            Node newNode = new Node(val);
            current.next = newNode;
            newNode.next = null;
        }
    }

    private void display(Node node) {
        Node current = node;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("NULL");

        System.out.println();
    }
}
