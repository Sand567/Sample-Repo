/**
 * Created by Sharath Nagendra on 10/14/2017.
 */
public class buildBinaryTreeWithString {
//for unsorted char array...to build the trree..use level order traversal

    static class Node{

        char word;
        Node left;
        Node right;

    public Node(char word){
        this.word= word;
        left=null;
        right=null;
    }



    }



    public static void buildBT(String str){

        char[] ch=str.toCharArray();
        int start = 0;
        int end =ch.length-1;
        Node newNode = new Node(ch[0]);
        for(int i=0;i<ch.length;i++) {
            if (newNode.left == null) {

            }
        }
        int k=0;
        //newNode.left = buildBT();
;

    }


    public static void main(String[] args) {
        String str ="ABCDEF";
        buildBT(str);
    }
}
