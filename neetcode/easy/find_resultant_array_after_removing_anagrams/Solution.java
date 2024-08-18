package neetcode.easy.find_resultant_array_after_removing_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/

You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.

In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.

Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".
 */
public class Solution {
    public List<String> removeAnagrams(String[] words) {
        var result = new ArrayList<String>();
        var first = new int[26];
        var second = new int[26];

        for (var word : words) {
            createArr(second, word);
            if (!Arrays.equals(first, second)) {
                result.add(word);
                createArr(first, word);
            }
        }

        return result;
    }

    private void createArr(int[] arr, String word) {
        Arrays.fill(arr, 0);

        for (int i = 0; i < word.length(); ++i)
            ++arr[word.charAt(i) - 97];
    }
}
