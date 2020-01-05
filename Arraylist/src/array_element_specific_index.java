import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Sharath Nagendra on 6/24/2017.
 */
public class array_element_specific_index {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();


        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add(1,"y");
        ListIterator itr = arrayList.listIterator();

        System.out.println("ArrayList values...");

        for(int index=0;index<arrayList.size();index++)
            System.out.println(arrayList.get(index));
        arrayList.add(2,"z");

        System.out.println("ArrayList values...");

        for(int index=0;index<arrayList.size();index++)
            System.out.println(arrayList.get(index));

//        while(itr.hasNext())
//            System.out.println(itr.next());

    //    System.out.println(arrayList);
    }
}
