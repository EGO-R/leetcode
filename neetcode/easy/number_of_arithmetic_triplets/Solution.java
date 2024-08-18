package neetcode.easy.number_of_arithmetic_triplets;

/*
https://leetcode.com/problems/number-of-arithmetic-triplets/

You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k)
is an arithmetic triplet if the following conditions are met:

i < j < k,
nums[j] - nums[i] == diff, and
nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.
 */
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int p1 = 0, p2 = 0, p3 = 0;
        int counter = 0;

        while (p1 < nums.length) {
            while (p2 < nums.length && nums[p2] < nums[p1] + diff)
                ++p2;

            while (p3 < nums.length && nums[p3] < nums[p1] +  2 * diff)
                ++p3;

            if (p2 < nums.length && nums[p2] == nums[p1] + diff &&
                    p3 < nums.length && nums[p3] == nums[p1] +  2 * diff)
                ++counter;

            ++p1;
        }

        return counter;
    }
}
