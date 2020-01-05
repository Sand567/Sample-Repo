import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sharath Nagendra on 9/18/2017.
 */
public class cernerUniqueNumber {

    public static void findUniqueNumber(int[] arr) {
        SortedSet<Integer> s2 = new TreeSet<>();
        SortedSet<Integer> s1 = new TreeSet<>();
        for (int x = 0; x < arr.length; x++) {
            if (s1.add(arr[x]) == true) {
                s2.add(arr[x]);
            } else if (s1.add(arr[x]) == false)

                s2.remove(arr[x]);

        }
        if (s2.size() == 0)
            System.out.println("No unique elements");
        for (int i = 0; i < arr.length ; i++)

            if (arr[i] == s2.first()) {
                i = i + 1;
                System.out.println("The index is :" + i);
            }
    }


    public static int FindSmallest(int[] arr1) {//start method

        int index = 0;
        int min = arr1[index];
        for (int i = 1; i < arr1.length; i++) {

            if (arr1[i] < min) {
                min = arr1[i];
                index = i;
            }


        }
        return index;

    }


    public static void main(String[] args) {
        int[] arr = { 9, 9, 1, 6,7, 6, 5, 8, 8, 1, 5, 3,3};
        findUniqueNumber(arr);

    }
}
