import java.util.ArrayList;

/**
 * Created by Sharath Nagendra on 6/24/2017.
 */

public class array_list_sort {

    public static void main(String[] args) {


        ArrayList arrayList = new ArrayList();
        arrayList.add(11);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(4);


        //print arraylist with [ and ] //like an array
        System.out.println("arraylist before sorting"+arrayList);

        //print elements of arraylist use for loop , take each element and then get index of each and then print value at each index
        for(int i =0;i<arrayList.size();i++)
            System.out.println(arrayList.get(i));

    }

}
