package neetcode.medium.contiguous_array;

import java.util.HashMap;

/*
https://leetcode.com/problems/contiguous-array/

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0, maxDiff = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0)
                sum--;
            else
                sum++;

            if (map.containsKey(sum))
                maxDiff = Math.max(maxDiff, i - map.get(sum));
            else
                map.put(sum, i);
        }

        return maxDiff;
    }
}
