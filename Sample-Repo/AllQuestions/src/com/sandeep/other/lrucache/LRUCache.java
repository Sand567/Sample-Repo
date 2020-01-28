package com.sandeep.other.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private LRUNode<K, V> lru;
    private LRUNode<K, V> mru;
    private Map<K, LRUNode<K, V>> container;
    private int currentSize;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        lru = new LRUNode<>(null, null, null, null);
        mru = lru;
        container = new HashMap<>();
    }

    public void put(K key, V value) {
        if (container.containsKey(key)) {
            return;
        }

        LRUNode<K, V> myNode = new LRUNode<>(mru, null, key, value);
        mru.next = myNode;
        mru = myNode;
        container.put(key, myNode);

        // Delete the left-most entry
        // and update the LRU pointer
        if (currentSize == capacity) {
            container.remove(lru.key);
            lru = lru.next;
            lru.prev = null;
        } else if (currentSize < capacity) {
            // Update container size, for the first added entry
            // and update the LRU pointer
            if (currentSize == 0) {
                lru = myNode;
            }

            currentSize++;
        }
    }

    public V get(K key) {
        LRUNode<K, V> tempNode = container.get(key);

        if (tempNode == null) {
            return null;
        } else if (tempNode.key == mru.key) {
            return mru.value;
        }

        // Get the next and prev nodes
        LRUNode<K, V> nextNode = tempNode.next;
        LRUNode<K, V> prevNode = tempNode.prev;

        // If at the left-most, we update LRU
        if (tempNode.key == lru.key) {
            nextNode.prev = null;
            lru = nextNode;
        } else if (tempNode.key != mru.key) {
            // If we are in the middle, we need to
            // update the items before and after our item
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        mru.next = tempNode;
        tempNode.prev = mru;
        mru = tempNode;
        mru.next = null;

        return tempNode.value;
    }
}
