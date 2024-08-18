package neetcode.medium.top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/

Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
 */
public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        int mapValue;
        for (int num : nums) {
            if (map.containsKey(num))
                mapValue = map.get(num) + 1;
            else
                mapValue = 1;

            map.put(num, mapValue);
        }

        var top = new int[k];
        var result = new int[k];
        for (var entry : map.entrySet()) {
            var value = entry.getValue();
            if (value > top[0]) {
                var i = k - 1;
                while (value <= top[i])
                    i--;
                for (var j = 0; j < i; j++) {
                    top[j] = top[j + 1];
                    result[j] = result[j + 1];
                }
                top[i] = value;
                result[i] = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
    }
}
