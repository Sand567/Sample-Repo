package com.sandeep.other.leetcode;

/*

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */
public class SortList {

    private ListNode head;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        SortList list = new SortList();
        list.add(-1);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(0);

        list.display(list.head);

        ListNode result = sortList(list.head);

        list.display(result);

        System.out.println();

        list = new SortList();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);

        list.display(list.head);

        result = sortList(list.head);

        list.display(result);
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // this is the end of the left sub list
        ListNode temp = head;

        // this would be the head of the right sub list
        ListNode slow = head;

        // this would be the end of the right sub list
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // By the time the above loop completes
        // slow would be at the middle of the list
        // and fast would be the end of list

        // just setting the end of the left sub list to point to null
        temp.next = null;

        // now we make recursive calls to merge sort the list
        ListNode leftSubList = sortList(head);
        ListNode rightSubList = sortList(slow);

        // this will merge the left and right sub lists
        return merge(leftSubList, rightSubList);
    }

    private static ListNode merge(ListNode leftSubList, ListNode rightSubList) {

        // this is the node before head
        ListNode sorted = new ListNode(0);
        ListNode current = sorted;

        // this is to check if both lists exist
        while (leftSubList != null && rightSubList != null) {

            if (leftSubList.val < rightSubList.val) {
                current.next = leftSubList;
                leftSubList = leftSubList.next;
            } else {
                current.next = rightSubList;
                rightSubList = rightSubList.next;
            }

            current = current.next;
        }

        // this is to check if only left sub list exist
        if (leftSubList != null) {
            current.next = leftSubList;
            leftSubList = leftSubList.next;
        }

        // this is to check if only right sub list exist
        if (rightSubList != null) {
            current.next = rightSubList;
            rightSubList = rightSubList.next;
        }

        // this will return the head of the sorted list
        return sorted.next;
    }

    private void add(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }

            ListNode newNode = new ListNode(val);
            current.next = newNode;
            newNode.next = null;
        }
    }

    private void display(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
}
