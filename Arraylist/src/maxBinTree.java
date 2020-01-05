/**
 * Created by Sharath Nagendra on 8/12/2017.
 */
public class maxBinTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public  Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node maxBinaryTree(int [] arr){

        if(arr==null)
            return null;
        return build(arr,0,arr.length-1);
    }


    public static Node build(int[] arr, int start,int end){

        if(start>end)
            return null;
        int idmax= start;
        for(int i =start+1;i<=end;i++) {
            if (i > idmax) {
                idmax = i;
            }
        }
            Node newnode = new Node(arr[idmax]);
     //   System.out.println(arr[idmax]);

        newnode.left  = build(arr,0,idmax-1);
        newnode.right = build(arr,idmax+1,end);

        return newnode;

    }

    public static void postOrder(Node node){
        if(node==null)
            return;
        if(node!=null){
            System.out.println(node.data);
            postOrder(node.right);
            postOrder(node.left);



        }
    }


    public static void main(String[] args) {
        int arr[] = {3,2,1,6,0,5};
        //int length = arr.length-1;
        postOrder(maxBinaryTree(arr));

    }
}
