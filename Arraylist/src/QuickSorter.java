/**
 * Created by Sharath Nagendra on 2/23/2018.
 */
import java.util.Arrays;

public class QuickSorter {

    public void sort(int[] data) {
        quicksort(data, 0, data.length-1);
    }

    public void quicksort(int[] data, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(data, start, end);
            quicksort(data, start, pivotIndex-1);
            quicksort(data, pivotIndex+1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        int pivot = data[end];
        int i = start-1;
        for (int j = start; j < end; j++) {
            if (data[j] <= pivot) {
                i++;
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;

            }
        }
        int temp =data[i+1];
        data[i+1] = data[end];
        data[end]=temp;
        return i+1;

//        data[end] = data[i];
//        data[i] = pivot;
//        return i;
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        new QuickSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }

}

