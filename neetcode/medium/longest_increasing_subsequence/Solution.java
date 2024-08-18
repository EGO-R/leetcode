package neetcode.medium.longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/longest-increasing-subsequence/

Given an integer array nums, return the length of the longest strictly increasing subsequence
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        var list = new ArrayList<Integer>();

        for (var num : nums) {
            if (list.isEmpty() || num > list.getLast())
                list.add(num);
            else
                list.set(binSearch(list, num, 0, list.size() - 1), num);
        }

        return list.size();
    }

    private int binSearch(List<Integer> list, int target, int left, int right) {
        int middle = left + (right - left) / 2;

        if (list.get(middle) >= target && (middle == 0 || list.get(middle - 1) < target))
            return middle;
        if (list.get(middle) < target)
            return binSearch(list, target, middle + 1, right);
        else
            return binSearch(list, target, left, middle - 1);
    }
}
