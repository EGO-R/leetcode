package neetcode.easy.contains_duplicate;

import java.util.HashSet;

/*
https://leetcode.com/problems/contains-duplicate/description/

Given an integer array nums, return true if any value appears at
least twice in the array, and return false if every element is distinct.
 */
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 1}));
    }
}
