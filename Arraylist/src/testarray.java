import java.util.Arrays;

/**
 * Created by Sharath Nagendra on 9/9/2018.
 */
public class testarray {

    static long triplets(long t, int[] a) {

        Arrays.sort(a);
        //Collections.sort(d);
        long count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j <k) {

                if (a[i] + a[j] + a[k] > t) {
                   k--;
                }
                else
                {
                    count+= k-j;
                    //count++;
                    j++;

                }
                //k--;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        System.out.println(triplets(7, arr));


    }
}
