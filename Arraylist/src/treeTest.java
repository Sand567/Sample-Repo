import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sharath Nagendra on 1/23/2018.
 */
public class treeTest {


    static class Tree<T> {
        Tree(int x) {
            value = x;
        }

        int value;
        Tree<T> left;
        Tree<T> right;
    }

    static int[] traverseTree(Tree<Integer> t) {
        Queue<Tree> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            Tree<Integer> x = queue.poll();
            list.add(x.value);
            if (x.left != null) {
                queue.add(x.left);
            }
            if (x.right != null) {
                queue.add(x.right);
            }
        }
        // Integer [] output = list.toArray(new Integer[list.size()]);
        int[] finalarr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                finalarr[i] = list.get(i);
            }

        }
        return finalarr;
    }

    public static int[] largestValuesInTreeRows(Tree<Integer> t) {
        ArrayList<Integer> list = new ArrayList<>();
        int flag=0;
        Queue<Tree> q = new LinkedList<>();

        q.add(t);
        while(!q.isEmpty()) {
            int levelNodes = q.size();
            int maxValue= Integer.MIN_VALUE;
            while (levelNodes > 0) {
              //  int curMax =Integer.MIN_VALUE;
                Tree<Integer> tempnode = q.poll();
                if (tempnode.value > maxValue) {
                    maxValue = tempnode.value;

                }

                if (tempnode.left != null)
                    q.add(tempnode.left);
                if (tempnode.right != null)
                    q.add(tempnode.right);
                levelNodes--;
            }
            list.add(maxValue);
        //    System.out.println("at level :"+flag+"the largest number is"+maxValue);
            flag++;
        }
        int[] arr = new int[list.size()];
      for(int i=0;i<list.size();i++)
          arr[i] = list.get(i);
      return arr;
    }





    public static void main(String[] args) {
        Tree t = new Tree(-1);
        t.left = new Tree(5);
        t.right = new Tree(7);
      //  t.left.right = new Tree(3);
        t.right.left = new Tree(1);
      //  int[] arr = traverseTree(t);
//        for (int i : arr)
//            System.out.println(i);
       int[] arr= largestValuesInTreeRows(t);
       for(int i:arr)
           System.out.println(i);
    }
}
