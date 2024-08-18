package neetcode.medium.longest_substring_without_repeating_characters;

import java.util.HashSet;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without repeating characters.
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        var window = new HashSet<Character>();
        int maxUniqueLength = 1;
        int start = 0;
        int end = 1;
        window.add(s.charAt(start));
        while (end < s.length()) {
            if (window.contains(s.charAt(end))) {
                maxUniqueLength = Integer.max(maxUniqueLength, window.size());
                while (s.charAt(start) != s.charAt(end)) {
                    window.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else
                window.add(s.charAt(end));
            end++;
        }

        maxUniqueLength = Integer.max(maxUniqueLength, window.size());

        return maxUniqueLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
