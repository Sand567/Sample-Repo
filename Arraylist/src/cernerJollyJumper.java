import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 9/16/2017.
 */
public class cernerJollyJumper {




//    private static void jollyJumper(int[] arr) {
//        int[] res= new int[arr.length-1];
//        for(int i=0;i<arr.length-1;i++){
//            res[i] = Math.abs(arr[i+1]-arr[i]);
//        }
//        int flag=0;
//        int temp = res[0];
//        for(int i=1;i<res.length;i++)
//        {
//            temp = res[i-1];
//            if(res[i] + 1!= temp) {
//                System.out.println("Not a jolly jumper");
//                flag =1;
//                break;
//            }
//        }
//        if(flag==0)
//        {
//            System.out.println("A jolly jumper");
//        }
//    }




    public static void main(String[] args) {


        int arr[] = {1,4,2,3};

            HashSet<Integer> hs = new HashSet<Integer>();

            for (int i = 0; i < arr.length - 1; i++) {
                int abs = Math.abs(arr[i + 1] - arr[i]);
                if (abs <= arr.length - 1 && abs > 0)
                    hs.add(abs);
                else {
                    break;
                }
            }
            if (hs.size() == arr.length - 1)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");

        }
       // jollyJumper(arr);
    }

