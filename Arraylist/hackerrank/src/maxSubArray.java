/**
 * Created by Sharath Nagendra on 1/6/2018.
 */
public class maxSubArray {
//kadanes algorithm
    public static int findMaxSubarray(int[] a) {

        if (a.length == 0)
            return -1;
        int sum = 0, maxSum = 0;
        int i = 0;
        while (i < a.length) {
            sum = sum + a[i];
            if (sum < 0) {
                sum = 0;
            }
            else if (sum > maxSum) {
                maxSum = sum;

            }
            i++;
        }
        return maxSum;
    }

    //dynamic programming
    public static int dpMaxSubArray(int[] a){

        int maxSum = a[0];
        int sum = a[0];

        for(int i=1;i<a.length;i++)
        {
             sum = Math.max(a[i],sum+a[i]);
             maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b ={1,-3,2,1,-1};
        int[] arr = {904,40,523,12,-335,-385,-124,481,-31};
        System.out.println(findMaxSubarray(b));
      //System.out.println(dpMaxSubArray(arr));
    }
}
