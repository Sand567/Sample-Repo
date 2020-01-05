/**
 * Created by Sharath Nagendra on 6/24/2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class arr_list{

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i : list) {
            System.out.println(i);
//            list.remove(i-1);
        }

//        for(Iterator<Integer> iterator = list.iterator();iterator.hasNext()){
//
//        }

        String x =reverseRecursively("Hello");
       // System.out.println(x);


//create an ArrayList object
        ArrayList<String> arrayList = new ArrayList();

//Add elements to Arraylist

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("F");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("H");
        arrayList.add("I");


 /*
Get a ListIterator object for ArrayList using
istIterator() method.
*/

        ListIterator itr = arrayList.listIterator();

/*
Use hasNext() and next() methods of ListIterator to iterate through
the elements in forward direction.
*/

        System.out.println("Iterating through ArrayList elements in forward  direction...");

        while(itr.hasNext())
            System.out.println(itr.next());

/*Use hasPrevious() and previous() methods of ListIterator to iterate through
the elements in backward direction.*/

        System.out.println("Iterating through ArrayList elements in backward   direction...");


        while(itr.hasPrevious())
            System.out.println(itr.previous());

    }



    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }



}