import java.util.*;

/**
 * Created by Sharath Nagendra on 10/21/2018.
 */
public class sortbyfreq {

    public static void main (String[] args) {
        int[] arr = {3,3,2,4,5,2,12,2,3,3,2,12};

        System.out.println("Arr " + Arrays.toString(arr));
        sortByFrequency(arr);
    }

    static void sortByFrequency(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count+1);

            } else {
                map.put(arr[i], 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        System.out.println(set);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            for(int i=1; i<=count; i++) {
                System.out.print(" " + entry.getKey());
            }

        }
    }
}
