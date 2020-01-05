import java.util.*;

/**
 * Created by Sharath Nagendra on 6/28/2017.
 */
public class find_duplicate_array {
    public static void main(String[] args) {


        int[] arr = new int[]{1,1,1,2,2,3};
        int[] newarr = {1,2,1,3,2,2};
        //Arrays.sort(arr);
      //  duplicate(arr);
        //regex to split the sting into values with commas
        String[] a = Arrays.toString(arr).split("[\\[\\]]")[1].split(", ");
        //  System.out.println(Arrays.toString(a));

        //regex to split string by removing the commas and start and end braces
        String fin = Arrays.toString(a).replaceAll("[\\[, \\]]", "");
    //    System.out.println(fin);
        String x = "sharath";
        //hashtableDup(fin);
        // rev(x);

        // System.out.println(checkDuplicateUsingAdd(a));
        //    System.out.println("no dups");
//        else
//            System.out.println("dups present");
        //System.out.println(removeDuplicates(arr));
//remove element but with atmost 2 duplicates
       // System.out.println(remDup(arr));

       // setRemoveDuplicate(arr);
      System.out.println(anotherRemoveDup(arr));

 //remove all instance of target element
        //targetRemove(newarr,3);


//
//        Map<String,String> map = new HashMap();
//
//        map.put("Father", "Rob");
//        map.put("Mother", "Kirsten");

        // map.remove("Mother");
    }


    //  System.out.println(Arrays.asList(map));



    //remove duplicates using set


    //int[] arr = new int[]{1,2,3,3,3,4,4,4,4};

    public static void setRemoveDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(set.add(arr[i]) ){
                continue;
            }
            else if(set.contains(arr[i]))
            {
                set.remove(arr[i]);
            }
        }

        System.out.println(set);
    }
    public static void hashtableDup(String word) {

        char[] c = word.toCharArray();
        Map<Character, Integer> mymap = new HashMap<Character, Integer>();
        for (Character chars : c) {
            if (mymap.containsKey(chars)) {
                mymap.put(chars, mymap.get(chars) + 1);
            }
            else {
                mymap.put(chars, 1);
            }
        }


        Set<Map.Entry<Character, Integer>> entrySet = mymap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void rev(String x) {
        String res = "";
        char c[] = x.toCharArray();
        for (int i = c.length - 1; i >= 0; i--)
            res = res + c[i];

        System.out.println(res);
    }

    public static boolean checkDuplicateUsingAdd(String[] input) {
        Set tempSet = new HashSet();
        for (String str : input) {
            if (!tempSet.add(str)) {

                return true;
            }
        }
        return false;
    }



public static void duplicate(int[] A){

        if(A.length==0)
            System.out.println("empty array");
        int j=0;
        for(int i=1;i<A.length;i++)
        {
            if(A[i]!=A[j]) {
               // System.out.println(A[j]);
                j++;

            }
            else
                continue;
        }
   //
    //
    //index+1
    //cause we need the number of elements in the array
     System.out.println(j+1);
}

//remove all duplicate occurrences of the array elementl
    public static int anotherRemoveDup(int[] A){

    int i=0,j=0;
    while(j<A.length) {
        if (A[i] == A[j]) {
            j++;
        } else {
           A[++i] = A[j];

            j++;
        }
    }
       for(int x=0;x<i;x++){
           System.out.println(A[x]);
       }
        return i+1;
    }


    public static int removeDuplicates(int[] A) {
        int length = A.length;
        if (length == 0 || length == 1) return length;
        int i = 1;
        for (int j = 1; j < length; j++) {
            if (A[j] != A[j - 1]) {
                A[i] = A[j];
                i++;
            }
        }

        if (i < length) A[i] = '\0';
        return i;
    }

    //remove duplicates at most twice is fine
    public static int remDup(int[] A){
     int prev=1;
     int curr=2;
     while(curr<A.length)
     {
         if(A[curr]==A[prev] && A[prev]==A[prev-1])
             curr++;
         else
         {
             prev++;
             A[prev]=A[curr];
             curr++;
         }

        }
        return prev+1;

    }


    //remove all instances of target
    public static int targetRemove(int[] A,int target){
        if(A.length==0)
            return 0;
        else if(A.length==1)
            return A[0];
        System.out.println("Initial Array Length is: "+A.length);
        int j=0,length=0;
        while(j<A.length)
        {
            if(A[j]!=target){
                length++;
                j++;
            }
            else
            {
                j++;
            }
        }
        System.out.println("Array length after removing target is: "+length);
        return length;
            }



}
