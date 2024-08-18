package neetcode.medium.max_consecutive_ones_III;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/

Given a binary array nums and an integer k, return the maximum number of consecutive
1's in the array if you can flip at most k 0's.
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int zeros = 0;
        int max = 0;

        while (end < nums.length) {
            if (nums[end] == 0)
                zeros++;

            if (zeros <= k)
                max = Integer.max(max, end - start + 1);
            else {
                while (nums[start] != 0)
                    start++;
                start++;
                zeros--;
            }

            end++;
        }

        return max;
    }
}
