import java.util.*;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class longestSequence {

    public static void main(String[] args) {
        int arr[] = {100,4,200,1,3,2,101,102,103,104};
         longestFind(arr);
        //findLongest(arr);
        //System.out.println(findLongestConseqSubseq(arr,arr.length));

    }


    static int findLongestConseqSubseq(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update optimal length if this length
                // is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    }

    public static void longestFind(int[] arr){
        int max=0;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> newset = new HashSet<>();
        for(int i=0;i<arr.length;i++)
            set.add(arr[i]);
        System.out.println(Arrays.asList(set));
        for(int i=0;i<arr.length;i++)
        {
            int count=1;

            int num=arr[i];
            while(set.contains(--num)){
                count++;
                set.remove(num);
                newset.add(num);
            }

            num=arr[i];
            while(set.contains(++num))
            {
                count++;
                set.remove(num);
                newset.add(num);
            }


            max=Math.max(max,count);
        }
       // System.out.println(max);
        System.out.println(Arrays.asList(newset));

    }

    public static void findLongest(int[] arr){

        Arrays.sort(arr);
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length-1;i++)
        {
            if(map.containsKey(i)) {
                continue;
            }
            else {
                int left = map.containsKey(i-1) ? map.get(i-1) : 0;
                int right = map.containsKey(i+1) ? map.get(i+1) : 0;

                int sum=left+right+1;
                map.put(i, sum);
                count=Math.max(count,sum);

                map.put(i-left,sum);
                map.put(i+right,sum);

            }
            // System.out.println(arr[i]);

        }
        System.out.println(count);
      //  System.out.println(Arrays.asList(map));
    }
}
