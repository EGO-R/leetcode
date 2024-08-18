package neetcode.easy.is_subsequence;

/*
https://leetcode.com/problems/is-subsequence/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        if (s.length() > t.length())
            return false;
        int pS = 0, pT = 0;
        while (pT < t.length() && pS < s.length()) {
            if (t.charAt(pT) == s.charAt(pS))
                pS++;
            pT++;
        }

        return pS == s.length();
    }
}
