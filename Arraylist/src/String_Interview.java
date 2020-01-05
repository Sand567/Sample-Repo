import java.util.*;

/**
 * Created by Sharath Nagendra on 11/1/2017.
 */
public class String_Interview {

    //int count = Collections.frequency(new ArrayList<String>(HM.values()), "Red");




    //shortest palindrome
    public static String shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix+mid+suffix;
    }


    //reverse each word in a string
    //eg: i/p:  Java Concept Of The Day
    //o/p: avaJ tpecnoC fO ehT yaD
    public static String revCharsInString(String s) {

        String[] res = s.split(" ");
        String revStr = "";
        for (int i = 0; i < res.length; i++) {
            String word = res[i];
            String revWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                revWord = revWord + word.charAt(j);
            }
            revStr = revStr + revWord + " ";
        }
        return revStr;
    }

    //count number of words
    public static void numberOfWords(String str) {

        String[] res = str.split(" ");
        System.out.println(res.length);
    }

    //count number of occurence of each character
    public static void numberOfCharacters(String str) {
        String[] res = str.split("");
        int count = 0;

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            } else
                count++;
        }
        System.out.println(count);
    }

    //remove space from string
    public static void removeSpaces(String str) {

//        StringBuilder sb = new StringBuilder();
//        char[] ch = str.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            if (ch[i] == ' ')
//                continue;
//            else
//                sb.append(ch[i]);
//        }
//        System.out.println(sb.toString());
        String res = str.replaceAll(" ", "");
        System.out.println(res);
    }

    //frequency of each character in 2 strings
    public static boolean sameFrequency(String s1, String s2) {
//        if(s1.length()!=s2.length())
//            return false;
//        char[] c1= s1.toCharArray();
//        char[] c2 = s2.toCharArray();
//       Arrays.sort(c1);
//        Arrays.sort(c2);
//        return Arrays.equals(c1,c2);

        int[] ans = new int[128];
        int[] ans2 = new int[128];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (char c : s1.toCharArray())
            ans[c]++;
        for (char c : s2.toCharArray()) {
            ans2[c]++;
        }
        return Arrays.equals(ans, ans2);
        // if (--ans[c]!=0) return false;}
        //   return true;


    }

    static String removeBackspaceUtil(String a) {

        int count;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == 'B') {
                count = 1;
                int k = i;

                while (a.charAt(--k) == 'B') {
                    count++;
                }
                if (i != a.length() - 1) {
                    a = a.substring(0, k + 1 - count) + a.substring(i + 1);
                    System.out.println(a);
                } else
                    a = a.substring(0, k + 1 - count);
                //  a =a.substring(k,a.length()-1-(count+1))+a.substring(i+1);
            }
        }
        return a;
    }

    //a ="abBa" b = "aa" op =true
    static boolean areEqual(String a, String b) {
//       String[] arr1 = a.split("B");
//       String[] arr2 = b.split("B");
//
        a = removeBackspaceUtil(a);
        b = removeBackspaceUtil(b);
        return a.equalsIgnoreCase(b);
////       for(String s : arr1)
////           System.out.print(s+" ");
//        for(String s : arr2)
//            System.out.println(s);
//        System.out.println(arr2.length);
//        int count;
//        for (int i = a.length() - 1; i >= 0; i--) {
//            if (a.charAt(i) == 'B') {
//                count = 1;
//                int k = i;
//
//                while (a.charAt(--k) == 'B') {
//                    count++;
//                }
//
//                a = a.substring(0, k + 1 - count) + a.substring(i + 1);
//                System.out.println(a);
//                //  a =a.substring(k,a.length()-1-(count+1))+a.substring(i+1);
//            }
//        }

    }

    //bananas
//bans
    static String removeDups(String s) {
        if (s.isEmpty())
            return null;
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }
        }
        //  System.out.println(set.toString());
        return set.toString();
    }

    public static String maxStringLength(String[] arr) {

        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, s.length());
        }
        System.out.println(map);
        for (int i = 0; i < map.size(); i++) {
            if (map.get(arr[i]).equals(Collections.max(map.values())))
                return arr[i];
        }
        return "";
    }

    public static void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    //reverse words in string O(n) time and O(1) extra space
    public static char[] revWords(String s) {

        char[] ch = s.toCharArray();
        reverse(ch, 0, ch.length - 1);

        int p = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverse(ch, p, i - 1);
                p = i + 1;
            }
        }
        reverse(ch, p, ch.length - 1);
        return ch;
    }

    //Return first occurence of string s in string t
    public static int firstOccurence(String s, String t) {
        char[] ch = s.toCharArray();

        int startIndex = -1;
        int p = 0;
        for (int i = 0; i < t.length() && p < ch.length; i++) {

            if (t.charAt(i) == ch[p]) {
                if (startIndex == -1)
                    startIndex = i;
                p++;
            } else {
                p = 0;
                startIndex = -1;
            }
        }
        return startIndex;

    }


    //look and say number

    public static String lookAndSay(int number) {

        String s = "1";
        for (int i = 1; i < number; i++) {
            s = nextNumber(s);
        }
        return s;

    }

    public static String nextNumber(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();

            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        System.out.println(list);
        return "/" + String.join("/", list);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = 0;

            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }

            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }

            sum += carry;

            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, (char) ((sum % 2) + '0'));

            i--;
            j--;
        }

        if (carry == 1)
            sb.insert(0, '1');

        return sb.toString();
    }

    //if 2 strings are perms
    public static boolean isPerm(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] freq = new int[128];
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (--freq[b.charAt(i) - 'a'] < 0) {
                return false;
            }
//            else
//                freq[b.charAt(i) - 'a']--;
        }
        return true;
    }

    //"123"
    public static int stringToInt(String s) {
        if (s.isEmpty())
            return -1;
        boolean isNegative = false;
        int op = 0;

        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }

        for (int i = 0; i < s.length(); i++) {
            int res = s.charAt(i) - '0';
            op = 10 * op + res;

        }
        if (isNegative) {
            return op * -1;
        }
        return op;
    }

    //123
    public static String intToString(int n) {
        boolean isNegative = false;
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        if (n < 0) {
            isNegative = true;
            n = n * (-1);
        }
        while (n != 0) {
            rem = n % 10;
            sb.append((char) ('0' + rem));
            n = n / 10;
        }
        if (isNegative)
            sb.append("-");

        return sb.reverse().toString();
    }

    //group anagrams
    //called from the main function
    private static final String anagramKey(String word) {

        word = word.toLowerCase();

        char[] chars = word.toCharArray();

        Arrays.sort(chars);

        return new String(chars);

    }



    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);

            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }


    public static int longestConsecutiveCharacter(String s){
        //using staack with extra stack space
        //without stack use 1 loop, compare adjacent element if they are same, increment count and every time check if
        //count is greated than max count, if so update it accordingly. Towards the end, make sure to reset the count to 1


        return -1;
    }



    public static void main(String[] args) {



        String[] strArr = {"race", "acre","care","top","pot","ot"};
       // System.out.println(groupAnagrams(strArr));
        HashMap<String, List> matchMap = new HashMap();

        for(String word :strArr)

        {

            String key = anagramKey(word);

            if (!matchMap.containsKey(key)) {

                matchMap.put(key, new ArrayList());

            }

            matchMap.get(key).add(word);

        }

       // System.out.println(matchMap);


        System.out.println(shortestPalindrome("aacecaaa"));

        // System.out.println(stringToInt("-123"));
       // System.out.println(intToString(-123));
        String a = "abbc";
        String b = "defg";
        //System.out.println(isPerm(a,b));
        String input = "H234";
        String output = "H234";
        // numberOfWords(input);
        //   System.out.println(input.substring(0,0));
        String s1 = "abccda";//aabccd
        String s2 = "cbacda";//aabccd
        //    numberOfCharacters(input);
        // System.out.println(areEqual("abB", "aaBBa"));
        //removeSpaces(input);
        // System.out.println(input==output);

        // System.out.println(revCharsInString(input));
        String ip = "This is a string";

        String[] arr = {"java", "is", "a", "good", "language"};
        // String res = removeDups("bananas");
        //  System.out.println(res);
        //  removeSpaces(ip);

        //System.out.println(maxStringLength(arr));
        //System.out.println(ip);
//        char[] test = revWords(ip);
//        for(char c:test)
//            System.out.print(c+" ");
        // System.out.println(sameFrequency(s1,s2));
        //  System.out.println(lookAndSay(4));
        //System.out.println(simplifyPath("/a/../c/d/./"));
        // System.out.println(firstOccurence("CGC", "GACGACGC"));
        //System.out.println(addBinary("111","11"));

    }
}
