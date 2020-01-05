import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 11/30/2017.
 */
public class maxLengthOfSubarray {


    public static int findMaxLength(int[] a,int[] b){

        if(a.length==0|| b.length==0)
            return 0;

        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
            map.put(a[i],i);
        for(int j=0;j<b.length;j++)
        {
            if(map.containsKey(b[j]))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b ={3,2,1,2,7};
        System.out.println(findMaxLength(a,b));
    }
}
