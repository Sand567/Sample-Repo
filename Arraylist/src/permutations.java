import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 10/31/2017.
 */
public class permutations {

    public static void permutationCompute(String perm, String word) {

        if (word.isEmpty()) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++)
                permutationCompute(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1));
        }

    }


    static List<String> anagrams(String prefix, String word, List<String> returnVal) {
        if (word.length()==0) {
           // returnVal.add(prefix + word.substring(1));
            returnVal.add(prefix + word);
            return returnVal;
        }
        for (int i = 0; i < word.length(); i++) {
            anagrams(prefix + word.substring(i,i+1),new StringBuilder(word).deleteCharAt(i).toString(), returnVal);
        }
        return returnVal;
    }


    public static void perm(char[] c, int start, int end) {

        //char[] c =s.toCharArray();
        if (start == end) {

            for (char x : c)
                System.out.println(" " + x + " ");
        } else {
            for (int j = start; j <= end; j++) {
                char temp = c[start];
                c[start] = c[j];
                c[j] = temp;

                perm(c, start + 1, end);

                char newtemp = c[start];
                c[start] = c[j];
                c[j] = newtemp;

            }
        }

    }


    public static void main(String[] args) {
        String word = "abc";
        List<String> list = new ArrayList<>();
        char[] c = word.toCharArray();
        // perm(c,0,c.length-1);
        // System.out.println(word.substring(1));
        permutationCompute("", word);
        //System.out.println(anagrams("", word,list));

    }
}
