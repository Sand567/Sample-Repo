import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Sharath Nagendra on 11/11/2017.
 */
public class stringSameFrequency {

    public static boolean findFrequency(String s1,String s2){
        Map<Character,Integer> s1map = new HashMap<>();
        Map<Character,Integer> s2map = new HashMap<>();

        if(s1.length()==0 || s2.length()==0 || s1.length()!=s2.length()){
            return false;
        }
        int count=1;
        for(int i=0;i<s1.length();i++)
        {
            if(!s1map.containsKey(s1.charAt(i))){
                s1map.put(s1.charAt(i),count);
            }
            else
                s1map.put(s1.charAt(i),count+1);
        }

        for(int i=0;i<s2.length();i++)
        {
            if(!s2map.containsKey(s2.charAt(i))){
                s2map.put(s2.charAt(i),count);
            }
            else
                s2map.put(s2.charAt(i),count+1);
        }
        return s1map.equals(s2map);

    }

    public static boolean checkIfSame(String s1,String s2){

        if(s1.length()!=s2.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i),1);
        }
        for(int i=0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i)))
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
            else
                return false;

        }
        int val = Collections.max(map.values());
        if(val ==0)
            return true;

        return false;
    }


    public static void main(String[] args) {
        String s1 = "abbcd";
        String s2 ="cdabb";
        int x = 1230;
      //  System.out.println(x%100);
        int length = String.valueOf(x).length();
     //   System.out.println(length);
        int[] a ={1,2,3,4};
        int[] b ={5,6,7,8};
        int[] c ={1,4,7,9};
        //System.out.println(s1.equals(s2));
       //System.out.println(findFrequency(s1,s2));
        int[] newArray = new int[3 * a.length];
        int index = 0;
        for (int n = 0; n< a.length; n++) {
            newArray[index++] = a[n];
            newArray[index++] = b[n];
            newArray[index++] = c[n];
        }

        System.out.println(checkIfSame(s1,s2));
//        for(int i:newArray)
//            System.out.print(i);
    }
}
