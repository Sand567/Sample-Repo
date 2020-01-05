/**
 * Created by Sharath Nagendra on 4/20/2018.
 */
public class shiftString {

    public static String shiftTheString(String s, int left, int right) {
        String result = s.substring(left);
        if (left == 0 && right == 0 && s.length() == 1)
            return s;
        for (int i = 0; i < left; i++) {

            result += s.charAt(i);

        }
        for (int i = 0; i < right; i++) {
            result = result.charAt(result.length() - 1) + result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String newStr = "abcd";
        // newStr = newStr.charAt(newStr.length() - 1) + newStr.substring(0, newStr.length() - 1);
        //System.out.println(newStr);
        System.out.println(shiftTheString(newStr, 1, 2));

    }
}
