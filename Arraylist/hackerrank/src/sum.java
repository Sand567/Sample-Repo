/**
 * Created by Sharath Nagendra on 11/11/2017.
 */
public class sum {

    public static void findNumbers(int[] arr,int target) {

        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                System.out.println(arr[i] + "," + arr[j]);
                break;
            } else if (sum > target) {
                j--;
            } else
                i++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,5,8,12};
        int target =12;
        findNumbers(arr,target);
//        for(int i:res)
//            System.out.println(i);
    }
}
