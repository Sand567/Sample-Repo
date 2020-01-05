import java.util.*;
import java.*;
/**
 * Created by Sharath Nagendra on 6/27/2017.
 */
public class find_duplicates {
    public static void main(String[] args) {
        Set<Character> myset = new HashSet<>();
        String x = "geeksforgeeks";



        //--------------------------------------------------------
        //regex to check if number is binary or not
        int number =0000;
        boolean b=  Integer.toString(number).matches("[01]*");
        System.out.println(b);
        //--------------------------------------------------------


       // char c[] = x.toCharArray();
        for(int i=0;i<x.length();i++)
        {
            if(myset.add(x.charAt(i)) == false)
            {
                System.out.println("the  non unique element is "+ x.charAt(i));
            }

        }
    }



}
