package neetcode.easy.matrix_diagonal_sum;

/*
https://leetcode.com/problems/matrix-diagonal-sum/

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the
secondary diagonal that are not part of the primary diagonal.
 */
public class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[n - i - 1][i];
            if (i == n - i - 1)
                sum -= mat[i][i];
        }

        return sum;
    }
}
