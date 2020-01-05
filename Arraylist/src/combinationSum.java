import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 8/25/2017.
 */
public class combinationSum {

    public static void partition(int n) {
        partition(n, n, "");
    }
    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println((prefix));
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, prefix + " " + i);
        }
    }





    public static boolean checkSwapPalindrome(String s) {
        char[] c = s.toCharArray();
        Map map = new HashMap();
        int odds = 0;
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], 1); // put initial value
                odds++;
            } else {
                int val = (int) map.get(c[i])+1;

                if (val % 2 == 0) {
                    odds--;
                } else {
                    odds++;
                }

                map.put(c[i], val); // update counters
            }
        }
        return odds == 0 || odds == 1;
    }


    public static void main(String[] args) {
        int N =10;
        partition(N);
        System.out.println(checkSwapPalindrome("rotr"));
    }

}
