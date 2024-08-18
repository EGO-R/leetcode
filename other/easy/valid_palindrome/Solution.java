package other.easy.valid_palindrome;

/*
https://leetcode.com/problems/valid-palindrome/description/

A phrase is a palindrome if, after converting all uppercase letters
into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        char leftValue;
        char rightValue;

        while (left < right) {
            leftValue = Character.toLowerCase(s.charAt(left));
            if (!Character.isLetterOrDigit(leftValue)) {
                left++;
                continue;
            }

            rightValue = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(rightValue)) {
                right--;
                continue;
            }

            if (leftValue != rightValue)
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }
}
