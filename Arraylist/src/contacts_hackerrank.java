/**
 * Created by Sharath Nagendra on 7/2/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    Node[] children = new Node[26];
    int completeChildren = 0;
}
public class contacts_hackerrank {

    static Node head;




        public static void main(String[] args) {

            head = new Node();
            List searchResults = new ArrayList();

            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            for(int a0 = 0; a0 < n; a0++){
                String op = in.next();
                String contact = in.next();
                if(op.equals("add"))
                {
                    addContact(contact);

                }
                else if(op.equals("find"))
                {
                    searchResults.add(countOccurences(contact));
                }
            }
            printResult(searchResults);



        }


    public static void printResult(List searchResults){
        for(Object result: searchResults){
            System.out.println(result);
        }
    }



    public static int countOccurences(String term) {
        Node currentNode = head;
        for (int i = 0; i < term.length(); i++) {
            char c = term.charAt(i);
            currentNode = currentNode.children[getCode(c)];
            if (currentNode == null) {
                return 0;
            }
        }
        return currentNode.completeChildren;


    }


    public static int getCode(char c){
        return c - ((int) 'a');
    }

    public static Node getOrAddNode(Node node, char c){
        Node nextChild = node.children[getCode(c)];
        if(nextChild != null){
            nextChild.completeChildren++;
        }else{
            nextChild = new Node();
            nextChild.completeChildren++;
            node.children[getCode(c)]= nextChild;
        }
        return nextChild;
    }

    public static void addContact(String contact){
        if(contact == ""){
            return;
        }
        Node currentNode = head ;
        for(int i=0; i < contact.length();i++){
            char c = contact.charAt(i);
            currentNode = getOrAddNode(currentNode, c);
        }
        return;
    }







    }



