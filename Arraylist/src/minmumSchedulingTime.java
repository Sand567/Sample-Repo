/**
 * Created by Sharath Nagendra on 9/8/2018.
 */
public class minmumSchedulingTime {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        //ans = 10

        {
            int rem = arr.length - (i + 1);
            sum = sum + arr[i] * rem;
        }

        System.out.println(sum);
    }
}
