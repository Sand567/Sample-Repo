import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sharath Nagendra on 7/31/2017.
 */

// 1) print the path from the root to the given node: loop index from 0 to length-1
// 2) print the ancestors of the given node, the only change being start the loop index from 1 to length-1
public class pathFromRootToNode {
    static Node root;
    static ArrayList<Integer> mylist = new ArrayList<>();

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

    public static List<Integer> utilFun(Node node, int key){

        printPath(node,key);

        return mylist;

    }
    public static Boolean printPath(Node node, int key) {


        if (node == null)
            return false;
        if (node.data ==  key || printPath(node.left, key) || printPath(node.right, key)) {
            //   System.out.println("key found ");
            // System.out.println(node.data);
            mylist.add(node.data);
            return true;
        }
        return false;
    }

//    public static Boolean printPath(Node node, int key) {
//
//
//        if (node == null)
//            return false;
//        if (node.data == key || printPath(node.left, key) || printPath(node.right, key)) {
//            //   System.out.println("key found ");
//            // System.out.println(node.data);
//            mylist.add(node.data);
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);
        node.right = new Node(6);
        node.right.right = new Node(7);

       // printPath(node, 7);
        utilFun(node,7);
        int sum=0;
         Collections.reverse(mylist);
        for(int i=0;i<mylist.size();i++){

            sum = sum+mylist.get(i);
            System.out.println(mylist.get(i));

        }
        System.out.println("Sum is : "+sum);
   //    System.out.println(mylist);
      //  System.out.println(mylist.size());
    }
}
