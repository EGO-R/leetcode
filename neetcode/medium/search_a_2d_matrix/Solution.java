package neetcode.medium.search_a_2d_matrix;

/*
https://leetcode.com/problems/search-a-2d-matrix/

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binSearch2d(matrix, target, 0, matrix.length - 1);
    }

    private boolean binSearch2d(int[][] matrix, int target, int top, int bottom) {
        if (top > bottom)
            return false;

        int middle = top + (bottom - top) / 2;
        int m = matrix[0].length - 1;

        if (matrix[middle][0] <= target && matrix[middle][m] >= target)
            return binSearch(matrix[middle], target, 0, m);
        else if (matrix[middle][m] < target)
            return binSearch2d(matrix, target, middle + 1, bottom);
        else
            return binSearch2d(matrix, target, top, middle - 1);
    }

    private boolean binSearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return false;

        int middle = left + (right - left) / 2;

        if (nums[middle] == target)
            return true;
        else if (nums[middle] < target)
            return binSearch(nums, target, middle + 1, right);
        else
            return binSearch(nums, target, left, middle - 1);
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}
