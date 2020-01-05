/**
 * Created by Sharath Nagendra on 8/27/2017.
 */
public class linkedlist2BST {

    static Node root;
    static ListNode h;
    static class Node {
        Node right;
        Node left;
        int data;

        public Node(int data) {
            right = null;
            left = null;
            this.data = data;
        }
    }

        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }

    public static void push(int new_data)
    {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        ListNode new_node = new ListNode(new_data);

		/* 3. Make next of new Node as head */
        new_node.next = h;

		/* 4. Move the head to point to new Node */
        h = new_node;
    }

    public static Node sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        h = head;
        int len = getLength(head);
        return list2bst(0, len - 1);
    }

    public static Node list2bst(int start, int end){
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        Node left = list2bst(start, mid - 1);
        Node root = new Node(h.val);
        h = h.next;
        Node right = list2bst(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

public static void inorder(Node node){
        if(node!=null){

            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
}


    public static void main(String[] args) {
//       ListNode listNode = new ListNode(7);
//       listNode.next = new ListNode(6);
//        listNode.next = new ListNode(5);
//        listNode.next = new ListNode(4);
//        listNode.next = new ListNode(3);
//        listNode.next = new ListNode(2);
//        listNode.next = new ListNode(1);
        ListNode listNode = new ListNode(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        System.out.println("Given Linked List ");
        //printList(root);
        inorder(sortedListToBST(listNode));
    }


//
//    static void push(int new_data)
//    {
//        /* allocate node */
//        Node new_node = new Node(new_data);
//
//        /* since we are adding at the begining,
//           prev is always NULL */
//        new_node.prev = null;
//
//        /* link the old list off the new node */
//        new_node.next = root;
//
//        /* change prev of head node to new node */
//        if (root != null)
//            root.prev = new_node;
//
//        /* move the head to point to the new node */
//        root = new_node;
//    }


//   public static void printList(Node node)
//    {
//        while (node != null)
//        {
//            System.out.print(node.data + " ");
//            node = node.next;
//        }
//    }


}
