package neetcode.medium.search_in_rotated_sorted_array;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot
index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot
index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target
if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = minSearch(nums, 0, nums.length - 1);
        return rotatedBinSearch(nums, target, 0, nums.length - 1, start);
    }

    private int minSearch(int[] nums, int left, int right) {
        int middle = left + (right - left) / 2;
        int previous = middle - 1;

        if (middle == 0)
            previous = nums.length - 1;

        if (nums[middle] <= nums[previous])
            return middle;
        else if (nums[middle] < nums[right])
            return minSearch(nums, left, middle - 1);
        else
            return minSearch(nums, middle + 1, right);
    }

    private int rotatedBinSearch(int[] nums, int target, int left, int right, int offset) {
        if (left > right)
            return -1;

        int middle = left + (right - left) / 2;

        int offsetMiddle = (middle + offset) % nums.length;

        if (nums[offsetMiddle] == target)
            return offsetMiddle;
        else if (nums[offsetMiddle] < target)
            return rotatedBinSearch(nums, target, middle + 1, right, offset);
        else
            return rotatedBinSearch(nums, target, left, middle - 1, offset);

    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.search(new int[] {3,5,1}, 5));
    }
}
