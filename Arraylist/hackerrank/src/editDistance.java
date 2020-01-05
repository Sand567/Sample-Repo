import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 9/16/2018.
 */
public class editDistance {


    public static void editDistanceUsingMap(String s1, String s2) {
        int count = 0;
        int secondCharCount = 0;
        Map<String, Integer> outMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            String s = null;
            if (i == s1.length() - 1) {
                s = s1.substring(i);
            } else {
                s = s1.substring(i, i + 1);
            }
            if (outMap.containsKey(s)) {
                outMap.put(s, outMap.get(s) + 1);
            } else {
                outMap.put(s, 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            String s = null;
            if (i == s2.length() - 1) {
                s = s2.substring(i);
            } else {
                s = s2.substring(i, i + 1);
            }
            if (outMap.containsKey(s)) {
                if (outMap.get(s) > 1) {
                    outMap.put(s, outMap.get(s) - 1);
                } else {
                    outMap.remove(s);
                }
            } else {
                secondCharCount++;
            }
        }

        System.out.println(Math.max(outMap.keySet().size(), secondCharCount));
    }

    public static void main(String[] args) {
//        String s1 = "abcdef";
//        String s2 = "azced";
        String s1 = "pale";
        String s2 = "bae";
        editDistanceUsingMap(s1, s2);

    }
}
