package com.sandeep.other.leetcode;

/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class ReverseLinkedList {

    private Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.display(list.head);

        Node node = list.reverseList(list.head);
        System.out.println();
        list.display(node);
    }

    private Node reverseList(Node head) {
        Node previous = null;

        while (head != null) {

            // this will save the head's next element in a variable next
            Node next = head.next;

            // now we set previous as head's next element
            head.next = previous;

            // now make the previous point to same place
            // where head is pointing to
            previous = head;

            // finally move the head pointer to the next element
            head = next;
        }

        return previous;
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

        System.out.println("NULL");
    }
}
