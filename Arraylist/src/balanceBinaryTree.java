import java.util.*;

/**
 * Created by Sharath Nagendra on 11/20/2017.
 */

// 1) Check if binary tree is balanced (the max height difference between left and right subtree can differ by at most 1
// 2) Check if binary tree is a full binary tree( every node should have either 0 nodes or 2 nodes)
// 3) Print all the leaf nodes
// 4) Print the level with max nodes
// 5) Print all the ancestor of a  node
// 6) Lowest common Ancestor: Create 2 arrays for storing paths of 2 nodes from root. Compare both arrays and return the element at which it differs.
// 7) invert binary tree
public class balanceBinaryTree {

    static ArrayList<Integer> list = new ArrayList<>();
    //static ArrayList<Integer> rlist = new ArrayList<>();

    static class Node {
        int data;
        Node left;
        Node right;


        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // 1
    public static boolean isBalanced(Node node) {
        int res = heightOfTree(node);
        System.out.println(res);
        if (heightOfTree(node) == -1)
            return false;
        return true;
    }

    public static int heightOfTree(Node node) {

        if (node == null)
            return 0;
        int height_1 = heightOfTree(node.left);
        int height_2 = heightOfTree(node.right);
        if (Math.abs(height_1 - height_2) > 1)
            return -1;
        //System.out.println(1+Math.max(height_1,height_2));
        return  1+Math.max(height_1, height_2);
    }

    // 2
    public static boolean isFullBinaryTree(Node node) {

        if (node == null)
            return true;
        if (node.left == null && node.right == null) {

            return true;
        } else {
            if (node.left != null && node.right != null)
                return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }
        return false;


    }

    // 3
    public static void printLeaf(Node node) {

        if (node == null)
            return;

        if (node.left == null && node.right == null)
            System.out.println(node.data);
        printLeaf(node.left);
        printLeaf(node.right);

    }


    // 4
    public static int maxNodes(Node node) {
        int level = 1;
        if (node == null)
            return -1;
        else if (node.left == null && node.right == null)
            return 0;
        maxNodes(node.left);
        level++;
        maxNodes(node.right);
        level++;

        return level;
    }

    //5
    public static boolean printAncestor(Node node, int key) {
        if (node == null)
            return false;
        if (node != null) {
            if (printAncestor(node.left, key) || printAncestor(node.right, key)) {
                list.add(node.data);

                return true;
            }
            if (node.data == key)
                return true;
//            if (node.data == key) {
//               // System.out.println(count);
//                return true;
//            }
        }
        return false;
    }

    public static int findDistance(Node node, int n1) {

        if (node == null)
            return -1;
        int dist = 0;
        if (node.data == n1 || (dist = findDistance(node.left, n1)) >= 0 || (dist = findDistance(node.right, n1)) >= 0) {
            return dist + 1;
        }
        return dist;
    }

    //iterative
    static Node invertTree(Node node) {
        if (node == null)
            return null;


        LinkedList<Node> q = new LinkedList<Node>();
        if (node != null)
            q.add(node);
        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p.left != null)
                q.add(p.left);
            if (p.right != null)
                q.add(p.right);

            Node temp = p.left;
            p.left = p.right;
            p.right = temp;

        }
        return node;

    }

    static Node invertRecursive(Node node) {
        if (node == null)
            return null;
        Node rightTree = invertRecursive(node.right);
        Node leftTree = invertRecursive(node.left);

        node.left = rightTree;
        node.right = leftTree;

        return node;

    }

    public static void flatten(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;

        while (p != null || !stack.empty()) {

            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                Node temp = stack.pop();
                p.right = temp;
            }
            System.out.println(p.data);
            p = p.right;
        }
    }

    public static void inorder(Node root) {

        if (root != null) {
            inorder(root.left);

            System.out.println(root.data);

            inorder(root.right);
        }

    }

    public static int maxValuesAtALevel(Node node,int level){

        if (node == null)
            return 0;

        // if level becomes 0, it means we are on
        // any node at the given level
        if (level == 1)
            return node.data;

        int x = maxValuesAtALevel(node.left, level - 1);
        int y = maxValuesAtALevel(node.right, level - 1);

        // return maximum of two
        return Math.max(x, y);

    }




//    public static Node invertTree(Node node){
//        if(node!=null){
//            helper(node);
//        }
//        return node;
//
//    }
//
//    public static void helper(Node node){
//
//        Node p = node.left;
//        node.left = node.right;
//        node.right = p;
//
//        if(p.left!=null)
//            helper(p.left);
//        if(p.right!=null)
//            helper(p.right);
//
//
//
//    }

    //calculate max sum in a binary tree
     public static int maxPathSum(Node node) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(node, max);
        return max[0];
    }

    public static int calculateSum(Node node, int[] max) {
        if (node == null)
            return 0;

        int left = calculateSum(node.left, max);
        int right = calculateSum(node.right, max);

        int current = Math.max(node.data, Math.max(node.data + left, node.data + right));

        max[0] = Math.max(max[0], Math.max(current, left + node.data + right));

        return current;
    }


    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.left.left = new Node(0);
       // node.left.right = new Node(2);
        node.right = new Node(5);
        node.right.left = new Node(4);
        node.right.right = new Node(7);
        // System.out.println(isFullBinaryTree(node));

         // printLeaf(node);

        Node newNode = new Node(1);
        newNode.right = new Node(3);
        newNode.left = new Node(2);
        newNode.left.right = new Node(5);
        newNode.left.left = new Node(4);
        newNode.left.left.left = new Node(7);


        //System.out.println(maxPathSum(node));

        //System.out.println(maxValuesAtALevel(node,3));
      //  System.out.println(heightOfTree(newNode));
        //invertTree(node);
//        Node res = invertRecursive(node);
//        inorder(res);
        //flatten(node);
     //   System.out.println(isFullTree(node));
         System.out.println(maxNodes(node));
       // invertTree()
      //  printAncestor(node, 2);
//        System.out.println("distance from node to root= "+count);
         //  System.out.println(list);
//        System.out.println("height of tree is"+);
           //int n1height= findDistance(node,7);
        //   int n2height = findDistance(node,5);
        //System.out.println(n1height);
        //  System.out.println(" n1 height and n2 height = "+n1height+"   "+n2height);
        // System.out.println(isBalanced(node));
       // System.out.println(isFullBinaryTree(node));

       //s System.out.println(heightOfTree(node));
        //maxLevels(node);

    }
}
