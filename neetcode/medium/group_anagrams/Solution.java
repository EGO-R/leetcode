package neetcode.medium.group_anagrams;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var i = 0; i < strs.length; i++) {
            add(map, strs[i]);
        }


        return new ArrayList<>(map.values());
    }

    private static void add(Map<String, List<String>> map, String s) {
        var charS = s.toCharArray();
        Arrays.sort(charS);
        var chars = Arrays.toString(charS);

        if (map.get(chars) == null)
            map.put(chars, new ArrayList<String>());

        map.get(chars).add(s);
    }

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
