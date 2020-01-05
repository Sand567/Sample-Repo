/**
 * Created by Sharath Nagendra on 11/14/2017.
 */
public class treeLeftView {

    static int max_level = 0;

    public static class Node {
         int data;
         Node left;
         Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;

        }


    }



        // recursive function to print left view
        public static void leftViewUtil(Node node, int level) {
            // Base Case
            if (node == null) return;

           // System.out.println(node.data);
            // If this is the first node of its level
            if (max_level < level) {
                System.out.print(" " + node.data);
                max_level = level;
            }

            // Recur for left and right subtrees
            leftViewUtil(node.left, level + 1);
            leftViewUtil(node.right, level + 1);

        }

        // A wrapper over leftViewUtil()
       public static void leftView(Node node) {
            leftViewUtil(node, 1);
        }

        /* testing for example nodes */
        public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */

		Node node = new Node(3);
		node.left = new Node(1);
		node.right = new Node(5);
		node.left.left= new Node(0);
		node.left.right = new Node(2);
		node.right.left = new Node(4);
		node.right.right = new Node(6);
		leftView(node);
//            treeLeftView tree = new treeLeftView();
//            tree.root = new Node(12);
//            tree.root.left = new Node(10);
//            tree.root.right = new Node(30);
//            tree.root.right.left = new Node(25);
//            tree.root.right.right = new Node(40);
//
//            leftView(tree);

//
//
//
//    public static void leftViewUtil(Node node, int level){
//
//        if (node==null) return;
//
//        // If this is the first node of its level
//        if (max_level < level)
//        {
//            System.out.print(" " + node.data);
//            max_level = level;
//        }
//
//        // Recur for left and right subtrees
//        leftViewUtil(node.left, level+1);
//        leftViewUtil(node.right, level+1);
//
//        //return node;
//
//    }
//
//    public static void main(String[] args) {
//
//        Node node = new Node(12);
//        node.left = new Node(10);
//        node.right = new Node(30);
//        node.right.left = new Node(25);
//        node.right.right = new Node(40);
//
//
//        leftViewUtil(node,1);
//
//    }
    }
}
