/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class missingNumber {


    //    static int findMissingNumber(int[] arr) {
//
//
//
//    }
    public static int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }


        return res;
    }

    public static int exor(int[] nums) {
        int totalXor = 0;
        int arrXor = 0;
        for (int i = 1; i <= nums.length + 1; i++)
            totalXor = totalXor ^ i;
        for (int i = 0; i < nums.length; i++)
            arrXor = arrXor ^ nums[i];
        return totalXor ^ arrXor;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};

        //ans is 2
       // System.out.println(missingNumber(arr));


        System.out.println(exor(arr));
//      for(int i=0;i<arr.length-1;i++) {
//          if (arr[i]+1==arr[i+1]){
//              continue;
//          }
//          else
//              System.out.println(i+1);
//      }
        // System.out.println(findMissingNumber(arr));
    }
}
