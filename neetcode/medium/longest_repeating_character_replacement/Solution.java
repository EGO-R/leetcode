package neetcode.medium.longest_repeating_character_replacement;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/

You are given a string s and an integer k.
You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing
the above operations.
 */
public class Solution {
    public static int characterReplacement(String s, int k) {
        var dictionary = new int[26];
        var start = 0;
        var end = 0;
        var maxLength = 1;
        var currentMaxAmount = 0;


        while (end < s.length()) {
            dictionary[s.charAt(end) - 65]++;
            currentMaxAmount = 0;
            for (int i = 0; i < 26; i++) {
                if (dictionary[i] > currentMaxAmount)
                    currentMaxAmount = dictionary[i];
            }

            if (end - start - currentMaxAmount + 1 > k) {
                dictionary[s.charAt(start) - 65]--;
                start++;
            } else
                maxLength = Integer.max(maxLength, end - start + 1);

            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
}
