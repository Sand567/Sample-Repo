/**
 * Created by Sharath Nagendra on 10/17/2017.
 */
public class ImprovedRansomNote {


    public static boolean ransom(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++)
            arr[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine ="aab";

        System.out.println(ransom(ransomNote,magazine));

    }
}
