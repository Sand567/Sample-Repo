import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sharath Nagendra on 11/5/2017.
 */
public class LRU2 {



    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }


    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;


    public LRU2(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if(n==null){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }

    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    public static void main(String[] args) {
        LRU2 lru = new LRU2(5);
        lru.set(1, 1);

        lru.set(2,2);

        lru.set(3, 3);

        lru.set(4, 4);

        lru.set(5, 5);

        int val=lru.get(1);

        System.out.println("  "+val);

        lru.set(6, 6);

        int val2=lru.get(2);

        System.out.println(""+val2);

    }
}
