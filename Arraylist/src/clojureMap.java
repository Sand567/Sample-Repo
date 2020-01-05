
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 4/27/2018.
 */
public class clojureMap {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "sally");
        map.put("profile", new HashMap() {
            {
                put("name", "sally C");
                put("address", new HashMap() {{
                    put("city", "Austin");
                    put("state", "TX");
                }});

            }

        });

        getElement((HashMap<String, Object>) map, new String[]{"username"}, 0);
    }

    static void getElement(HashMap<String, Object> map, String[] arr, int i) {

        if (i < arr.length) {
            if (map.get(arr[i]) instanceof HashMap) {
                getElement((HashMap<String, Object>) map.get(arr[i]), arr, i + 1);

            } else {
                System.out.println(map.get(arr[i]));
            }

        } else {
            System.out.println("null");
        }

    }
}



