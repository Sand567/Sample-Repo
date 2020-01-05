import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sharath Nagendra on 7/7/2017.
 */
public class binarySearchTree {
    static ArrayList<Integer> list = new ArrayList<>();
    static int maxSum = 0;
    static int[] arr = new int[10];
    static Node root;
    static int res1;
    static int res2;
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

    binarySearchTree() {
        root = null;
    }

    public void insert(int data) {

        root = InsRecord(root, data);

    }

    public Node InsRecord(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data)
            root.left = InsRecord(root.left, data);


        else if (data > root.data)
            root.right = InsRecord(root.right, data);


        return root;

    }

    public static int size(Node root) {

        if (root == null)
            return 0;
        else
            return (size(root.left) + 1 + size(root.right));
    }

    public void inorderTraversal() {

        inorder(root);
    }


    public static void inorder(Node root) {

        if (root != null) {
            inorder(root.left);

            System.out.println(root.data);

            inorder(root.right);
        }

    }

    public static void newInorder(Node root, int n) {
        int count = 0;
        if (root == null)
            return;
        if (count <= n) {

            newInorder(root.left, n);
            count++;
            //System.out.println(root.data+ "this is the "" element in the tree");
            if (count == n)
                System.out.println(root.data);


            newInorder(root.right, n);

        }


    }


    public static void preorder(Node root) {

        if (root != null) {
            System.out.println(root.data);
            inorder(root.left);
            inorder(root.right);
        }

    }


    //iterative inorder traveral

    public static void iterativeInorder(Node node) {
        Stack<Node> stack = new Stack<>();
        Node cur = node;


        while (!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
                cur = stack.pop();
                System.out.println(cur.data);
                cur = cur.right;
            }

        }



    //function to delete a node given the node and key
    public static Node deleteNode(Node node, int key) {

        if (node == null) {
            return null;
        }
//        if(node.data==key && node.left==null && node.right==null)
//            node.data= Integer.parseInt(null);
        if (key < node.data) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.data) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node x = findMin(node.right);
            node.data = x.data;
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }


    //function to find min
    public static Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    //iterative tree traversal as opposed to recursive
    public static List<Integer> search(Node node) {

        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node cur = node;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.data);
            System.out.println(cur.data);
            cur = cur.right;
        }
        return list;
    }


    //print all nodes at given level

    static void printKDistant(Node node, int k) {
        if (node == null)

            return;

        //for(int k=0;k<)
        if (k == 0) {
            System.out.print(node.data + " ");

            return;
        } else {

            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }

    //number of levels in a tree
    public static int printLevel(Node node) {

        if (node == null)
            return 0;
        return Math.max(printLevel(node.left), printLevel(node.right)) + 1;
    }


    //RECURSION -----------------------------print all leaf nodes
    public static void printLeaf(Node node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            System.out.println(node.data);
        printLeaf(node.left);
        printLeaf(node.right);
    }


    //ITERATION------------------------print all leaf nodes
    public static void iterativePrintLeaf(Node newNode) {
        if (newNode == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(newNode);
        while (!stack.isEmpty()) {

            Node node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);

            }

            if (node.left == null && node.right == null) {
                System.out.println(node.data);
            }
        }
    }

//returns the max sum in a tree

    public static void maxSumPath(Node node, int[] arr, int index, int sum) {

        if (node == null)
            return;
//        list.add(index++,node.data);
//   //     arr[index++]=node.data;
        sum = sum + node.data;
        if (node.left == null && node.right == null) {
            if (sum > maxSum) {
                maxSum = sum;
//                        arr=Arrays.copyOf(arr,index);
                //    list.clone();
            }
            return;

        }
        maxSumPath(node.left, arr, index, sum);
        maxSumPath(node.right, arr, index, sum);
        System.out.println(maxSum);
        return;
//            list.add(node.data);
//            sum=sum+node.data;
//            return;
//        }
//        else {
//            sum = sum + maxSumPath(node.left);
//            list.add(sum);
//            //sum=0;
//            sum = sum + maxSumPath(node.right);
//            list.add(sum);
//            return sum;
//        }

    }

    //---------------------------------------------------------------------------------------------
    //returns path containing max sum in a tree
    static boolean printPath(Node root, int sum) {
        // base case
        if (sum == 0)
            return true;

        // base case
        if (root == null)
            return false;

        // recurse for left and right subtree with reduced sum
        boolean left = printPath(root.left, sum - root.data);
        boolean right = printPath(root.right, sum - root.data);

        // print current node if it lies on path having given sum
        if (left || right)
            System.out.println(root.data + " ");

        return left || right;
    }

    // Function to calculate maximum root-to-leaf sum in a binary tree
    static int rootToLeafSum(Node root) {
        // base case: tree is empty
        if (root == null)
            return 0;

        // calculate maximum node-to-leaf sum for left child
        int left = rootToLeafSum(root.left);
        // System.out.println(left+"This is the left sum");
        // calculate maximum node-to-leaf sum for right child
        int right = rootToLeafSum(root.right);

        // consider maximum sum child
        return (left > right ? left : right) + root.data;
    }

    // Function to print maximum sum root-to-leaf path in a given binary tree
    static void findMaxSumPath(Node root) {
        int sum = rootToLeafSum(root);
        System.out.println("Maximum sum is " + sum);
        System.out.println("Maximum sum path is: ");

        printPath(root, sum);
    }

//---------------------------------------------------------------------------------------------------------
    // Function to print all root-to-leaf paths in a given binary tree
    public static String binaryTreePaths(Node node) {
        ArrayList<String> res = new ArrayList<String>();
        DFS(node, "", res);
        return res.toString();
    }

    public static void DFS(Node node, String solution, ArrayList<String> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) res.add(solution + node.data);
        DFS(node.left, solution + node.data + " -> ", res);
        DFS(node.right, solution + node.data + " -> ", res);
    }
//----------------------------------------------------------------------------------------------------------
    //given sum path exists or not
    static boolean hasPathWithGivenSum(Node node, int s) {
        if(node==null && s>0)
            return false;
        if(node==null && s==0)
            return true;
        if(s<0)
            return false;
        if(node.left==null && node.right==null && s==0){

                return true;

            //    return false;
        }
       boolean ans=false;
        //int sum = s-t.value;

            ans = ans|| hasPathWithGivenSum(node.left,s-node.data);

            ans = ans|| hasPathWithGivenSum(node.right,s-node.data);
      //  System.out.println("left : "+left+"  right: "+right);
        return ans;
    }
//--------------------------------------------------------------------------------------------------


   public static Node LCA(Node node,int n1,int n2){

        if(node==null)
            return null;
        if(n1<node.data && n2>node.data)
            return node;
        if(n1>node.data){
            return LCA(node.right,n1,n2);
        }
        if(n2<node.data){
            return LCA(node.left,n1,n2);
        }
       // System.out.println(node.data);


        return node;

    }

    private static int findDistance(Node node, int n1,int level) {

        if(node==null)
            return -1;

        if(node.data == n1){
            return level;
        }
        int left  = findDistance(node.left,n1,level+1);
        if(left==-1){

            return findDistance(node.right,n1,level+1);
        }

        return left;
        }



    // 50 30 20 40  70 60 80
    public static void main(String[] args) {


        binarySearchTree tree = new binarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);


        Node node = new Node(3);
        node.left = new Node(1);
        node.left.left = new Node(0);
        node.left.right = new Node(2);
        node.right = new Node(5);
        node.right.right = new Node(7);
        node.right.left = new Node(4);


        //findMaxSumPath(node);

       // System.out.println(size(node));

        Node newNode = new Node(4);
        newNode.left = new Node(1);
        newNode.right = new Node(3);
        newNode.right.left = new Node(1);
        newNode.right.right =new Node(2);
        newNode.left.left =new Node(-2);
        newNode.left.left.right =new Node(3);
        newNode.right.right.left =new Node(-2);
        newNode.right.right.right =new Node(-3);

//        String a="hello";
//        String b="hello";
//        String c=new String("hello");
//        String d=c;
//        String e=new String("hello");
//        System.out.println(a==b);//true
//        System.out.println(a.equals(b));//true
//        System.out.println(a==c);//false
//        System.out.println(c==d);//true
//        System.out.println(c.equals(d));//true
//        System.out.println(c==e);//false
//        System.out.println(c.equals(e));//true

//        a) a==b
//        b)a.equals(b)
//        c)a==c
//        d)c==d
//        e)c.equals d
//        f) c==e
//        g)c.equals e


        //System.out.println(rootToLeafSum(node));
        /// /delete a node
        //   Node res = deleteNode(node, 4);
       // System.out.println(res.data);
        //    preorder(node);
        //     newInorder(node, 4);
      //  inorder(res);
        //iterative binary search traversal
        //  search(node);
        //printPath(node,12);
        //print elements of tree
        //tree.inorderTraversal();

        //print all nodes at a given level
        //printKDistant(node, 1);


        //print leaf nodes RECURSION
        // printLeaf(node);

        //print leaf nodes ITERATIVE
        //  iterativePrintLeaf(node);

       // System.out.println(hasPathWithGivenSum(node,12));

        //iterativeInorder(node);
//        Node res = LCA(node,0,2);
//        System.out.println(res.data);
//        res1 = findDistance(res,0,0);
//        res2 = findDistance(res,2,0);
//        System.out.println(res1+res2);
           // findMaxSumPath(node);
        System.out.println(binaryTreePaths(node));

//        int sum = 0;
//        for (int i = 0; i < res.size(); i++) {
//
//           System.out.println(res.get(i));
//        }
//        System.out.println("Sum = " + sum);
//        String[] arr = new String[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            arr[i] = res.get(i);
//        }

        //   System.out.println(printLevel(node));
      //  maxSumPath(node,arr,0,0);
//        System.out.println(maxSum);
//        for(int i:arr)
//            System.out.println(i);
        // System.out.println(Arrays.asList(list));
    }


}
