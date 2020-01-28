package com.sandeep.other.leetcode;

/*

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

 */
public class PalindromeLinkedList {

    private Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);

        list.display(list.head);

        boolean palindrome = isPalindrome(list.head);
        System.out.println("palindrome ? " + palindrome);
    }

    private static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        // we keep moving "fast" pointer twice as fast
        // as the "slow" pointer
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // we just reverse the second half
        // of the linked list
        // but "slow" pointer will still stay at the mid of the list
        // and fast will begin from head
        slow = reverseList(slow);
        fast = head;

        // now if the elements in a linked list is a palindrome
        // both the slow and fast pointers will begin with the same number
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }

            // as long as both the elements at the slow and
            // fast pointers are the same, keep incrementing the pointers
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static Node reverseList(Node head) {
        Node previous = null;

        while (head != null) {

            // this will save the head's next element in a variable next
            Node next = head.next;

            // now we set previous as head's next element
            head.next = previous;

            // now assign the current head to previous
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
