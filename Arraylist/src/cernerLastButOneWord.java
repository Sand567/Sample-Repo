/**
 * Created by Sharath Nagendra on 9/16/2017.
 */
public class cernerLastButOneWord {


    public static void printLastButOneWord(String input){


        //String res = input.replace(" ","");
        String[] res = input.split(" ");
        String lastbut1word = res[res.length-2];
        System.out.println(lastbut1word);
       // System.out.println(input.substring(input.lastIndexOf(" ")+1));
    }

    public static void main(String[] args) {
        String input = "This is the demo sentence";
        printLastButOneWord(input);

    }
}
