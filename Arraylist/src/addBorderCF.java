import java.util.ArrayList;

/**
 * Created by Sharath Nagendra on 1/28/2018.
 */
public class addBorderCF {

    static String[] addTheBorder(String[] picture){
        ArrayList<String> answer = new ArrayList<String>();
        String decoratedRow ="";
        for (int i = 0; i < picture[0].length() + 2; i++) {
            decoratedRow += "*";
        }
        answer.add(decoratedRow);
        for (int i = 0; i < picture.length; i++) {
            String row = "*";
            for (int j = 0; j < 1; j++) {
                row += picture[i];
            }
            row += "*";
            answer.add(row);
        }
        answer.add(decoratedRow);
        String[] res = new String[answer.size()];
        res = answer.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        String[] picture =  {"abc",
                "ded"};
      //  System.out.println(picture[0].length());
        String[] res =addTheBorder(picture);
        for(String i :res)
            System.out.println(i);
    }
}
