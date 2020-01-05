/**
 * Created by Sharath Nagendra on 9/2/2017.
 */
public class Solution {
    public static void main(String[] args) {

    int[] A = {1,-2,3,4,2,2};
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        System.out.println(max);
    }
}