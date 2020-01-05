/**
 * Created by Sharath Nagendra on 8/27/2017.
 */
public class palindrome {

//validate palindrome
    public static boolean isPalindrome(String str) {

        String res = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(res);
        char c[] = res.toCharArray();

        int len = c.length;
        int i = 0;
        int j = len-1;
     //   boolean output = false;
        while (i < j) {
        if(c[i]!=c[j]){
            return false;
        }
        i++;
        j--;
        }
        return true;
    }
//naive approach
    public static void revStr(String str){
        char c[] = str.toCharArray();
        char res[] = new char[c.length];
        int len = c.length-1;

        for(int i=0;i<=len;i++){
            res[i] = c[len-i];
            System.out.print(res[i]);
        }

    }


    public static void revStringbuilder(String str){
        StringBuilder sbuilder = new StringBuilder(str);
        sbuilder.reverse();
        for(int i=0;i<sbuilder.length();i++)
        System.out.print(sbuilder.charAt(i));
    }


    public static void main(String[] args) {
        String input = "Red rum, sir, is murder";
        System.out.println(isPalindrome(input));
        long start1 = System.nanoTime();
        revStr("String");
        long time1 = System.nanoTime() - start1;
        System.out.print("\nString  time = "+time1);
        long start = System.nanoTime();
        revStringbuilder("String");
        long time = System.nanoTime() - start;
        System.out.print("\nString builder time = "+time);

    }
}
