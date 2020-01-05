import java.util.*;

/**
 * Created by Sharath Nagendra on 7/6/2017.
 */
public class levelOrderTraversal {


    static class Node {
        int data;

        Node left;
        Node right;

        Node(int d) {
            this.data = d;

            this.right = null;
            this.left = null;
        }
    }





    public Node head;// head of linked list

    public levelOrderTraversal()
    {
        head = null;
    }
    /* Linked list node */



    public static  void traversal(Node startNode)
    {

        LinkedList<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(startNode);

        int level=1;
        int flag=0;
        int nodesCount=0;
        int tempCount=0;

        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            System.out.println("Number of nodes in level"+level+ " is"+queue.size());
            list.add(queue.size());
            map.put(queue.size(),level);
            while (levelNodes > 0 ) {

                Node tempnode = queue.poll();

               // System.out.println("at level :"+flag+"the nodes are"+tempnode.data);


                if (tempnode.left != null) {

                    queue.add(tempnode.left);


                }

                    if (tempnode.right != null)
                        queue.add(tempnode.right);

                    levelNodes--;



            }
          //  System.out.println("Number of nodes in level"+level+ " is"+queue.size());
            level++;
          //  flag++;
            System.out.println("");

        }
        int key = Collections.max(list);

        System.out.println("Level which contains max nodes is "+map.get(key));
        System.out.println("max nodes are "+Collections.max(list));
        System.out.println(list);
       // System.out.println(list.get(list.size()-1));
        //System.out.println(level);
    }





    public static void main(String[] args) {

        Node root = new Node(5);
        levelOrderTraversal lr = new levelOrderTraversal();

        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
//        lr.head = new Node(1);
//        lr.head.left = new Node(2);
//        lr.head.right = new Node(3);
//        lr.head.left.left = new Node(4);
//        lr.head.left.right = new Node(5);

        traversal(root);


    }

}
