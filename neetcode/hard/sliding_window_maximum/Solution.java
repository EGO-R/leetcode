package neetcode.hard.sliding_window_maximum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

/*
https://leetcode.com/problems/sliding-window-maximum/

You are given an array of integers nums, there is a sliding window of size
k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 */
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];

        var start = 0;
        var end = k - 1;
        var window = new LinkedList<Integer>();

        for (int i = 0; i < k - 1; i++) {
            if (window.size() > 0 && window.getFirst() < nums[i])
                window.clear();
            else if (window.size() > 0) {
                while (window.getLast() < nums[i])
                    window.removeLast();
            }
            window.addLast(nums[i]);
        }


        while (end < nums.length) {
            if (window.size() > 0 && window.getFirst() < nums[end])
                window.clear();
            else if (window.size() > 0) {
                while (window.getLast() < nums[end])
                    window.removeLast();
            }

            window.addLast(nums[end]);
            result[start] = window.getFirst();

            if (nums[start] == window.getFirst())
                window.removeFirst();

            start++;
            end++;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
