/**
 * Created by Sharath Nagendra on 10/27/2017.
 */
public class mergeList {


    /**
     * Created by Sharath Nagendra on 7/6/2017.
     */

    static Node head1;
    static Node head2;// head of linked list

    /* Linked list node */
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;

        }
    }

        /* Function to print middle of linked list */
//        void printMiddle()
//        {
//            Node slow_ptr = head;
//            Node fast_ptr = head;
//            if (head != null)
//            {
//                while (fast_ptr != null && fast_ptr.next != null)
//                {
//                    fast_ptr = fast_ptr.next.next;
//                    slow_ptr = slow_ptr.next;
//                }
//                System.out.println("The middle element is [" +
//                        slow_ptr.data + "] \n");
//            }
//        }

    /* Inserts a new Node at front of the list. */
    public static void push(int new_data) {
        /* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
        new_node.next = head1;

		/* 4. Move the head to point to new Node */
        head1 = new_node;
    }


    public static void push2(int new_data) {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
        new_node.next = head2;

		/* 4. Move the head to point to new Node */
        head2 = new_node;
    }

        /* This function prints contents of linked list
        starting from the given node */


    public static Node mergethelists(Node node, Node node2) {

        if (node == null)
            return node2;
        if (node2 == null)
            return node;

        if (node.data < node2.data) {
            node.next = mergethelists(node.next, node2);
            return node;
        } else {
            node2.next = mergethelists(node2.next, node);
            return node2;
        }
    }

    public static void printL() {
        Node tnode = head1;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }


    public static void printL2() {
        Node tnode = head2;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void printRes(Node res) {
        Node tnode = res;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {


        // Node node = new Node(3);
        push(9);
        push(7);
        push(6);
        push(3);
        printL();
//           node.next=new Node(6);
//           node.next = new Node(7);
//           node.next = new Node(9);
//            printL(node);

        push2(8);
        push2(5);
        push2(2);
        push2(1);
        printL2();
        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next = new Node(5);
        node2.next = new Node(8);


        Node res = mergethelists(head1, head2);
        printRes(res);

        // llist.printList();
        //  llist.printMiddle();

    }
//3 6 7 9
// 1 2 5 8

}



