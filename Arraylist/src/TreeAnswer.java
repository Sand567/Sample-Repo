/**
 * Created by Sharath Nagendra on 2/18/2018.
 */
public class TreeAnswer {

    static class Node {
        Node left;
        Node right;
        int data;


        Node(int data) {
            this.data = data;
            left = null;
            right = null;

        }

    }

    static Node mergeTree(Node node,Node node2){
        if(node==null && node2!=null)
            return node2;
        if(node2==null && node!=null)
            return node;
        if(node==null && node2==null)
            return null;

        Node resNode = new Node(node.data+node2.data);
        resNode.left = mergeTree(node.left,node2.left);
        resNode.right = mergeTree(node.right,node2.right);

        return resNode;

    }

    static void inorder(Node node){
        if(node!=null){

            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);

        }
    }

    static void preorder(Node node){
        if(node!=null){

            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);

        }
    }



    public static Node helperBST(int[] arr){
        Node resnode = buildBST(arr,0,arr.length-1);
        return resnode;
    }

    public static Node buildBST(int[] arr,int start,int end){

        while(start>end)
            return null;

            int mid = (start+end)/2;
            Node newnode = new Node(arr[mid]);

            newnode.left = buildBST(arr,start,mid-1);
            newnode.right = buildBST(arr,mid+1,end);
            return newnode;
        }





    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(3);
        node.left.left = new Node(5);
        node.right = new Node(2);

        Node node2 = new Node(2);
        node2.left = new Node(1);
        node2.left.right = new Node(4);
        node2.right = new Node(3);
        node.right.right = new Node(7);

        int[] arr = {2,3,5,7,11,13,17,19,23};


        Node res = helperBST(arr);
        inorder(res);
//        Node resNode = mergeTree(node,node2);
//        inorder(resNode);

    }
}
