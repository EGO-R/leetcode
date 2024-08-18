package neetcode.medium.spiral_matrix_II;

/*
https://leetcode.com/problems/spiral-matrix-ii/

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        var result = new int[n][n];
        int counter = 1;

        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n - i; j++)
                result[i][j] = counter++;

            for (int j = i + 1; j < n - i; j++)
                result[j][n - i - 1] = counter++;

            for (int j = i + 1; j < n - i; j++)
                result[n - i - 1][n - j - 1] = counter++;

            for (int j = i + 1; j < n - i - 1; j++)
                result[n - j - 1][i] = counter++;
        }

        return result;
    }
}
