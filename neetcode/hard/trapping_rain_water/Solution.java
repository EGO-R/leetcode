package neetcode.hard.trapping_rain_water;

/*
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Bad solution without dynamic programming
 */
public class Solution {
    public int trap(int[] height) {
        var maxLeft = new int[height.length];
        var maxRight = new int[height.length];


        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[height.length - i - 1] = Math.max(maxRight[height.length - i], height[height.length - i]);
        }

        int water = 0;
        for (int i = 0; i < height.length; i++) {
            var curr = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (curr > 0)
                water += curr;
        }

        return water;
    }


}
