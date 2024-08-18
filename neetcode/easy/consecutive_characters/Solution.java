package neetcode.easy.consecutive_characters;


/*
https://leetcode.com/problems/consecutive-characters/

The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.
 */
public class Solution {
    public int maxPower(String s) {
        int pointer = 1;
        int maxLen = 1;
        int len = 1;
        while (pointer < s.length()) {
            if (s.charAt(pointer) != s.charAt(pointer - 1)) {
                maxLen = Integer.max(len, maxLen);
                len = 1;
            } else
                len++;
            pointer++;
        }

        return Integer.max(len, maxLen);
    }
}
