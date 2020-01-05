import java.util.*;

/**
 * Created by Sharath Nagendra on 11/29/2017.
 */
public class bitwise {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);



        int num = 10111;
        int count = 0;
        while (num != 0) {
            count = count ^ (num & 1);
            num = num >> 1;
        }
        System.out.println(count);

        int  zcount=0;
        int[] arr = new int[]{16,16,16};
        for(int i=0;i<arr.length;i++){
            if( (arr[i] & 1)==0){
                break;
            }
            else if(arr[i]==0){
                zcount++;
            }
        }

        if(zcount==arr.length){

        }
//        if(count%2==0){
//            System.out.println("0");
//        }
//        else
//            System.out.println("1");
    }
}

//-1,1,4,5,6,7