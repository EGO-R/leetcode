package neetcode.easy.best_time_to_buy_and_sell_stock;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different
day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int start = 0;
        int end = 1;
        while (end < prices.length) {
            if (prices[end] > prices[start])
                profit = Integer.max(profit, prices[end] - prices[start]);

            else
                start = end;

            end++;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
