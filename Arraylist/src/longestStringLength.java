import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class longestStringLength {

    public static String[] maxStringLength(String[] arr){
        if(arr.length==0)
            return null ;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            String x = arr[i];
            map.put(i,x.length());
        }
        String res="";
        int maxValue = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValue) {
                res=res+entry.getKey();
               // System.out.println(entry.getKey());     // Print the key with max value
            }
        }
      //  System.out.println(res);
        String[] op = new String[res.length()];
      //  op[0] = (arr[(res.charAt(0))]);
        //char c = res.charAt(0);
      //  op[0] = arr[Character.getNumericValue(res.charAt(i))];
       // System.out.println(a);
        for(int i=0;i<res.length();i++)
        {
            op[i] = arr[Character.getNumericValue(res.charAt(i))];
        }
        return op;
      //  System.out.println(op.toString());
      //  System.out.println(maxValue);
    }

//    List<String> list = new ArrayList<String>();
////add some stuff
//  list.add("android");
//  list.add("apple");
//    String[] stringArray = list.toArray(new String[0]);
    public static void main(String[] args) {
        String[] arr = {"aba", "aa", "ad", "vcda", "aba"};
       // System.out.println(arr[0]);
//        String[] brr = new String[3];
//        brr[0] = arr[0];
//        System.out.println(brr[0].toString());
        String[] op = maxStringLength(arr);
        for(int i=0;i<op.length;i++)
            System.out.println(op[i]);
    }
}
