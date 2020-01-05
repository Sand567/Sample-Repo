/**
 * Created by Sharath Nagendra on 11/27/2017.
 */
public class permOfString {

    public static void computePermutations(String s, String result){

        if(s.isEmpty() ){
            System.out.println(result);
        }
        else {
            for (int i = 0; i < s.length(); i++)
                computePermutations( s.substring(0, i) + s.substring(i + 1),result + s.charAt(i));

        }


    }

    public static void main(String[] args) {
        String s = "xyz";
        computePermutations(s," ");
    }
}
