package com.sandeep.other.leetcode;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.

 */
public class Add2NumbersInLinkedList {

    private Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Add2NumbersInLinkedList list1 = new Add2NumbersInLinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        list1.add(7);

        Add2NumbersInLinkedList list2 = new Add2NumbersInLinkedList();
        list2.add(5);
        list2.add(6);
        list2.add(4);

        list1.display(list1.head);
        list2.display(list2.head);
        System.out.println();

        Add2NumbersInLinkedList result = new Add2NumbersInLinkedList();
        result.display(addTwoNumbers(list1.head, list2.head));
    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node l3 = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            System.out.println("l1Val: " + l1Val + ", l2Val: " + l2Val);
            int currentSum = l1Val + l2Val + carry;

            System.out.println("currentSum: " + currentSum);
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            System.out.println("carry: " + carry + ", lasDigit: " + lastDigit);
            System.out.println();

            Node newNode = new Node(lastDigit);
            l3.next = newNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            l3 = l3.next;
        }

        if (carry > 0) {
            Node carryOverNode = new Node(carry);
            l3.next = carryOverNode;
            l3 = l3.next;
        }

        return dummyHead.next;
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
