/**
 * Created by Sharath Nagendra on 11/2/2017.
 */
public class isUnique {


    public static int checkUnique(String s){


        //char[] ch = str.toCharArray();
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


    public static void main(String[] args) {
        //it gives error is space is there as there is no ascii comparison with space
        System.out.println(checkUnique("tisisstingx"));
    }
}
