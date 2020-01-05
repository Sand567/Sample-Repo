/**
 * Created by Sharath Nagendra on 11/4/2017.
 */
public class productOfNums {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = new int[nums.length];
//        for (int i = 0, tmp = 1; i < arr.length; i++) {
//            res[i] = tmp;
//            tmp *= arr[i];
//        }
//        for (int i = arr.length - 1, tmp = 1; i >= 0; i--) {
//            res[i] *= tmp;
//            tmp *= arr[i];
//        }
//        for(int i=0;i<res.length;i++)
//            System.out.println(res[i]);
//    }

        for (int i = 0; i < result.length; i++) result[i] = 1;
        int left = 1, right = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            result[i + 1] *= left;
            result[j - 1] *= right;
        }
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);

    }
}
