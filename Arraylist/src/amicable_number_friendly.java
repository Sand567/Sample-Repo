import java.util.*;

/**
 * Created by Sharath Nagendra on 7/7/2017.
 */
public class amicable_number_friendly {

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int number = scn.nextInt();
//        int number2 = scn.nextInt();
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int i = 1; i <= number; i++)
//            if (number % i == 0) {
//                System.out.println("the factors are of num1: " + i);
//                sum1 = sum1 + i;
//            }
//
//        for (int i = 1; i <= number2; i++)
//            if (number2 % i == 0) {
//                System.out.println("the factors are of num2: " + i);
//                sum2 = sum2 + i;
//            }
//
//        if (sum1 == number2 && sum2 == number) {
//            System.out.println("amicablenumber");
//        }
//
//        System.out.println("sum1 = " + sum1);
//        System.out.println("sum2 = " + sum2);
        String[] test ={"cheating","teaching","dale","alde","c"};
        System.out.println(groupAnagrams(test));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}



