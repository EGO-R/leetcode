package neetcode.easy.intersection_of_two_arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you
may return the result in any order.
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var list = new ArrayList<Integer>();

        for (var num : nums1)
            map.compute(num, (key, val) -> val == null ? 1 : ++val);

        for (var num : nums2) {
            if (map.getOrDefault(num, 0) != 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        var res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }
}
