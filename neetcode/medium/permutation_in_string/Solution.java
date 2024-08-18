package neetcode.medium.permutation_in_string;

import java.util.Arrays;

/*
https://leetcode.com/problems/permutation-in-string/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
 */
public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        var s1Arr = new int[26];
        var window = new int[26];
        var start = 0;
        var end = 0;
        while (end < s1.length()) {
            s1Arr[s1.charAt(end) - 97]++;
            window[s2.charAt(end) - 97]++;
            end++;
        }

        if (Arrays.equals(s1Arr, window))
            return true;

        while (end < s2.length()) {
            window[s2.charAt(end) - 97]++;
            window[s2.charAt(start) - 97]--;
            start++;

            if (Arrays.equals(s1Arr, window))
                return true;

            end++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
