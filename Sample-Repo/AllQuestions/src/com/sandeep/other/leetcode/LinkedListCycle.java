package com.sandeep.other.leetcode;

/*

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Follow up:

Can you solve it using O(1) (i.e. constant) memory?

 */
public class LinkedListCycle {

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

        LinkedListCycle cycle = new LinkedListCycle();
        cycle.add(3);
        cycle.add(2);
        cycle.add(0);
        cycle.add(-4);

        cycle.display(cycle.head);

        System.out.println("Does it have a cycle? " + hasCycle(cycle.head));
    }

    private static boolean hasCycle(Node head) {
        // the list would contain a cycle if
        // both the slow and fast pointer would
        // be the same value

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {

            System.out.println("slow: " + slow.val + ", fast: " + fast.val);

            // this means that fast has reached the end of the loop
            // and fast does not point back to any other node
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
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
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
    }
}
