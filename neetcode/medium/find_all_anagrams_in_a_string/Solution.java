package neetcode.medium.find_all_anagrams_in_a_string;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var sample = new int[26];
        for (int i = 0; i < p.length(); i++)
            sample[p.charAt(i) - 97]++;

        var result = new ArrayList<Integer>();
        var window = new int[26];
        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 97]++;
            if (i >= p.length())
                window[s.charAt(i - p.length()) - 97]--;
            if (Arrays.equals(sample, window))
                result.add(i - p.length() + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
