package neetcode.easy.valid_palindrome_II;

/*
https://leetcode.com/problems/valid-palindrome-ii/

Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, false);
    }

    private boolean isValid(String s, int start, int end, boolean isDeleted) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (isDeleted)
                    return false;
                else
                    return isValid(s, start + 1, end, true) || isValid(s, start, end - 1, true);
            }

            start++;
            end--;
        }

        return true;
    }
}
