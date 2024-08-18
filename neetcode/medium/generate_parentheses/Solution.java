package neetcode.medium.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        checkCombines("", n, 0, 0, result);
        return result;
    }

    private void checkCombines(String str, int n, int curr, int opened, List<String> result) {
        if (str.length() == 2 * n)
            result.add(str);

        if (opened > 0)
            checkCombines(str + ")", n, curr, opened - 1, result);

        if (curr < n)
            checkCombines(str + "(", n, curr + 1, opened + 1, result);

    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
