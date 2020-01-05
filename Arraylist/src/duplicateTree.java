import java.util.*;

/**
 * Created by Sharath Nagendra on 7/31/2017.
 */
public class duplicateTree {

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;

        }

        public static List<Node> checkDuplicate(Node node) {

            List<Node> mylist = new LinkedList<>();
            postOrder(node, new HashSet<>(), new HashSet<>(), mylist);
            return mylist;


        }

        public static String postOrder(Node node, Set<String> first, Set<String> second, List<Node> mylist) {

            if (node == null)
                return "#";
            String res = postOrder(node.left, first, second, mylist) + "," + postOrder(node.right, first, second, mylist) + "," + node.data;
            if (!first.add(res) && second.add(res)) {
                mylist.add(node);

            }
            return res;
        }


    }


    public static void main(String[] args) {
        duplicateTree tree = new duplicateTree();

        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.right = new Node(3);
        node.right.right = new Node(4);
        node.right.left = new Node(2);
        node.right.left.left = new Node(4);
        List<Node> x = node.checkDuplicate(node);
        for (int i = 0; i < x.size(); i++)
            System.out.println(x.get(i).data);
    }
}
