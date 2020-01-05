import java.util.Arrays;

/**
 * Created by Sharath Nagendra on 7/19/2017.
 */
public class MergeBT {

static Node root;
    public class Node {
        int data;
        Node left;
        Node right;


        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    MergeBT(){
    root=null;

    }

    public Node sortedBST(int start,int[] arr,int end){
    String res = "";
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        res += node.left.toString();

        node.left = sortedBST(start,arr,mid-1);
        res+=node.right.toString();
        node.right = sortedBST(mid+1,arr,end);

        res+=node.data;
        int[] ar = Arrays.stream(res.substring(1, res.length()-1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ar));
        for(int i =0;i<ar.length;i++)
            System.out.println(ar[i]);
        return node;
    }

public static  void preorder(Node root){
        if(root == null){
            return ;
        }
        else
            if(root!=null) {

              //  System.out.println(root.data+" \n");
                preorder(root.left);

                preorder(root.right);


            }

    }
    public static void main(String[] args) {
        MergeBT bt = new MergeBT();
        int[] arr ={1,2,3,4,5,6,7};
        int n = arr.length;
        root = bt.sortedBST(0,arr,n-1);
        preorder(root);
    }
}
