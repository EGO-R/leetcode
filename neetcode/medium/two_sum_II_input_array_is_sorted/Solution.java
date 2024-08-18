package neetcode.medium.two_sum_II_input_array_is_sorted;

import java.util.Arrays;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be
numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
 */
public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int searchResult;
        for (int i = 0; i < numbers.length - 1; i++) {
            searchResult = binSearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (searchResult != -1)
                return new int[] {i + 1, searchResult + 1};
        }

        return null;
    }

    private static int binSearch(int[] numbers, int target, int left, int right) {
        if (left > right)
            return -1;

        var medium = left + (right - left) / 2;

        if (numbers[medium] == target)
            return medium;
        else if (numbers[medium] < target)
            return binSearch(numbers, target, medium + 1, right);
        else
            return binSearch(numbers, target, left, medium - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
    }
}
