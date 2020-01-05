import java.util.*;

/**
 * Created by Sharath Nagendra on 11/4/2017.
 */
public class stringManipulation {

    //reduce string
    public static void reducedString(StringBuffer s) {

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s.delete(i - 1, i + 1);
                i = 0;
            }
        }
        if (s.length() == 0) System.out.println("Empty String");
        else System.out.println(s);

    }


    //camelCase
    public static void camelCase(String s) {

        String[] arr = s.split("[A-Z]");

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }


    public static String insertSpaceInMultiCaseStringAtCaps(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : cArray) {
            if (c >= 'A' && c <= 'Z') {
                result.append(" " + c);
            }
            else
                result.append(c);
        }
        return result.toString().trim();
    }

    //replace vowels

    public static String isVowel(String s) {

        char[] list = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i = 0, j = list.length - 1; i < j; ) {
            if (!set.contains(list[i])) {
                i++;
                continue;
            }
            if (!set.contains(list[j])) {
                j--;
                continue;
            }
            char temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;

        }
        return String.valueOf(list);

    }


    static void countVowel(String s) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int vowelCount = 0, consonantCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                vowelCount++;
            } else
                consonantCount++;
        }

        System.out.println("Vowel count is " + vowelCount + " consonant count is " + consonantCount);
    }


    static void charCount(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }

        }
        System.out.println(count);
    }

    static boolean isIPv4Address(String inputString) {
        return inputString.matches("((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?:\\.|$)){4}");
        // return inputString.matches("25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?");
//        String[] res = inputString.split("\\.");
//        System.out.println(Arrays.asList(res));
//        for(int i=0;i<res.length;i++)
//        {
//            if(Integer.parseInt(res[i])<0 || Integer.parseInt(res[i])>255){
//                return false;
//            }
//
//        }
//        return true;
    }

    static boolean anotherisIPv4Address(String inputString) {
        String[] splitString = inputString.split("[.]");
        if (splitString.length > 4) {
            return false;
        }
        for (String string : splitString) {
            if (string.isEmpty()) {
                return false;
            }
            if (!string.matches("[0-9]{1,3}")) {
                return false;
            }
            int number = Integer.parseInt(string);
            if (!(number >= 0 && number <= 255)) {
                return false;
            }
        }
        return true;
    }


    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);

//       char[] ch = s.toCharArray();
//       for(int i=0;i<s.length();i++)
//       {
//
//
//       }

        //   = list.listIterator();


        //-------------------

        String[] res = s.split(" ");
//-------------------------------
//        for(int i=s.length()-1;i>=0;i--)
//            sb.append(s.charAt(i));

        //or

//----------------------------
        sb.reverse().toString();

        //--------------------------

        //  System.out.println(sb.toString());
        // return sb.toString();

//        ArrayList<Character> list = new ArrayList<>();
//        char[] c =s.toCharArray();
//        for(char x: c)
//            list.add(x);
//        Collections.reverse(list);
//        return list.toString();

        char[] c = s.toCharArray();
        String result = "";
        for (int i = c.length - 1; i >= 0; i--)
            result = result + c[i];

        return result;

    }

    public static void main(String[] args) {
        // Scanner stdin = new Scanner(System.in);
        //    System.out.println(isIPv4Address("172.255.254."));
        //StringBuffer s = new StringBuffer(stdin.nextLine());
        String str = "saveInTheEditor";
        //camelCase(str);
          reducedString(new StringBuffer("leetcode"));
//       System.out.println(reverseString("Hello This is a"));
        // System.out.println(isVowel("leetcode"));
        //System.out.println(insertSpaceInMultiCaseStringAtCaps("ThisIsTheString"));
        //charCount("java",'a');
        // countVowel("Java");
    }
}

