import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 10/11/2018.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        for(int num:nums){
            if(result.size()==0 || num>result.get(result.size()-1)){
                result.add(num);
                continue;
            }
            for(int i=0;i<result.size();i++){
                if(num==result.get(i)){
                    break;
                }
                if(num<result.get(i)){
                    result.remove(i);
                    result.add(i,num);
                    break;
                }
            }
        }
        System.out.println(result);
        return result.size();
    }

}
