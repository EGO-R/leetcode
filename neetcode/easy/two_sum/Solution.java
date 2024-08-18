package neetcode.easy.two_sum;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two
numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        Integer mapValue;

        for (var i = 0; i < nums.length; i++) {
            mapValue = map.get(target - nums[i]);
            if (mapValue != null)
                return new int[] {mapValue, i};
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4}, 6)));
    }
}
