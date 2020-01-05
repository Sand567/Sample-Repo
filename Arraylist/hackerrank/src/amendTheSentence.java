/**
 * Created by Sharath Nagendra on 1/25/2018.
 */
public class amendTheSentence {


    static String amendTheSentence(String s) {

        if (s.length() == 0)
            return null;
        String res = "";
        res += Character.toString(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res += " " + s.charAt(i);
            } else
                res += s.charAt(i);
        }
        return res.toLowerCase();
    }

    public static void main(String[] args) {
        String s = "ThisIsMyLife";
        System.out.println(amendTheSentence(s));
    }
}
