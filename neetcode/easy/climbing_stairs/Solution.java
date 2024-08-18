package neetcode.easy.climbing_stairs;

/*
https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Solution {
    public int climbStairs(int n) {
        int prev1 = 1, prev2 = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            int temp = prev1;
            prev1 = prev2 + prev1;
            prev2 = temp;
        }

        return prev1;
    }
}
