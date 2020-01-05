import java.util.*;

/**
 * Created by Sharath Nagendra on 1/20/2018.
 */
public class maxNumberInArrayCF {

    public static String findMaxArrangement(List<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X+Y;

                String YX = Y+X;

                int res= XY.compareTo(YX)>0? -1:1;
                return res;
            }


        });

        return list.toString();
    }

// 3 30 34 5 9
//3 30 5 34 9
// 3 30 5 9 34
    //30 3
  //  3,5,9,30,34
// 9534303
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
//        String X = "12345";
//        String Y= "54321";
      //  System.out.println(X.compareTo(Y));
        list.add("3");
        list.add("30");
        list.add("34");
        list.add("5");
        list.add("9");
        System.out.println(findMaxArrangement(list));
     }
}
