package neetcode.medium.product_of_array_except_self;

import java.util.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is
equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        int right = 1;
        int left = 1;
        var answer = new int[len];
        Arrays.fill(answer, 1);

        for (int i = 0; i < len; i++) {
            answer[i] *= right;
            answer[len - i - 1] *= left;

            right *= nums[i];
            left *= nums[len - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
    }
}
