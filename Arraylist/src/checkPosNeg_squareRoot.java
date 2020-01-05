/**
 * Created by Sharath Nagendra on 6/27/2017.
 */
public class checkPosNeg_squareRoot {

    public static void main(String[] args) {
        int x =225;
   if(x<0)
       System.out.println("neg");
   else
       System.out.println("");
   // see book for more methods
        int t;

        int squareRoot = x ;

        do {
            t = squareRoot;
            squareRoot = (t + (x / t)) / 2;
        } while ((t - squareRoot) != 0);
        System.out.println(squareRoot);

    }
}
