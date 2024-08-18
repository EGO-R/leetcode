package neetcode.easy.shortest_completing_word;

import java.util.Arrays;

/*
https://leetcode.com/problems/shortest-completing-word/

Given a string licensePlate and an array of strings words, find the shortest completing word in words.

A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.


 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        var pattern = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            int curr = licensePlate.charAt(i);

            if (curr >= 97)
                curr -= 97;
            else
                curr -= 65;

            if (curr >= 0 && curr <= 26)
                ++pattern[curr];
        }

        int minId = -1;
        var arr = new int[26];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j)
                ++arr[words[i].charAt(j) - 97];

            if (equals(pattern, arr) && (minId == -1 || words[minId].length() > words[i].length()))
                minId = i;

            Arrays.fill(arr, 0);
        }

        return words[minId];
    }

    private boolean equals(int[] pattern, int[] arr) {
        for (int i = 0; i < 26; ++i) {
            if (pattern[i] > arr[i])
                return false;
        }

        return true;
    }
}
