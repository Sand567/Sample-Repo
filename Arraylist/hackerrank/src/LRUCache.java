/**
 * Created by Sharath Nagendra on 11/5/2017.
 */

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public int capacity;


    public LRUCache(int capacity) {
        super(capacity + 1, 1.0f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(10, 100);
        cache.put(11, 200);
        cache.put(12, 300);
        cache.put(13, 400);
        System.out.println(cache.get(10));
        //System.out.println(cache);
    }
}
