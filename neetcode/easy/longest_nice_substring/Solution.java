package neetcode.easy.longest_nice_substring;

import java.util.HashSet;

/*
https://leetcode.com/problems/longest-nice-substring/

A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 */
public class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";

        var arr = s.toCharArray();
        var set = new HashSet<>();

        for (var c : arr)
            set.add(c);

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c)))
                continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
