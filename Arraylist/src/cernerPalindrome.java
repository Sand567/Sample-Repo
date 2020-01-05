/**
 * Created by Sharath Nagendra on 9/16/2017.
 */
public class cernerPalindrome {

    public static int reversenumber(int num) {
        int rev = 0;
        int rem;
        while (num != 0) {
            rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return rev;
    }

    public static boolean isPalin(int num) {

        int rev = reversenumber(num);
        if (rev == num) {
            return true;
        }
        return false;
    }

    public static void addreversednumber(int num) {

        int count = 0;
        System.out.println("Input is:" + num);
        if (isPalin(num)) {
            System.out.println("This num is already a palindrome");
        } else {

            while (!isPalin(num)) {
                count++;
                int reverse = reversenumber(num);
                System.out.println("reversed number is:" + reverse);
                int sum = num + reverse;
                System.out.println("sum of number + reversed is:" + sum);
                num = sum;
            }
            System.out.println("This is the palindrome");
        }
        System.out.println(count);
    }


    public static void main(String[] args) {

        int num = 7325;
        addreversednumber(num);
    }
}






















































//    public static void revThisnumber(int num) {
//     reversenumber(num);
//        System.out.println("Input is:" + sum);
//        System.out.println("Reversed number is:" + rev);
//        sum = sum + rev;
//        System.out.println("input+reversed sum:" + sum);
//        if (isPalin(sum)) {
//            System.out.println("palindrome");
//        } else
//            {
//            System.out.println("not a palindrome");
//
//            while (!isPalin(sum))
//            {
//                count++;
//                int reverse = revThisnumber(sum);
//
//                int newsum = sum + reverse;
//
//                System.out.println(sum + " + " + reverse + " = " + newsum);
//
//                sum = newsum;
//            }
//        }
//        System.out.println("count = " + count);
//        return rev;
//    }
