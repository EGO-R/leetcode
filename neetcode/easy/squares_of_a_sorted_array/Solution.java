package neetcode.easy.squares_of_a_sorted_array;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/

Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        var result = new int[nums.length];
        int resultPos = 0;

        int positive = 0;
        while (positive < nums.length && nums[positive] < 0)
            positive++;
        int negative = positive - 1;

        while (negative >= 0 || positive < nums.length) {
            if (negative < 0 || positive < nums.length &&
                    Math.abs(nums[positive]) <= Math.abs(nums[negative])) {
                result[resultPos] = pow(nums[positive++]);

            } else
                result[resultPos] = pow(nums[negative--]);
            resultPos++;
        }

        return result;
    }

    private int pow(int val) {
        return val * val;
    }
}
