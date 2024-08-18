package neetcode.easy.first_unique_character_in_a_string;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.
 */
public class Solution {
    public int firstUniqChar(String s) {
        var amount = new int[26];

        for (int i = 0; i < s.length(); i++)
            amount[s.charAt(i) - 97]++;

        for (int i = 0; i < s.length(); i++) {
            if (amount[s.charAt(i) - 97] == 1)
                return i;
        }
        return -1;
    }
}
