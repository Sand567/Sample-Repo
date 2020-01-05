/**
 * Created by Sharath Nagendra on 12/9/2017.
 */
public class longestPalindromicSubString {

    public static String longestPalindrome(String input){
        int max=0;
        String res ="";
        String longest = input.substring(0,1);
        if(input.length() ==0)
            return null;
        if(input.length()<2)
            return null;
        for(int i=0;i<input.length();i++) {
            String x =helper(input,i,i);
            if(x.length()>longest.length())
                longest = x;

            x=helper(input,i,i+1);
            if(x.length()>longest.length())
                longest = x;
//            if(max<x.length()){
//                max=x.length();
//                res=x;
//            }
//            x = helper(input,i,i+1);
//            if(max<x.length()){
//                max=x.length();
//                res=x;
//            }


        }
        return longest;

    }

    public static String helper(String input,int start,int end){
        while(start>=0 && end<input.length() && input.charAt(start)==input.charAt(end)){
            start--;
            end++;
        }
        return input.substring(start+1,end);
    }

    public static void main(String[] args) {
        String input = "cddabbabd";
        System.out.println(longestPalindrome(input));
    }
}
