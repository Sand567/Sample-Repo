import java.util.*;

/**
 * Created by Sharath Nagendra on 9/8/2018.
 */
public class ThreeSum_unique {

    static void threeSum(int[] a, int sum) {

        List<List<Integer>> pair = new ArrayList<>();
        List<Integer> triplets = new ArrayList<>();
        Set<String> set = new TreeSet<>();

        Arrays.sort(a);


        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;

            while (j < k) {
                if (a[i] + a[j] + a[k]==sum) {

                    String str = a[i] + " " + a[j] + " " + a[k];
                    //System.out.println("values " + a[i] + " " + a[j] + " " + a[k] + " sum to the given sum " + sum);
                    if (!set.contains(str)) {
                        triplets.add(a[i]);
                        triplets.add(a[j]);
                        triplets.add(a[k]);
                        pair.add(triplets);
                        set.add(str);
                        triplets = new ArrayList<>();

                    }
                    j++;
                    k--;
                }
                else if (a[i] + a[j] + a[k] < sum) {
                    j++;
                } else  {
                    k--;
                }
            }
        }
        System.out.println(pair);
    }


    public static void main(String[] args) {

        int[] arr = {3,1,2,4};

        threeSum(arr, 7);


    }
}
