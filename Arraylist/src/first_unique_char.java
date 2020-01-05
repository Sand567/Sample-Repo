/**
 * Created by Sharath Nagendra on 6/27/2017.
 */
public class first_unique_char {
    public static void main(String[] args) {
        System.out.println("index is " + first_char("geeksforgeeks"));
//        int arr[] = {3, 5, 3, 4, 5};
//        int result = 0;
//        for (int i : arr)
//
//            result = result ^ i;
//        System.out.println(result);

    }

    public static int first_char(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
