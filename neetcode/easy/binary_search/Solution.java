package neetcode.easy.binary_search;

/*
https://leetcode.com/problems/binary-search/

Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
    public int search(int[] nums, int target) {
        return binSearch(nums, target, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int middle = left + (right - left) / 2;

        if (nums[middle] == target)
            return middle;
        else if (nums[middle] < target)
            return binSearch(nums, target, middle + 1, right);
        else
            return binSearch(nums, target, left, middle - 1);
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.search(new int[] {1}, 9));
    }
}
