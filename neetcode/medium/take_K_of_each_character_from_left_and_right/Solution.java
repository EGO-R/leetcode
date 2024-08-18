package neetcode.medium.take_K_of_each_character_from_left_and_right;

/*
https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/

You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
 */
public class Solution {
    public int takeCharacters(String s, int k) {
        var lim = new int[3];
        for (int i = 0; i < s.length(); ++i)
            ++lim[s.charAt(i) - 97];
        for (int i = 0; i < 3; ++i) {
            lim[i] -= k;
            if (lim[i] < 0)
                return -1;
        }

        var window = new int[3];
        int start = 0, end = 0;
        int maxLen = 0;

        while (end < s.length()) {
            var curr = s.charAt(end) - 97;
            if (window[curr] == lim[curr]) {
                while (s.charAt(start) - 97 != curr)
                    --window[s.charAt(start++) - 97];
                --window[s.charAt(start++) - 97];
            }
            if (end - start  + 1 > maxLen)
                maxLen = end - start + 1;
            window[curr]++;
            end++;
        }

        return s.length() - maxLen;
    }
}
