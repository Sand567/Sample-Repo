import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sharath Nagendra on 1/28/2018.
 */
public class patternMatch {


        public static int find(HashMap<Character,String> map, String word, String pattern){
            if(word.isEmpty() && pattern.isEmpty()){
                return 1;
            }
            if(word.isEmpty() || pattern.isEmpty()){
                return 0;
            }
            char c = pattern.charAt(0);
            String w = map.get(c);
            if (w != null){
                if(!word.startsWith(w))
                {
                    return 0;
                }
                return find(map,word.substring(w.length()),pattern.substring(1));
            }
            for(int i = 1 ; i < word.length(); i++){
                String res = word.substring(0, i);
                map.put(c, res);
                if (find(map,word.substring(res.length()),pattern.substring(1))==1){
                    return 1;
                }
                map.remove(c);
            }
            return 0;
        }

    public static byte checkPattern(String patternString, String input) {
        StringBuffer patternBuffer = new StringBuffer();

  /* check input and pattern strings */
        if (patternString == null || input == null) {
            throw new IllegalArgumentException();
        }

  /* pattern character array */
        List<Character> chars = new ArrayList<Character>();
        for (char c : patternString.toCharArray()) {

            if (!chars.contains(c)) {
    /* new character found, append new group */
                patternBuffer.append("(.+)");
                chars.add(c);
            } else {
    /* looking for unique sequence by number */
                patternBuffer.append("\\")
                        .append(chars.indexOf(c)+1);
            }
        }

  /* compiling pattern and checking input string */
        Pattern pattern = Pattern.compile(patternBuffer.toString());
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return 1;
        }

        return 0;
    }



    public static int find1(String word, String pattern){
        return find(new HashMap<Character, String>(),word,pattern);
    }


//    public static int matching(String target, String pattern) {
//
//        int i = 0;
//        int j = 0;
//        int patternLength = pattern.length();
//        for (; i < patternLength; i++) {
//            for (; j < target.length(); j++) {
//                if (pattern.charAt(i) == target.charAt(j)) {
//                    break;
//
//                }
//            }
//            if (j == target.length()) {
//                break;
//            }
//        }
//        if ((j <= target.length()) && (i == patternLength)) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    public static void main(String[] args) {
    //    System.out.println(matching("redbluebluered","abba"));
     //  System.out.println(find1("thequickbrownfox","abcd"));
        int i;
        for(i=0;i<10;){
            i=i++;
            System.out.println(i);

            System.out.println("hello World");
        }
    //    System.out.println(checkPattern("abba","redredredred"));
    }
}
