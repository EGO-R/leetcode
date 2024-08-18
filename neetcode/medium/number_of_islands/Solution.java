package neetcode.medium.number_of_islands;

import java.util.LinkedList;

/*
https://leetcode.com/problems/number-of-islands/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    islands++;
                }

            }
        }
        return islands;
    }

    private void markIsland(char[][] grid, int i, int j) {
        var queue = new LinkedList<int[]>();
        queue.addLast(new int[] {i, j});

        int rows = grid.length, cols = grid[0].length;
        while (!queue.isEmpty()) {

            var len = queue.size();
            for (int k = 0; k < len; k++) {

                var current = queue.removeLast();
                grid[current[0]][current[1]] = '0';

                if (current[0] < rows - 1 && grid[current[0] + 1][current[1]] == '1')
                    queue.addLast(new int[] {current[0] + 1, current[1]});
                if (current[1] < cols - 1 && grid[current[0]][current[1] + 1] == '1')
                    queue.addLast(new int[] {current[0], current[1] + 1});
                if (current[0] > 0 && grid[current[0] - 1][current[1]] == '1')
                    queue.addLast(new int[] {current[0] - 1, current[1]});
                if (current[1] > 0 && grid[current[0]][current[1] - 1] == '1')
                    queue.addLast(new int[] {current[0], current[1] - 1});
            }
        }
    }

    public static void main(String[] args) {
        var solution = new Solution();
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }
}
