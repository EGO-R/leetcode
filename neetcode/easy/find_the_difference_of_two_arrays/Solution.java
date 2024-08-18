package neetcode.easy.find_the_difference_of_two_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/problems/find-the-difference-of-two-arrays/

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (var num : nums1)
            set1.add(num);

        var set2 = new HashSet<Integer>();
        for (var num : nums2)
            set2.add(num);

        var result = new ArrayList<List<Integer>>();

        result.add(new ArrayList<>());
        for (var num : set1) {
            if (!set2.contains(num))
                result.get(0).add(num);
        }

        result.add(new ArrayList<>());
        for (var num : set2) {
            if (!set1.contains(num))
                result.get(1).add(num);
        }

        return result;
    }
}
