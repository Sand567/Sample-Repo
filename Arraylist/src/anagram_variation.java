/**
 * Created by Sharath Nagendra on 7/1/2017.
 */
public class anagram_variation {

    public static int numberNeeded(String first, String second) {
        int[] af = new int[26];
        int ops = 0;
        for(int i = 0; i < first.length(); ++i) {

            af[first.charAt(i) - 'a']++;
           // System.out.println(af[i]);
        }
            for(int i = 0; i < second.length(); ++i) {
                af[second.charAt(i) - 'a']--;
                //System.out.println(af[i]);
            }
        for (int anAf : af) ops += Math.abs(anAf);
        return ops;
    }

    public static void main(String[] args) {
       // Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        String a = "cat";
        String b = "tab";
        System.out.println(numberNeeded(a, b));
    }
}
