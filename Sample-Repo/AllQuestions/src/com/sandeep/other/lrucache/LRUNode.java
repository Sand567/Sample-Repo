package com.sandeep.other.lrucache;

public class LRUNode<T, U> {
    T key;
    U value;
    LRUNode<T, U> next;
    LRUNode<T, U> prev;

    LRUNode(LRUNode<T, U> prev, LRUNode<T, U> next, T key, U value) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
