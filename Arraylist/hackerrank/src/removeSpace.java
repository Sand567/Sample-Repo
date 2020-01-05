/**
 * Created by Sharath Nagendra on 10/6/2017.
 */
public class removeSpace {

    public static void main(String[] args) {
        String str = "move these spaces to the end";
        char ch[] = str.toCharArray();
        //String newString = new String(ch);
        String[] newSTR={"move t"};

        str =str.replaceAll("\\s","");
        System.out.println(str);
    }
}
