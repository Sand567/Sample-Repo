/**
 * Created by Sharath Nagendra on 11/29/2017.
 */
public class pivotElement {


 //   public static int findPivot(int[] arr) {


//        if (arr.length == 0)
//            return -1;
//        int start = 0, j = 0;
//        int end = arr.length - 1;
//        int pivot = (start + end) / 2;
//
//        while (j < arr.length - 1 && pivot>=0) {
//            int leftsum = 0, rightsum = 0;
//            for (int i = start; i < pivot; i++)
//                leftsum = leftsum + arr[i];
//            for (int i = pivot + 1; i <= end; i++)
//                rightsum = rightsum + arr[i];
////            if(leftsum<1 && rightsum<1)
////                return
//            if (leftsum > rightsum)
//                pivot--;
//            else if (leftsum < rightsum) {
//                pivot++;
//
//            }
//           else if (leftsum == rightsum)
//                return pivot;
//            j++;
//        }
//
//        return -1;
   // }


        public static int pivotIndex(int[] nums) {
            int sum = 0, leftsum = 0;
            for (int x: nums)
                sum += x;
            for (int i = 0; i < nums.length; i++) {
                if (leftsum == sum - leftsum - nums[i])
                    return i;
                leftsum += nums[i];
            }
            return -1;
        }




    public static void main(String[] args) {
        int arr[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));

    }


}
