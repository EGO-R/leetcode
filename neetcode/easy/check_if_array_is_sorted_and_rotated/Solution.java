package neetcode.easy.check_if_array_is_sorted_and_rotated;


/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same
length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 */
public class Solution {
    public boolean check(int[] nums) {
        int breaks = 0;
        int prev = nums.length - 1;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[prev] > nums[curr])
                breaks++;
            prev = curr;
            curr++;
        }

        return breaks <= 1;
    }
}
