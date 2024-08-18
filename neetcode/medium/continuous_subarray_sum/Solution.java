package neetcode.medium.continuous_subarray_sum;

import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.com/problems/continuous-subarray-sum/

Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1)
            return false;

        var map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (map.get(mod) < i - 1)
                    return true;
            } else
                map.put(mod, i);
        }

        return false;
    }
}
