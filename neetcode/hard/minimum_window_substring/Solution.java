package neetcode.hard.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/

Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window.
 If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
 */
class Solution {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        var substrStart = 0;
        var substrEnd = -1;
        var start = 0;
        var end = 0;
        var tMap = new HashMap<Character, Integer>();
        var window = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++)
            tMap.compute(t.charAt(i), (key, val) -> val == null ? 1 : ++val);

        while (end < s.length()) {
            if (tMap.containsKey(s.charAt(end))) {
                window.compute(s.charAt(end), (key, val) -> val == null ? 1 : ++val);

                while (!tMap.containsKey(s.charAt(start)) || window.get(s.charAt(start)) > tMap.get(s.charAt(start))) {
                    window.computeIfPresent(s.charAt(start), (key, value) -> --value);
                    start++;
                }

                if (checkWindow(tMap, window)) {
                    if (substrEnd == -1 || end - start < substrEnd - substrStart) {
                        substrStart = start;
                        substrEnd = end;
                    }
                }
            }
            end++;
        }

        if (substrEnd != -1)
            return s.substring(substrStart, substrEnd + 1);
        else
            return "";
    }

    private static boolean checkWindow(Map<Character, Integer> tMap, Map<Character, Integer> window) {
        for (var tEntry : tMap.entrySet()) {
            if (!window.containsKey(tEntry.getKey()) ||
                    tEntry.getValue() > window.get(tEntry.getKey()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
