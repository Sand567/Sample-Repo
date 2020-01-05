/**
 * Created by Sharath Nagendra on 11/4/2017.
 */
public class missingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7};//23
        int n = arr.length+1;
        int Actualsum = 0;//28-23




        int expectedSum= n*(n+1) / 2;//28

        for(int i=0;i<arr.length;i++)
            expectedSum = expectedSum-arr[i];
        System.out.println("Expected Sum is: "+expectedSum);
        //System.out.println("Actual sum is: " +Actualsum);




    }


}