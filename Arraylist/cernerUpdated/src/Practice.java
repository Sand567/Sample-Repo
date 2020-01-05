/**
 * Created by Sharath Nagendra on 10/16/2017.
 */
public class Practice {

    public static void function(int[] arr){
        arr[0] = 34;
    }

    public static void main(String[] args) {
        //String str = "Hello ";
        int[] str = {45, 25, 35};
//        Integer str = 10;
        function(str);
        System.out.println(str[0]);
    }
}
