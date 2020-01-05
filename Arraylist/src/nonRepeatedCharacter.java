import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 10/7/2017.
 */
public class nonRepeatedCharacter {

    public static void main(String[] args) {
        String s = "aabbcddeeff";
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < ch.length; i++) {
            if (!map.containsKey(ch[i]))
                map.put(ch[i], count);

            else
                map.put(ch[i], count + 1);

        }
        Integer intValue=1;
        System.out.println(Arrays.asList(map)); // method 1
        System.out.println(map.size());
        System.out.println(map.get('c'));
        for(Map.Entry entry: map.entrySet()){
            if (intValue.equals(entry.getValue())) {
                char c = (char) entry.getKey();
                System.out.println(c);
                break; //breaking because its one to one map
            }
        }


      //  Read more: http://javarevisited.blogspot.com/2013/02/how-to-get-key-from-value-in-hashtable.html#ixzz57DWWDNMf


         //   Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
//


        }   //

    }


