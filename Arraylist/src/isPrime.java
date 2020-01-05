import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/8/2017.
 */
public class isPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int n=0;
        for (int a0 = 0; a0 < p; a0++) {
            n = in.nextInt();
            if(isPrime(n)){
                System.out.println("Prime");

            }
            else
            {
                System.out.println("Not prime");

            }
        }

    }

    public static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}