/**
 * Created by Sharath Nagendra on 7/27/2017.
 */
public class binsearch {

    public static int binSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int firstOccurrence = Integer.MIN_VALUE;

        while (low <= high) {
            int middle = (low+high)/2;

            if (arr[middle] == key) {
                // key found and we want to search an earlier occurrence
                firstOccurrence = middle;
                high = middle - 1;

                //for finding last occurrence replace in arr[mid] = key{ high = middle-1 with low= mid+1
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (firstOccurrence != Integer.MIN_VALUE) {
            return firstOccurrence;
        }

        return -(low + 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int start = 0;
        int end = arr.length-1;
        int key = 2;
        System.out.println("The first occurence of "+key+" is at position "+binSearch(arr, 12));
    }
}
