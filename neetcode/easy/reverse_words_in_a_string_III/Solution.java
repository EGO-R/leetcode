package neetcode.easy.reverse_words_in_a_string_III;

/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/

Given a string s, reverse the order of characters in each word within a
sentence while still preserving whitespace and initial word order.
 */
public class Solution {
    public String reverseWords(String s) {
        var result = new StringBuilder();
        var window = new StringBuilder();
        var words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            window.append(words[i]);
            window.reverse();
            result.append(window);
            if (i < words.length - 1)
                result.append(' ');
            window.setLength(0);
        }

        return result.toString();
    }
}
