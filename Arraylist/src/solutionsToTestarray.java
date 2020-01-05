import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 2/13/2018.
 */
public class solutionsToTestarray {

    //find first occurrence
    static int findIndex(int[] arr, int key) {

        if (arr.length == 0)
            return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;

    }

    //alternating sum
    static int findSum(int[] arr) {
        if (arr.length == 0)
            return -1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

        }
        int sumFinal = sum;
        for (int i = 0; i < arr.length - 3; i++) {
            sum = sum - arr[i];
        }


        System.out.println("even num sum " + sum);
        System.out.println("odd sum is " + (sumFinal - sum));
        return sum;
    }

    //container with max water
    static int maxWater(int[] arr){
        if(arr.length==0)
            return -1;
        int left=0;
        int right = arr.length-1;
        int maxArea=Integer.MIN_VALUE;
        while(left<=right){
            maxArea = Math.max(maxArea,(Math.min(arr[left],arr[right]))*(right-left));
            if(arr[left]<arr[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    //2sum
    static int[] twoSum(int[] arr,int target){


        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int newTarget = target - arr[i];

            if(map.containsKey(newTarget)){
                System.out.println(" the output found at "+newTarget+" and "+arr[i]);
                return new int[]{map.get(newTarget),i};
            }

                map.put(arr[i],i);
        }
     return null;
    }

    //first unique character
    static int findFirst(String s){

        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;

        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1)
                return i;
            }
        return -1;
        }



    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 1, 5, 6};
        int[] TwoSum = {1,2,4,5,8,12};
        System.out.println("index is " + findFirst("geeksgeeksa"));
        //System.out.println(findIndex(arr,;1));
       // findSum(arr);
       // System.out.println(maxWater(arr));
        //twoSum(TwoSum,12);
    }


}
