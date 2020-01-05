import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Sharath Nagendra on 11/11/2017.
 */
public class longestSubsrting {

//longest substring without repeating characters
    public static int findMaxSubstring(String s){

        if(s.length()==0 || s==null)
            return 0;
        Set<Character> set = new HashSet<>();
        int j=0,max=0,i=0;
        while(j<s.length()){
            if(set.add(s.charAt(j))){
                max = Math.max(max,set.size());
                j++;
            }
            else
            {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }


    public static int substringlength(String s){
        Set<Character> set = new LinkedHashSet<>();
        int length=0;
        for(int i=0;i<s.length();i++)
        {
            if(set.add(s.charAt(i))){
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {


        String s ="dbaabcd";
        //output = dba = length=3
       System.out.println(findMaxSubstring(s));
        //System.out.println(substringlength(s));
    }
}
