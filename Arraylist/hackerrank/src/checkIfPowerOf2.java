/**
 * Created by Sharath Nagendra on 11/12/2017.
 */
public class checkIfPowerOf2 {

    public static boolean checkifPower(int input) {

        if (input == 1) {
            return true;
        }
        return (input & input - 1) == 0;
    }


    public static void main(String[] args) {
        int input = 2;
        System.out.println(checkifPower(input));
    }
}
