package neetcode.medium.rotate_image;

/*
https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j <= n - i - 1; j++) {
                int temp = matrix[i][n - j];
                matrix[i][n - j] = matrix[j][i];
                matrix[j][i] = matrix[n - i][j];
                matrix[n - i][j] = matrix[n - j][n - i];
                matrix[n - j][n - i] = temp;

            }
        }
    }

    public static void main(String[] args) {
        var solution = new Solution();
        solution.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
