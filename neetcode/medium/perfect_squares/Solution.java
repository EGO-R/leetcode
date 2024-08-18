package neetcode.medium.perfect_squares;

/*
https://leetcode.com/problems/perfect-squares/

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
it is the product of some integer with itself.
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Solution {
    public int numSquares(int n) {
        var cache = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            cache[i] = i;

            for (int j = 1; j * j <= i; j++) {
                cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
            }
        }

        return cache[n];
    }
}
