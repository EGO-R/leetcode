package neetcode.hard.largest_rectangle_in_histogram;

import java.util.Stack;

/*
https://leetcode.com/problems/largest-rectangle-in-histogram/

Given an array of integers heights representing the histogram's bar height
where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        var stack = new Stack<Integer>();
        var maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            var currentValue = heights[i];
            while (!stack.isEmpty() && currentValue < heights[stack.peek()]) {
                var stackValue = stack.pop();
                if (stack.isEmpty())
                    maxArea = Integer.max(heights[stackValue] * (i), maxArea);
                else
                    maxArea = Integer.max(heights[stackValue] * (i - stack.peek() - 1), maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            var stackValue = stack.pop();
            if (stack.isEmpty())
                maxArea = Integer.max(heights[stackValue] * (heights.length), maxArea);
            else
                maxArea = Integer.max(heights[stackValue] * (heights.length - stack.peek() - 1), maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
}
