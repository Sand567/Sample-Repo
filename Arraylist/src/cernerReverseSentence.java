/**
 * Created by Sharath Nagendra on 9/16/2017.
 */
public class cernerReverseSentence {

    public static void main(String[] args) {


        //no 0(1) space complexity but O(n) time complexity
        String input = " This is the sentence to be reversed";
        long startTime2 = System.nanoTime();
        String print = reverseEfficient(input);
        long endTime2 = System.nanoTime();
       // System.out.println(print);

        String[] arr = input.split(" ");
        String[] output = new String[arr.length];
        long startTime = System.nanoTime();

        for (int i = arr.length - 1; i > 0; i--) {
            output[i] = arr[i];
            System.out.println(output[i]);
        }
        long endTime = System.nanoTime();
//        System.out.println("1 Took " + (endTime - startTime) + " ms");
//        System.out.println("2 Took " + (endTime2 - startTime2) + " ms");

    }


    //better complexity with no extra array
    public static String reverseEfficient(String input) {
        if (input.isEmpty() || input == null || !input.contains(" ")) {
            return null;
        }
        String reversed = "";
        for (String word : input.split(" "))
            reversed = word + "" + input;
            return reversed;

    }
}






