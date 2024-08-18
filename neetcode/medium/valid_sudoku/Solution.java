package neetcode.medium.valid_sudoku;

/*
https://leetcode.com/problems/valid-sudoku/

Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidArea(board, i, 0, i, 8))
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (!isValidArea(board, 0, j, 8, j))
                return false;
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidArea(board, i, j, i + 2, j + 2))
                    return false;
            }
        }

        return true;
    }

    private static boolean isValidArea(char[][] board, int i1, int j1, int i2, int j2) {
        var nums = new int[10];
        for (var i = i1; i <= i2; i++) {
            for (var j = j1; j <= j2; j++) {
                if (board[i][j] == '.')
                    continue;
                if (board[i][j] < 48 || board[i][j] > 57 || nums[board[i][j] - 48] == 1)
                    return false;
                nums[board[i][j] - 48] = 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
