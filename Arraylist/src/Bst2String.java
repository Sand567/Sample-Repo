/**
 * Created by Sharath Nagendra on 7/21/2017.
 */
public class Bst2String {
    static Node root;
    static  String res = "";
    public static class Node {
        int data;
        Node left;
        Node right;


        Node(int data) {
            this.data = data;
            left =null;
            right =null;
        }

    }

    Bst2String(){
        root =null;
    }

    public static String btree2string(Node node){


        if (node == null) return "";

        String result = node.data + "";

        String left = btree2string(node.left);
        String right = btree2string(node.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";


//            if (node != null) {
//
//                res = res + node.data;
//                System.out.println(node.data);
//                if(node.left!=null) {
//                    res = res + "(";
//                }
//                else
//                {
//                    res = res+")";
//                }
//                res = res+")";
//                btree2string(node.left);
//
//
//
//
//
//                //if(node.left==null && node.right!=null)
//                   // res =res+"(";
//                if(node.right!=null )
//                    res=res+"(";
//                btree2string(node.right);
//
//            }


    }

    public static String sbmethod(Node node){

        StringBuilder sb = new StringBuilder();
        helper(sb,node);
        return sb.toString();

    }

    public static void helper(StringBuilder sb,Node t) {

        if(t!=null)
        {
            sb.append(t.data);
            if(t.left!=null||t.right!=null)
            {
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");

                if(t.right!=null)
                {
                    sb.append("(");
                    helper(sb,t.right);
                    sb.append(")");
                }
            }
        }
    }
    public static void main(String[] args) {
        Bst2String bt = new Bst2String();
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.right = new Node(3);
        System.out.println(sbmethod(node));
      //  System.out.println(btree2string(node));

    }

}
