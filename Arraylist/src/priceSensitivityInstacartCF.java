import sun.rmi.runtime.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sharath Nagendra on 1/28/2018.
 */
public class priceSensitivityInstacartCF {
    static boolean isAdmissibleOverpayment(double[] prices, String[] notes, double x) {

        String percentageValue = "";
        final Pattern pat = Pattern.compile("(\\\\D+)(\\\\d+)(.*)");
        Matcher mm = pat.matcher(notes[0]);

        if (mm.find()) {
            String result=  mm.group();
            System.out.println(result);
        }
        if(prices.length==0 || notes.length==0)
            return false;
        for(int i=0;i<prices.length;i++)
        {

        }

return false;
    }


    public static void main(String[] args) {
        double[] prices = {110, 95, 70};
        int x = 5;
        String[] notes = {"10.0% higher than in-store",
                "5.0% lower than in-store",
                "Same as in-store"};
        System.out.println(isAdmissibleOverpayment(prices,notes,x));
    }
}
