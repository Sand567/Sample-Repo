package AllQuestions.src.com.sandeep.other.leetcode;

/*

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 */
public class ReverseLinkedListII {

    private Node head;

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListII list = new ReverseLinkedListII();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.display(list.head);
        int m = 2;
        int n = 4;

        Node node = list.reverseListBetween(list.head, m, n);
        System.out.println();
        list.display(node);
    }

    private Node reverseListBetween(Node head, int m, int n) {
        Node previous = null;
        Node current = head;

        // this is to get the starting point "m" inclusive
        // from where the reversal should begin
        while (m > 1) {

            // keep updating the previous pointer
            // to have a reference to the previous node
            // for the current pointer
            // current would be pointing to the position where the reversal should being
            previous = current;
            current = current.next;
            // decrement m and n to find the right
            // begin and the end position
            m--;
            n--;
        }

        // this is to make the final connection
        // at the beginning after the reversal is complete
        Node connection = previous;

        // this pointer is to make the connection
        // at the end after the reversal is complete
        Node tail = current;

        // this is to do the reversal until we reach the
        // position "n" which is the end position inclusive, of the reversal
        while (n > 0) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            n--;
        }

        // this is to set the connection
        if (connection != null) {
            // if m is not at the beginning of the list
            // set connection's next to previous
            connection.next = previous;
        } else {
            // else if m is at the beginning of the list
            // set head to where previous is pointing
            head = previous;
        }

        // this is to finally make the connection
        // at the end from nth position to its next node
        tail.next = current;
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

        System.out.println("NULL");
    }
}
