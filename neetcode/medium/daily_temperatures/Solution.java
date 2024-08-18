package neetcode.medium.daily_temperatures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
https://leetcode.com/problems/daily-temperatures/

Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to
wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        var daysLeft = new int[temperatures.length];
        var stack = new Stack<Integer>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            if (stack.isEmpty())
                daysLeft[i] = 0;
            else
                daysLeft[i] = stack.peek() - i;
            stack.push(i);
        }

        return daysLeft;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }
}
