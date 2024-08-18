package neetcode.medium.longest_consecutive_sequence;

import java.util.HashSet;


/*
https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 */
class Solution {
    public static int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        var maxValue = 0;
        var currentValue = 0;
        for (var num : nums) {
            set.add(num);
        }
        for (var num : nums) {
            if (set.contains(num - 1))
                continue;
            currentValue = 0;
            for (var i = num; set.contains(i); i++)
                currentValue++;
            maxValue = Integer.max(maxValue, currentValue);
        }
        return maxValue;
    }



    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7}));
    }
}
