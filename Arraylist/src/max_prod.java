/**
 * Created by Sharath Nagendra on 6/27/2017.
 */
public class max_prod {

    public static void main(String[] args) {
        int arr[] = {2, 5, 13, 4, 9};
        int n = arr.length;
        long startTime = System.nanoTime();
        //int p = maxProd(n, arr);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        //System.out.println(p + "the total time taken is " + totalTime + "ms");
        System.out.println(efficientMaxProduct(arr));

    }

//    public static int maxProd(int n, int arr[]) {
//        if (n < 3)
//            return -1;
//
//        for (int pass = n - 1; pass >= 0; pass--) {
//
//            for (int i = 0; i < pass; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//
//        }
//        int x = arr[n - 1] * arr[n - 2] * arr[n - 3];
//        return x;
//    }

    public static int efficientMaxProduct(int[] a) {

        int first, second, third;
        if (a.length < 3)
            return -1;
        first = second = third = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > first) {
                third = second;
                second = first;
                first = a[i];
            } else if (a[i] > second) {
                third = second;
                second = a[i];
            } else if (a[i] > third)
                third = a[i];


        }
        return first*second * third;

    }
}


