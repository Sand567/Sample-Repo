/**
 * Created by Sharath Nagendra on 7/19/2017.
 */

public class BSTtoArray {

    static int[] res = {};
    static Node root;

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

    BSTtoArray() {
        root = null;
    }


    public static int[] extractValues(Node node) {
        int res[] = new int[50];
        if (node == null)
            return null;
        else if (node != null) {
            extractValues(node.left);
            for (int i = 0; i < res.length; i++)
                res[i] = node.data;
            extractValues(node.right);
        }
        return res;
    }


    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(10);
        node.right = new Node(30);
        node.left.left = new Node(5);
        node.left.right = new Node(15);
        int x[] = extractValues(node);

        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);

    }

}
