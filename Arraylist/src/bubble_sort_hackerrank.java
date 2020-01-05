import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 7/2/2017.
 */
public class bubble_sort_hackerrank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = {3,2,5,1,6,4};
        bubbleSort(a,0,a.length);
        //enhancedBubbleSort(a);
       // printArray(a,0,a.length);
        printNumbers(a);

    }

    public static void enhancedBubbleSort(int[] a){

        for(;;) {
            boolean s = false;
            for(int i=1; i<a.length; i++) {
                int temp=0;
                if(a[i-1] > a[i]) {
                    temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                    s = true;
                }
            }
            if (!s) return;
        }
    }

    public static void bubbleSort(int a[], int start, int end)
    {
        int n = a.length;
        int count=0;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (a[j] > a[j+1])
                {
                    // swap temp and arr[i]
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    count++;
                }
        System.out.println("Array is sorted in "+count+" swaps.");

    }


    public static void printNumbers(int[] a)
    {
        int n = a.length;
        for(int i:a)
            System.out.println(i);
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }

    public static void printArray(int a[], int start, int end)
    {

        for(int i=0;i<=end-1;i++)
            System.out.println(a[i]);

    }
}
