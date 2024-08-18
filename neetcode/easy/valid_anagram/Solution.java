package neetcode.easy.valid_anagram;

import java.util.Arrays;

/*
https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var charS = s.toCharArray();
        var charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        for (var i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
