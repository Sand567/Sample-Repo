/**
 * Created by Sharath Nagendra on 9/18/2018.
 */
public class fib_series {

    public static int recursiveFib(int n){


        if(n<=1)
            return n;

            return recursiveFib(n-1)+recursiveFib(n-2);


    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(recursiveFib(n));
        //        iterativeFib(n);
    }
}
