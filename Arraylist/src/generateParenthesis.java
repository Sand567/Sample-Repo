import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 8/27/2017.
 */
public class generateParenthesis {



    public static List<String> generateValidParenthesis(int n){

        List<String> list = new ArrayList<String>();
        genPar("",list,n,n);

        return list;


    }

    public static void genPar(String str, List<String> list, int left, int right){

        if(left>right)
            return;
        if(left>0){
            genPar(str+"(",list,left-1,right);
        }
        if(right>0){
            genPar(str+")",list,left,right-1);

        }
        if(left==0 && right==0){
            list.add(str);
            return;
        }

    }
    public static void main(String[] args) {
        int n=2;
        System.out.println(generateValidParenthesis(n));
    }
}
