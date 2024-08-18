package neetcode.medium.shortest_unsorted_continuous_subarray;

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray

Given an integer array nums, you need to find one continuous subarray such that if you only sort this
subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        var max = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max[i - 1])
                max[i] = nums[i];
            else
                max[i] = max[i - 1];
        }
        int endCounter = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= max[i])
                endCounter++;
            else
                break;
        }

        if (endCounter == n)
            return 0;

        var min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < min[i + 1])
                min[i] = nums[i];
            else
                min[i] = min[i + 1];
        }
        int startCounter = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min[i])
                startCounter++;
            else
                break;
        }

        return n - startCounter - endCounter;
    }
}
