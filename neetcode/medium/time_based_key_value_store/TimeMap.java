package neetcode.medium.time_based_key_value_store;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/time-based-key-value-store/

Design a time-based key-value data structure that can store multiple values for the same
key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at
the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously,
with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated
with the largest timestamp_prev. If there are no values, it returns "".
 */
class TimeMap {

    private Map<String, List<String[]>> map;

    public TimeMap() {
        this.map = new HashMap<String, List<String[]>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<String[]>());
        map.get(key).add(new String[] {timestamp + "", value});
    }

    public String get(String key, int timestamp) {
        var list = map.get(key);
        if (list != null)
            return binSearch(list, timestamp, 0, list.size() - 1);
        else
            return "";
    }

    private String binSearch(List<String[]> list, int timestamp, int left, int right) {
        if (left > right)
            return "";
        int medium = left + (right - left) / 2;

        int currentValue = Integer.parseInt(list.get(medium)[0]);

        if (currentValue <= timestamp) {
            if (medium + 1 >= list.size() || Integer.parseInt(list.get(medium + 1)[0]) > timestamp)
                return list.get(medium)[1];
            else
                return binSearch(list, timestamp, medium + 1, right);
        }
        else
            return binSearch(list, timestamp, left, medium - 1);
    }

    public static void main(String[] args) {
        var timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
