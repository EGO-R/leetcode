package neetcode.medium.lru_cache;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/lru-cache/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache {

    private Map<Integer, Integer[]> map;
    int capacity;
    Integer first;
    Integer last;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.first = null;
        this.last = null;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        delete(key);
        insert(key);
        return map.get(key)[0];
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key)[0] = value;
            delete(key);
        }

        else
            map.put(key, new Integer[] {value, null, null});

        if (map.size() > capacity) {
            int lastKey = last;
            delete(last);
            map.remove(lastKey);
        }

        insert(key);
    }

    private void insert(int key) {
        var currentValue = map.get(key);
        currentValue[1] = null;
        currentValue[2] = first;
        if (first != null)
            map.get(first)[1] = key;
        first = key;
        if (last == null)
            last = key;
    }

    private void delete(int key) {
        var currentValue = map.get(key);
        Integer previous = currentValue[1];
        Integer next = currentValue[2];
        if (previous != null)
            map.get(previous)[2] = next;
        else
            first = next;
        if (next != null)
            map.get(next)[1] = previous;
        else
            last = previous;
    }

    public static void main(String[] args) {
        var lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
