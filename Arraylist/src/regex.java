/**
 * Created by Sharath Nagendra on 7/7/2017.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public class regex {

        public static void main(String[] args)
        {   String s = "";
            String s1 = "";
            Scanner scn  = new Scanner(System.in);
            s = scn.next();
            s1 =scn.next();

//            if (args.length != 2)
//            {
//                System.err.println("usage: java RegexDemo regex input");
//                return;
//            }
            // Convert new-line (\n) character sequences to new-line characters.
           // args[1] = args[1].replaceAll("\\\\n", "\n");
             s1 = s1.replaceAll("\\\\n","\n");
            try
            {
                System.out.println("regex = " + s);
                System.out.println("input = " + s1);
                Pattern p = Pattern.compile(s);
                Matcher m = p.matcher(s1);
                while (m.find())
                    System.out.println("Found [" + m.group() + "] starting at "
                            + m.start() + " and ending at " + (m.end() - 1));
            }
            catch (PatternSyntaxException pse)
            {
                System.err.println("Bad regex: " + pse.getMessage());
                System.err.println("Description: " + pse.getDescription());
                System.err.println("Index: " + pse.getIndex());
                System.err.println("Incorrect pattern: " + pse.getPattern());
            }
        }
    }

