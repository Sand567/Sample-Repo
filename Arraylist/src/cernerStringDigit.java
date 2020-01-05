import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sharath Nagendra on 9/18/2017.
 */
public class cernerStringDigit {

    private static final Pattern VALID_NUMBER = Pattern.compile("[0-9]+");
    private static final Pattern VALID_WORD = Pattern.compile("[a-z]+");

    public static void main(String[] args) {
        String alpha = "8,33,21,0,16,50,37,0,melon,7,apricot,peach,pine,17,21";
        String finalwords = "";
        String finalnumbers = "";
        String finalresult = "";

        Matcher matcher = VALID_NUMBER.matcher(alpha);
        while (matcher.find()) {
            finalnumbers = finalnumbers + matcher.group() + ",";
        }
        finalnumbers = finalnumbers.replaceAll(",$", "");
        Matcher matcher2 = VALID_WORD.matcher(alpha);
        while (matcher2.find()) {
            finalwords = finalwords + matcher2.group() + ",";
        }
        finalwords = finalwords.replaceAll(",$", "");
        if (!finalwords.isEmpty()) {
            finalwords = finalwords + "|";
        }
        finalresult = finalwords + finalnumbers;
        System.out.println("Words and number together\n" + finalresult);
    }
}





