package neetcode.medium.find_first_and_last_position_of_element_in_sorted_array;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binSearchStart(nums, target, 0, nums.length - 1);
        int end = binSearchEnd(nums, target, 0, nums.length - 1);
        return new int[] {start, end};
    }

    private int binSearchStart(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = left + (right - left) / 2;

        if (nums[middle] == target && (middle == 0 || nums[middle - 1] != target))
            return middle;
        else if (nums[middle] > target || middle != 0 && nums[middle - 1] == target)
            return binSearchStart(nums, target, left, middle - 1);
        else
            return binSearchStart(nums, target, middle + 1, right);
    }

    private int binSearchEnd(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = left + (right - left) / 2;

        int lId = nums.length - 1;

        if (nums[middle] == target && (middle == lId || nums[middle + 1] != target))
            return middle;
        else if (nums[middle] < target || middle != lId && nums[middle + 1] == target)
            return binSearchEnd(nums, target, middle + 1, right);
        else
            return binSearchEnd(nums, target, left, middle - 1);
    }
}
