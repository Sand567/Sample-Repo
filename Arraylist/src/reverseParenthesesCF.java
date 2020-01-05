import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sharath Nagendra on 1/25/2018.
 */
public class reverseParenthesesCF {
    static String reverseParentheses(String s) {
        String temp = " ", temp2 = " ", rev = " ";
        int i = 0, j = 0;
        while (s.contains("(") || s.contains(")")) {
            i = s.lastIndexOf("(");
            j = s.substring(i).indexOf(")")+(s.length()-s.substring(i).length());
            rev = " ";
            temp = s.substring(0, i);
            for (int k = j - 1; k > i; k--)
                rev += s.charAt(k);
            temp2 = s.substring(j + 1);
            s = temp + rev.trim() + temp2;
        }
        return s;
    }


    //working example
static String anotherReverse(String s) {
    int pos = 0;
    for (int i = pos; i < s.length(); i++) {
        if (s.charAt(i) == '(')
            pos = i;
        else if (s.charAt(i) == ')') {
            String reverse = s.substring(pos + 1, i);
            reverse = new StringBuffer(reverse).reverse().toString();
            s = s.substring(0, pos) + reverse + s.substring(i + 1, s.length());
            i = -1;
        }
    }
    return s;
}
//    static String reverseOnce(String s){
//        String regexp = "\\((?:[^)(]+|\\((?:[^)(]+|\\([^)(]*\\))*\\))*\\)";
//        Pattern p = Pattern.compile(regexp);
//        Matcher m = p.matcher(s);
//        String res="";
//        StringBuilder sb = new StringBuilder();
//        while (m.find()) {
//            System.out.println("Found " + m.group() + " starting at "
//                    + m.start() + " and ending at " + (m.end() - 1));
//          res+=(m.group());
//           // System.out.println(sb);
//        }
//        String[] arr =res.split("");
//        String finalRes = "";
//        for(int i=arr.length-2;i>0;i--)
//        {
//            finalRes+=arr[i];
//        }
////
//        System.out.println(finalRes);
//        String z =s.replaceAll(res,finalRes);
//     //   System.out.println(z);
//     return z;
//    }

    public static void main(String[] args) {
        String s ="a(bcdefghijkl(mno)p)q";
       // reverseOnce(s);
        System.out.println(reverseParentheses(s));
    }
}
