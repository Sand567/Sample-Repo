import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/1/2017.
 */
public class leftRotateArray_rightRotate {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
//        int x[] = new int[2];
//        for(int o =0;o<2;o++)
//           x[o] = scn.nextInt();
//
//        int[] arr = new int[x[0]];
//        System.out.println("enter array elements");
//        for(int q =0;q<7;q++)
//            arr[q] = scn.nextInt();

        int[] newArr = {1, 2, 3, 4, 5};
        //leftRotate(arr,x[1]);
        // leftRotate(newArr,2);
//        rightRotate(newArr, 2);
//        printArray(newArr);
        rightRotateBy1Index(newArr);
//        for(Integer p : x)
//            System.out.println(x[p]);

    }

    //for right rotate by 1 index use the below method

    public static void rightRotateBy1Index(int[] arr){

        int lastElement = arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){

            arr[i]=arr[i-1];
        }
        arr[0]=lastElement;
        System.out.println(java.util.Arrays.toString(arr));

    }

    private static void rightRotate(int[] arr, int p) {


        p = p % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, p - 1);
        reverse(arr, p, arr.length - 1);
    }

    private static void printArray(int[] arr) {

        System.out.println(java.util.Arrays.toString(arr));
    }


    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void leftRotate(int arr[], int d) {

        d = d % arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
}


