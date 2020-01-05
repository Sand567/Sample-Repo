import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/24/2017.
 */
public class lonelyInteger {

    public static void lonelyInteger(int[] a) {
        HashSet<Integer> myset = new HashSet<Integer>();
     //   List<Integer> mylist = new ArrayList<Integer>();
        for (int i=0;i< a.length;i++) {

            if (!myset.contains(a[i])) {
                myset.add(a[i]);
                System.out.println(a[i] + " ");
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
    //  lonelyInteger(a);
        int start =0;
        for(int x =0;x<a.length;x++){
            start^= a[x];
           // System.out.println(start[x]);
        }

       System.out.println("Non-repeating"+start);
              //  System.out.println(finallist.get(i));
        }
    }
