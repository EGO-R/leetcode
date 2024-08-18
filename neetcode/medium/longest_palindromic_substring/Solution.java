package neetcode.medium.longest_palindromic_substring;

/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.
 */
public class Solution {
    private int resultStart = 0;
    private int resultEnd = 0;

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            int start;
            if (i != s.length() - 1 && i > 0 &&
                    s.charAt(i - 1) == s.charAt(i + 1))
                checkPalindrome(s, i - 1, i + 1);

            if (i != s.length() - 1 &&
                    s.charAt(i) == s.charAt(i + 1))
                checkPalindrome(s, i, i + 1);

        }

        return s.substring(resultStart, resultEnd + 1);
    }

    private void checkPalindrome(String s, int start, int end) {
        while (start - 1 >= 0 && end + 1 < s.length() && s.charAt(start - 1) == s.charAt(end + 1)) {
            start--;
            end++;
        }

        if (end - start > resultEnd - resultStart) {
            resultStart = start;
            resultEnd = end;
        }
    }
}
