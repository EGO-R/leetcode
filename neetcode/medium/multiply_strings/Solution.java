package neetcode.medium.multiply_strings;

/*
https://leetcode.com/problems/multiply-strings/

Given two non-negative integers num1 and num2 represented as strings, return the product
of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


 */
public class Solution {
    public String multiply(String num1, String num2) {
        var result = new StringBuilder("0");
        var template = new StringBuilder();

        for (int i = num1.length() - 1; i >= 0; i--) {
            var multRes = new StringBuilder(template);
            int prev = 0;

            for (int j = num2.length() - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - 48) * (num2.charAt(j) - 48) + prev;
                prev = mult / 10;
                multRes.append(mult % 10);
            }

            if (prev != 0)
                multRes.append(prev);

            if (num1.charAt(i) != '0')
                result = revSum(result, multRes);
            template.append('0');
        }

        return result.reverse().toString();
    }

    private StringBuilder revSum (StringBuilder num1, StringBuilder num2) {
        var result = new StringBuilder();
        int prev = 0;

        int l1 = num1.length(), l2 = num2.length();
        int p = 0;

        while (p < l1 || p < l2) {
            int sum = prev;
            if (p < l1)
                sum += num1.charAt(p) - 48;
            if (p < l2)
                sum += num2.charAt(p) - 48;
            prev = sum / 10;
            result.append(sum % 10);
            p++;
        }

        if (prev != 0)
            result.append(prev);

        return result;
    }

    public static void main(String[] args) {
        var solution = new Solution();

        System.out.println(solution.multiply("0", "0"));
    }
}
