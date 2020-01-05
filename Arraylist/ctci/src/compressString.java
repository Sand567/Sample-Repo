import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 11/2/2017.
 */
public class compressString {

    public static void stringCompress(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], 1);
            } else
                map.put(ch[i], map.get(ch[i])+1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            sb.append(entry.getKey()+""+entry.getValue());

            }

        System.out.println(sb.toString());

    }




    public static int lengthOfLastWord(final String a)
    {
        int len = 0;

		/* String a is 'final'-- can not be modified
		So, create a copy and trim the spaces from
		both sides */
        String x = a.trim();
        //System.out.println(x);

        for (int i=0; i<x.length(); i++)
        {
            if (x.charAt(i) ==' ')
                len = 0;
            else
                len++;
        }

        return len;
    }

    public static String checkCompress(String str) {

        int count=0;
        String res = "";
        for(int i=0;i<str.length();i++)
        {
            count++;
            if(i+1>=str.length()|| str.charAt(i)!=str.charAt(i+1)){
                res=res+str.charAt(i)+ count;
                count=0;
            }

        }
        //return res;
        return res.length()<str.length()?res:str;
    }


    public static void main(String[] args) {
        String str = "aabcccccaaa";
        String test = "This is a string";
       System.out.println( checkCompress(str));
        //System.out.println(lengthOfLastWord(test));
        //stringCompress(str);
    }
}
