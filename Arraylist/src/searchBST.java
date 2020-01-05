/**
 * Created by Sharath Nagendra on 8/24/2017.
 */
public class searchBST {

    static Node root;

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

    public static boolean contains(Node node, int value)
    {

        if(node==null)
            return false;
        if(node.data == value)
            return true;


        else
        {
            if(value<node.data) {
                return contains(node.left, value);

            }

            else if(value>node.data) {
                return contains(node.right, value);

            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        System.out.println(contains(node,4));

    }

}
