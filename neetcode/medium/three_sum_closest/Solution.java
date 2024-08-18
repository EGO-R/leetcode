package neetcode.medium.three_sum_closest;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-closest

Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        var result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int sum = findMatch(nums, target, i);
            if (Math.abs(target - sum) < Math.abs(target - result))
                result = sum;
        }
        return result;
    }

    private int findMatch(int[] nums, int target, int firstIndex) {
        int result = Integer.MAX_VALUE;
        int start = firstIndex + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[firstIndex] + nums[start] + nums[end];
            if (Math.abs(target - sum) < Math.abs(target - result))
                result = sum;

            if (sum > target)
                end--;
            else
                start++;
        }

        return result;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}
