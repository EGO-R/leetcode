package neetcode.hard.maximal_rectangle;

import java.util.Stack;

/*
https://leetcode.com/problems/maximal-rectangle/

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        var line = new int[m];
        var stack = new Stack<Integer>();
        int max = 0;

        for (var row : matrix) {

            for (int i = 0; i < m; ++i) {
                if (row[i] == '0')
                    line[i] = 0;
                else
                    line[i]++;
            }

            for (int i = 0; i <= m; ++i) {
                var currLine = i == m ? 0 : line[i];
                while (!stack.isEmpty() && line[stack.peek()] > currLine) {
                    var curr = stack.pop();
                    if (stack.isEmpty())
                        max = Math.max(max, line[curr] * i);
                    else
                        max = Math.max(max, line[curr] * (i - stack.peek() - 1));

                }
                stack.add(i);
            }

            stack.clear();
        }

        return max;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
