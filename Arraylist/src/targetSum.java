import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 8/18/2017.
 */

//only when sorted  ---so sort iif array unsorted and then carry out the below function
 public class targetSum {
//print the pair which sums upto the target sum provided
//time complexity is o(n)
    //space complexity is o(n)
//o(nlogn)+o(n)=o(n)
    //heap if we use...time complexity klogn k is heap size n is number of elements
    //o(n^2)
    public static int[] checkPairs(int[] arr,int target){
        Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
     //   int[] newarr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int newTarget= target-arr[i];

            if(mymap.containsKey(newTarget)){
                System.out.println("Matching pair is:"+ (target-arr[i])+", "+arr[i]);

                return new int[]{mymap.get(newTarget),i};
            }
            mymap.put(arr[i],i);
        }
return null;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,5,8,12};
        int[] testArr = {4,8,2,5,7};

        int target = 12;
        int res[]=checkPairs(arr,target);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);

    }
}
