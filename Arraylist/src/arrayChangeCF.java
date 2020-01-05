/**
 * Created by Sharath Nagendra on 2/2/2018.
 */
public class arrayChangeCF {

    public static void main(String[] args) {

        int inputArray[] = {10,9,2,5,3,7,101,18};
        int count = 0;
        for (int i = 0; i < inputArray.length - 1; ++i) {
            if (inputArray[i] >= inputArray[i + 1]) {
                count += Math.abs(inputArray[i + 1] - inputArray[i]) + 1;
                inputArray[i + 1] += Math.abs(inputArray[i + 1] - inputArray[i]) + 1;
            }
        }
        System.out.println(count);
    }
    }