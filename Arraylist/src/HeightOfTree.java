/**
 * Created by Sharath Nagendra on 7/21/2017.
 */
public class HeightOfTree {
    static int max = 0;
    static Node root;

    public static class Node {
        int data;
        Node left;
        Node right;


        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    HeightOfTree() {
        root = null;
    }

    public static int diameterOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        int lheight = heightOfTree(node.left);
        int rheight = heightOfTree(node.right);

        int ldiameter = diameterOfTree(node.left);
        int rdiameter = diameterOfTree(node.right);

        path(node);
        return max;

    }

    private static int path(Node root) {
        if (root == null)
            return 0;
        int left = path(root.left), right = path(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static int heightOfTree(Node node) {
        if (node == null)
            return 0;

        return (1 + Math.max(heightOfTree(node.left), heightOfTree(node.right)));
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.left.left.left=new Node(0);
        System.out.println(heightOfTree(node));
        //System.out.println(diameterOfTree(node));

    }
}
