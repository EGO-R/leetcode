package neetcode.medium.subarray_sums_divisible_by_k;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
 */
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        var remains = new int[k];

        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += remains[(k + sum % k) % k]++;
        }

        return result + remains[0];
    }
}
