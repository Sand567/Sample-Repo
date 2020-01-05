import java.util.*;

/**
 * Created by Sharath Nagendra on 12/5/2017.
 */
public class test_array {
    //ans to q top 30 array q
    //1) will work only if the array elements are in a range

    public static void checkDUP(int[] arr, int n) {
        //doesnt handle zero case, if the array has a 0
//        int i;
//        for (i = 0; i < arr.length; i++) {
//            if (arr[Math.abs(arr[i])] >= 0)
//                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
//            else
//                System.out.println(( Math.abs(arr[i])));
//        }

        //this code handles case of zero
        //{1,2,3,4,5,5,6,2};
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] = arr[index] + n;
        }

        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1)
                System.out.println(i);
        }


    }

    //2
    public static int findMissingNumber(int[] arr) {
        int arrayNumbers = arr[0];
        int naturalNumbers = 1;

        for (int i = 1; i < arr.length; i++) {
            arrayNumbers = arrayNumbers ^ arr[i];
        }
        for (int i = 2; i <= arr.length + 1; i++) {
            naturalNumbers = naturalNumbers ^ i;
        }


        return naturalNumbers ^ arrayNumbers;

    }

    //if the array is sorted then we can use binary search to find the first and last occerrences. in o(log(n)) time and o(1) space
    //3 return 1st occuerence of the element :: o(N) time and O(N) space
    //for returning last occurrence of the element use Set
    public static int returnIndex(int[] a, int target) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++)
            map.put(a[i], i);
        if (map.containsKey(target))
            return map.get(target);
        else
            return -1;


    }

    //4 return the smallest and largest value in array BOTH IMPLEMENTATIONS WORK
    public static String smallestAndLargest(int[] a) {
        //3 1 4 2
        if (a.length == 0)
            return null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++, j--) {
//            if (a[i] > a[j]) {
//                if (a[i] > max)
//                    max = a[i];
//
//                if (a[j] < min)
//                    min = a[j];
//            } else if (a[j] > a[i]) {
//                if (a[j] > max)
//                    max = a[j];
//                if (a[i] < min)
//                    min = a[i];
//            } else
//                continue;
//
//
//        }

        for (int num : a) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
//
//        System.out.println(max);
//        System.out.println(min);
        String res = "Max is:" + Integer.toString(max) + "   Min is:  " + Integer.toString(min);
        return res;
    }


    //5) return all pairs of numbers which sum upto target

    public static void targetSum(int[] a, int target) {
        if (a.length < 2)
            return;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            int newTarget = target - a[i];
            if (!set.contains(newTarget))
                set.add(a[i]);
            else
                System.out.println(a[i] + " " + newTarget);

        }


    }

    //remove dup from unsorted array
    public static int removeDUP(int[] a) {
        Set<Integer> set = new HashSet<Integer>();
        int len = a.length;
//        int j = 0;
//        for (int i = 0; i < a.length; i++)
//            if (!set.contains(a[i])) {
//                set.add(a[i]);
//                a[j++] = a[i];
//            }
//        return j;
        for (int i = 0; i < a.length; i++) {
            if (set.add(a[i]) == false) {
                len = len - 1;
            }
        }
        return len;
    }

    public static int[] intersectionArray(int[] a, int[] b) {

        if (a.length == 0 || b.length == 0) {
            return null;
        }
        int k = 0;
//        int[] res = new int[(a.length < b.length ? a.length : b.length)];
        Set<Integer> set = new HashSet<>();
        Set<Integer> secondset = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int j = 0; j < b.length; j++) {

            if (set.contains(b[j]))
                secondset.add(b[j]);

        }
        int[] res = new int[secondset.size()];
        int x = 0;
        for (Integer num : secondset)
            res[x++] = num;
        return res;
    }
/*    Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    key = 3
    Output : Found at index 8*/

    public static int searchInRotatedArray(int[] a, int low, int high, int key) {

        if (low > high)
            return -1;


        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key)
                return mid;

            if (a[low] <= a[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
                if (key >= a[low] && key <= a[mid])
                    high = mid - 1;

                else
                    low = mid + 1;
            }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
            if (a[mid] <= a[high]) {
                if (key >= a[mid] && key <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }
        return -1;
    }

    //2333 per credit 27 63000usd, 20 months
    public static int returnRotateArray(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key)
                return mid;
            if (key <= a[mid] && key >= a[low] && a[low] <= a[mid]) {
                high = mid - 1;
            } else
                low = mid + 1;

            if (a[mid] <= a[high] && key >= a[mid] && key <= a[high]) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    //given a rotated sorted array, find how many rotations have to be made to sort the array


    public static void rotateToOrderArray(int[] arr) {
        int low = 0, i = 0;
        int high = arr.length - 1;
        while (arr[i] < arr[i + 1]) {
            i++;
        }
        int value = arr.length - i - 1;
        System.out.println("The number of times the array has to be rotated is : " + value);

        reverseHelper(arr, value);
        System.out.println("the sorted array is");
        for (Integer x : arr) {
            System.out.println(x);
        }

    }

    public static void reverseHelper(int[] arr, int value) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, value - 1);
        reverse(arr, value, arr.length - 1);
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

    //rotate array A by B times to the right
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {


            ret.add(A.get((i + B - 1) % A.size()));
            //System.out.println(ret.get(i));
        }

        return ret;
    }

    public static void duplicateBest(int[] a) {
// First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < a.length; i++) {
            int index = a[i] % a.length;
            a[index] += a.length;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < a.length; i++) {
            if ((a[i] / a.length) > 1)
                System.out.println(i);
        }

    }

    public static int dupEasy(int[] a) {
        int[] counter = new int[a.length];
        // Then iterate read and increment the counter:
        for (int i = 0; i < a.length; i++) {
            if (counter[a[i]] > 0) {
                // duplicate
                return a[i];
            } else {
                counter[a[i]]++;
            }
        }
        return -1;
    }

//    Input : arr[] = {1, 2, 4, 5, 6, 6, 8, 9}
//    Target number = 11
//    Output : 9

    public static int returnSmallest(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        // int mid=0;
        if (target < a[low])
            return a[low];
        if (target > a[high])
            return a[high];

        while (low < high) {
            int mid = (low + high) / 2;
            int d1 = Math.abs(a[mid] - target);
            int d2 = Math.abs(a[mid + 1] - target);
            if (d2 <= d1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return a[high];

    }

    static int equilibriumIndex(int[] arr) {

        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
            if (sum == leftSum)
                return i;
            else
                leftSum = leftSum + arr[i];
        }
        return -1;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for (int i : nums) {
            q.offer(i);

            System.out.println(q);
            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthSmallestElement(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            priorityQueue.offer(array[i]);
        }
        System.out.println("Final priority-queue " + priorityQueue);
        int currentNo = 0;
        while (k > 0) {
            currentNo = priorityQueue.poll();
            k--;
        }
        return currentNo;
    }

    static int findDupIndex(int[] arr) {
        int[] a = {1, 2, 3, 4, 5, 5, 6};
        int k, i, j = 0;
        int n = 6;

        for (i = 1; i <= n; i++) {
            j = j ^ i;
        }

        for (k = 0; k < a.length; k++) {
            j = j ^ a[k];
        }
        return j;
    }

    static int pivotElement(int[] a) {
        int sum = 0, leftSum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        for (int i = 0; i < a.length; i++) {
            if (sum - a[i] - leftSum == leftSum) {
                return i;

            } else {
                leftSum += a[i];
            }
        }
        return -1;
    }

    static void frequencyOfAllNums(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], count + 1);
            }

        }
        for (Map.Entry<Integer, Integer> mentry : map.entrySet()) {

            System.out.println(mentry);

        }
    }

    static int maximumSubarraySum(int[] a) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {


            sum += a[i];
            if (sum > maxSum)
                maxSum = sum;
            else if (sum < 0)
                sum = 0;

        }
        return maxSum;

    }

    public static void topTwo(int[] numbers) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
            } else if (number > max2) {
                max2 = number;
            }
        }
        System.out.println("Max :" + max1 + " Second Max :" + max2);
    }
//Q1:modify the binary search problem
//Q3:remove a pair of characters from a string if they occur consecutively7+

//Q2
    public static int[] retArray(int N) {

        int[] arr = new int[N];
        int half;
        if (N % 2 == 0) {
            half = N / 2;
        } else {
            half = (N / 2) + 1;
        }

        int val = 1;
        for (int i = 0; val <= N / 2; i++) {
            arr[i] = val;
            arr[i + half] = -val;
            val += 1;
        }
        return arr;
    }

    static void printMissing(int[] a, int min, int max) {

        int LIMIT = max+1;

        boolean seen[] = new boolean[LIMIT];

        // Mark present elements in range [0-99] as seen
        for (int i = 0; i < a.length; i++) {
            if (a[i] < LIMIT)
                seen[a[i]] = true;
        }
        // Print missing element
        int i = min;
        while (i < LIMIT) {
            // If i is missing
            if (seen[i] == false) {
                // Find if there are more missing elements after i
                int j = i + 1;
                while (j < LIMIT && seen[j] == false)
                    j++;

                // Print missing single or range
                int p = j - 1;
                System.out.println(i + 1 == j ? i : i + "-" + p);

                // Update i
                i = j;
            } else
                i++;
        }
    }

    //It may be assumed that the given date is in range from 01/01/1800 to 31/12/9999.

    //21/2/2012
    public static boolean isDateValid(int d,int m,int y){
        if(d<1 || m<1 ||y<1800 || y>9999 || d>31 || m>12 ){
            return false;
        }
        if(m==2){
            if(isLeap(y))
                return d<=29;
            else
                return d<=28;
        }
        if(m==1 || m==3 || m==5|| m==7| m==8||m==10||m==12){
            return d<=31;
        }
        return true;
    }

    static boolean isLeap(int y){
        if(y%4==0){
            return true;
        }
        return false;
    }

    //merge k sorted arrays use priority queue. can also use naive method, but higher complexity
    //merge k sorted linked lists also works the same way. Use priority queue to

    //merge sorted arrays
//    Input :  arr1[] = { 1, 3, 4, 5}
//             arr2[] = { 2, 4, 6, 8}
    //Output : arr3[] = {1, 2, 3, 4, 5, 6, 7, 8}
    // O(n)+O(n) time, O(a+b) space
    public static int[] mergeSorted(int[] a,int[] b){
        int i=0,j=0,k=0;
        int[] res = new int[a.length+b.length];
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                res[k++] = a[i++];
            }
            else
                res[k++] = b[j++];
        }
        while(i<a.length){
            res[k++] =a[i++];
        }

        while(j<b.length){
            res[k++] =b[j++];
        }
        return res;
    }

    //merge 2 sorted arrays back into 1st array

    public static int[] InplaceMergeSorted(int[] a,int[] b){
        int n = b.length;
        int m = a.length-b.length;
        int k =m+n-1;
        while(m>0 && n>0){
            if(a[m-1]>b[n-1]){
                a[k--] = a[m-1];
                m--;
            }
            else{
                a[k--] = b[n-1];
                n--;
            }
        }
        if(n>0){
            a[k--] = a[n-1];
            n--;
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    static int reverseRecursive(int number, int sum) {
        if (number != 0) {
            int temp = number % 10;
            sum = sum * 10 + temp;
            return reverseRecursive((number / 10), sum);
        } else
            return sum;

    }

    public static String newStr(int n){
        String modStr="";
        int i=n;
        int j=1;
        if(n>1){
            i=n+1;
        }
        else
        i=n;
        modStr+=1;
        while((modStr.length()<1))
        modStr+=1;
        return modStr;
    }

    public static int[] add1toArray(int[] a){
        if(a.length==0)
            return null;
        int[] res = new int[a.length];
        int carry=1;
        for(int i=a.length-1;i>=0;i--){
            int sum=carry+a[i];
            if(sum>=10){
                carry = sum/10;
                sum=sum%10;
                res[i]=sum;
            }
            else
            {
                carry=0;
                res[i]=sum;
            }
        }
        if(carry==1){
            res= new int[a.length+1];
            res[0] = 1;
        }
        return res;

    }

    /* find the smallest element in a rotated sorted array
To understand the boundaries, use the following 3 examples:
[2,1], [2,3,1], [3,1,2]
*/
    public static int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            if(nums[i]<=nums[j])
                return nums[i];

            int m=(i+j)/2;

            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return -1;
    }




    public static void main(String[] args) {

    //    System.out.println(newStr(8));
//        int[] op =add1toArray(new int[]{9,9,9,9});
//        for(int i:op)
//            System.out.println(i);
        int[] arr = {601, 602, 603, 604, 605, 605, 606, 607};
        int[] finalarr = {1, 2, 3, 4, 5, 5, 6, 2};
        //int[] arrayListArray = { 14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35 };
        int[] arr2 = {2, 3, 1, 4, 1, 5, 2};
        int[] testArr = {4, 8, 2, 5, 7};
        int newARR[] = {1, 6, 3, 1, 3, 6, 6};//if the numbers are in a range, say from 1-n
        int[] myArr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arraay = {1, 3, 2, 5, 4};
        int equiarr[] = {-7, 1, 5, 2, -4, 3, 0};
        //System.out.println(equilibriumIndex(new int[]{1,7,3,6,5,6}));
        int[] kthlargest = {3, 2, 1, 5, 6, 4};
        //System.out.println(findKthLargest(kthlargest,3));
        //System.out.println(findKthSmallestElement(kthlargest,2));
        //rotateToOrderArray(testArr);
        //System.out.println(findDupIndex(arr));
        // System.out.println(returnRotateArray(myArr,5));
        //  System.out.println(findMissingNumber(arr));
        Integer[] array = {1, 2, 3, 4, 5};
        //frequencyOfAllNums(finalarr);

        int[] missing = {2,4,5,10};
        //printMissing(missing, 0, 9);

        int[] a = new int[]{1,3,4,5,-1,-1,-1,-1};

        //a={1,3,4,5};
        int[] b ={2,4,6,8};
        //int[] res = mergeSorted(a,b);
//        for(int i:res)
//            System.out.println(i);

        InplaceMergeSorted(a,b);
        //System.out.println(isDateValid(29,2,2001));
//        int[] test_array = retArray(5);
//        for(int i:test_array)
//            System.out.println(i);
        //System.out.println(reverseRecursive(123,0));
//        ArrayList<Integer> list = new ArrayList<Integer>(array.length);
//        Collections.addAll(list, array);
//        System.out.println(rotateArray(list,3));
        //duplicateBest(newARR);
        //   System.out.println(dupEasy(newARR));
        // System.out.println(returnSmallest(new int[]{1,2,4,5,6,6,8,9},7));
//         int n = removeDUP(newARR);
//        System.out.println(n);
        //   int[] arraay = {3,4,5,1,2};
        //  rotateToOrderArray(arraay);
//        int res[] =intersectionArray(arr,testArr);
//        for(int i:res)
//            System.out.println(i);
//        for (int i = 0; i < n; i++)
//            System.out.println(newARR[i]);
        //checkDUP(finalarr,finalarr.length);
        // System.out.println(returnIndex(arr2,2));
        //  System.out.println(findMissingNumber((arr2)));
        //  System.out.println(smallestAndLargest(arr));
        //targetSum(testArr, 12);
        // checkDUP(finalarr,6);
        // topTwo(new int[]{20,34,21,87,92,10});
        //System.out.println(pivotElement(new int[]{1,7,3,6,5,6}));
         // System.out.println(searchInRotatedArray(myArr, 0, myArr.length - 1, 3));


//        System.out.println(maximumSubarraySum(new int[]{1,-3,2,1,-1}));
    }
}
