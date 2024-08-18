package neetcode.easy.find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/find-target-indices-after-sorting-array/

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices,
return an empty list. The returned list must be sorted in increasing order.
 */
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lower = 0, sim = 0;
        for (var num : nums) {
            if (num == target)
                sim++;
            if (num < target)
                lower++;
        }

        var result = new ArrayList<Integer>();
        for (int i = 0; i < sim; i++) {
            result.add(lower + i);
        }
        return result;
    }
}
