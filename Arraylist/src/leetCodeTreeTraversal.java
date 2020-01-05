import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 7/28/2017.
 */
public class leetCodeTreeTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> mylist = new ArrayList<Integer>();

    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            inorderTraversal(root.left);
            mylist.add(root.val);
            //  System.out.println(root.val);
            inorderTraversal(root.right);
        }
        return mylist;
    }
//    Node node = new Node(5);
//    node.left = new Node(3);
//    node.left.left = new Node(2);
//    node.left.right = new Node(4);
//    node.right = new Node(6);
//    node.right.right = new Node(7);

    public static void main(String[] args) {
        TreeNode x = new TreeNode(5);
        x.left = new TreeNode(3);
        x.right = new TreeNode(6);
        x.left.left = new TreeNode(2);
        x.left.right = new TreeNode(4);
        x.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(x));
    }
}

