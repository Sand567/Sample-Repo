import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/1/2017.
 */
public class ransome_note {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        String magazine[] = new String[m];
//        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
//            magazine[magazine_i] = in.next();
//        }
//        String ransom[] = new String[n];
//        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
//            ransom[ransom_i] = in.next();
//        }

        String[] ransom = {"aa"};
        String[] magazine = {"ab"};
        System.out.println(ransomNoteFunction(ransom, magazine));

    }








    public static boolean ransomNoteFunction(String[] ransom, String[] magazine) {

        String ransomString = Arrays.toString(ransom);
        String magazineString = Arrays.toString(magazine);

        Map<Character, Integer> magM = new HashMap<>();
        for (char c:magazineString.toCharArray()){
            int newCount = magM.getOrDefault(c, 0)+1;
            magM.put(c, newCount);
        }
        for (char c:ransomString.toCharArray()){
            int newCount = magM.getOrDefault(c,0)-1;
            if (newCount<0)
                return false;
            magM.put(c, newCount);
        }
        return true;

    }
}
//



