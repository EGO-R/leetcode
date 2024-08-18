package neetcode.easy.add_strings;

/*
https://leetcode.com/problems/add-strings/

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int f = num1.length() - 1;
        int s = num2.length() - 1;
        var result = new StringBuilder();
        int prev = 0;

        while (f >= 0 || s >= 0) {
            int sum = 0;
            if (f >= 0)
                sum += num1.charAt(f) - 48;
            if (s >= 0)
                sum += num2.charAt(s) - 48;

            sum += prev;
            result.append(sum % 10);
            if (sum >= 10)
                prev = 1;
            else
                prev = 0;

            f--;
            s--;
        }

        if (prev == 1)
            result.append(1);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.addStrings("11", "123"));
    }
}
