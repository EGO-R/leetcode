package neetcode.easy.min_cost_climbing_stairs;

/*
https://leetcode.com/problems/min-cost-climbing-stairs/

You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var result = new int[cost.length];

        result[0] = cost[0];
        result[1] = cost[1];

        for (int i = 2; i < cost.length; i++)
            result[i] = Math.min(result[i - 1], result[i - 2]) + cost[i];

        return Math.min(result[cost.length - 1], result[cost.length - 2]);
    }
}
