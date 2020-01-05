import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Sharath Nagendra on 7/28/2017.
 */
public class ancestorTree {

    static int max=0;

    public static class Node {
        int data;
        Node left;
        Node right;


        public  Node(int data) {
            this.data = data;
            left =right =null;
        }
    }
//1 2 7 3 5 8 9 4 6 10

    public  static void findAncestor(Node root,int key) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null && root.data != key) {
                stack.push(root);
                root = root.left;
            }
            if (root != null && root.data == key)
                break;
            if (stack.peek().right == null) {
                root = stack.peek();
                stack.pop();


                while (stack.empty() == false && stack.peek().right == root) {
                    root = stack.peek();
                    stack.pop();
                }

            }

            root = stack.empty() ? null : stack.peek().right;
        }
        while( !stack.empty() )
        {
            System.out.print(stack.peek().data+" ");
            stack.pop();
        }
    }
    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);
        newNode.left.left.left = new Node(8);
        newNode.left.right.right = new Node(9);
        newNode.right.right.left = new Node(10);
        int key =9;
        findAncestor(newNode,key);
    }
}
