import java.util.Arrays;

/**
 * Created by Sharath Nagendra on 7/31/2017.
 */
public class array2BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    public static Node convert2BST(int[] arr, int start, int end) {

        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left = convert2BST(arr, start, mid - 1);
        node.right = convert2BST(arr, mid + 1, end);

        return node;


    }

    public static void preorder(Node root) {

        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);

            preorder(root.right);
        }

    }


    public static void main(String[] args) {
        int[] arr = {890, 325, 290, 530, 965};
    //    Arrays.sort(arr);
        Node node = convert2BST(arr, 0, arr.length - 1);
        preorder(node);
    }
}
