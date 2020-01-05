import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Sharath Nagendra on 7/6/2017.
 */

//reverse a linkedlist

public class linkedList_middleElement {


    static Node head; // head of linked list

    /* Linked list node */
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to print middle of linked list */
    static void printMiddle() {
        if (head == null)
            throw new NullPointerException();

        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }


    public static Node removeNode(Node head, int key) {
        Node helper = new Node(0);
        helper.next = head;
        Node p = helper;

        while (p.next != null) {
            if (p.next.data == key) {
//                Node next = p.next;
//                p.next = next.next;
                p.next = p.next.next;
                p = p.next;
            } else {
                p = p.next;
            }
        }

        return helper.next;
    }

    public static void removeNodeEfficientWithPosition(int key) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
            // Changed head

        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;


        // Unlink the node from linked list
        prev.next = temp.next;
    }


    /* Inserts a new Node at front of the list. */
    public static void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                Put in the data*/
        Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
        new_node.next = head;

		/* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* This function prints contents of linked list
    starting from the given node */
    public static void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static Node reverseLinkedList(Node node) {

        if (node == null)
            return null;
        if (node.next == null)
            return node;
        Node preNode = null;

        Node nextNode;
        while (head.next != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;

    }

    public static Node detectLoop(Node node) {

        Node slowptr = node;
        Node fastptr = node;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (fastptr == slowptr) {
                slowptr = node;
                while (slowptr != fastptr) {
                    slowptr = slowptr.next;
                    fastptr = fastptr.next;
                }
                return slowptr;
            }
        }

        return null;
    }

    static boolean isListPalindrome(Node l) {
        if (l == null)
            return false;
        Node cur = l;

        Node prevNode = null;
        Node nextNode = null;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = prevNode;
            prevNode = cur;
            cur = nextNode;
        }
        // System.out.println(prevNode.data);
        Node newcur = l;
        while (prevNode != null) {
            if (prevNode.data != newcur.data) {
                return false;
            }
            prevNode = prevNode.next;
            newcur = newcur.next;
        }
        return true;
    }

    static void removeDups(Node node) {
        if (node == null)
            return;
        Node cur = node;
        Node nextNode;

        while (cur.next != null) {
            if (cur.data == cur.next.data) {
                nextNode = cur.next.next;
                cur.next = null;
                cur.next = nextNode;
            } else
                cur = cur.next;
        }

    }

    //delete duplicates from an unsorted linkedlist
    static void removeDuplicate(Node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }

    //delete duplicates including the element
    public static Node deleteDuplicates(Node A) {


        Node helper = new Node(0);
        helper.next = A;
        Node p = helper;

        while (p.next != null && p.next.next != null) {
            if (p.next.data == p.next.next.data) {
                int dup = p.next.data;
                while (p.next != null && p.next.data == dup) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }

        }

        return helper.next;
    }

    //only delete additional duplicates, retains the actual element
    static Node deldup(Node node) {

        if (node == null)
            return null;
        Node cur = node;
        while (cur.next != null) {
            if (cur.data == cur.next.data) {
                cur.next = cur.next.next;
                //cur = cur.next;
            } else
                cur = cur.next;
        }

        return node;

    }


    public static Node swapPairs(Node A) {

        Node cur = A;
        while (cur != null && cur.next != null) {
            int temp = cur.data;
            cur.data = cur.next.data;
            cur.next.data = temp;
            cur = cur.next.next;
        }
        return A;
    }

    static Node reverseKPairs(Node node, int k) {

        Node cur = node;
        Node nextNode = null;
        Node preNode = null;
        int times = 0;
        while (cur != null && times < k) {
            nextNode = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = nextNode;
            times++;
        }
        if (nextNode != null) {
            node.next = reverseKPairs(nextNode, k);


        }
        return preNode;

    }


    //7->14->21->14->22->7->null)
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
//        for (int i = 4; i > 0; --i) {
//            push(i);
        // printList();
        push(4);
        push(3);
        push(3);
        push(3);
        push(2);
        push(1);
//        push(1);


//Node res = swapPairs(head);
//        Node res = reverseKPairs(head,3);
//while(res!=null){
//    System.out.println(res.data);
//    res=res.next;

//        removeDups(head);
//        Node temp = head;
//        while(temp!=null){
//            System.out.println(temp.data);
//            temp=temp.next;
//        }
        //   printMiddle();

        //push()
        //  System.out.println("before call funct" + head.data);
        // reverseLinkedList(head);

//        System.out.println("Linkedlist before loop detection" );
//        Node cur = head;
//        while (cur!= null) {
//
//            System.out.println(cur.data);
//            cur=cur.next;
//
//        }
        //    System.out.println(isListPalindrome(head));

        //       Node res = deleteDuplicates(head);
        //      Node cur = res;
        //      while (cur != null)

        //    {
        //System.out.println(cur.data);
        //         cur = cur.next;
        //    }

      //  Node remNode = removeNode(head, 20);
      //  while (remNode != null)

       // {

            // System.out.println(remNode.data);
        //    remNode = remNode.next;

       // }

        Node newres = deldup(head);
        Node cur = newres;
        while(cur!=null)
        {
            System.out.println(cur.data);
            cur = cur.next;
        }

    }

    //        Node newNode= detectLoop(head);
//        System.out.println("Node at which the loop starts ");
//        Node newcur = newNode;
//        while (newcur!= null) {
//
//            System.out.println(newcur.data);
//            newcur=newcur.next;
//
//        }

}








