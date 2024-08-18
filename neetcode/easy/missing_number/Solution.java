package neetcode.easy.missing_number;

/*
https://leetcode.com/problems/missing-number/

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int targetSum = 0;
        for (int i = 1; i <= nums.length; i++)
            targetSum += i;

        int sum = 0;
        for (var num : nums)
            sum += num;

        return targetSum - sum;
    }
}
