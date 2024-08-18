package neetcode.medium.find_minimum_in_rotated_sorted_array;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
[a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */
public class Solution {
    public int findMin(int[] nums) {
        return binSearch(nums, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int left, int right) {
        int middle = left + (right - left) / 2;
        int previous = middle - 1;
        if (middle == 0)
            previous = nums.length - 1;

        if (nums[previous] >= nums[middle])
            return nums[middle];
        else if (nums[right] > nums[middle])
            return binSearch(nums, left, middle - 1);
        else
            return binSearch(nums, middle + 1, right);
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.findMin(new int[] {3,4,5,1,2}));
    }
}
