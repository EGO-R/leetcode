package other.easy.valid_parentheses;

/*
https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class Solution {
    public static boolean isValid(String s) {
        var window = new StringBuilder("");

        for (var i = 0; i < s.length(); i++) {
            var chr = s.charAt(i);
            if (isOpeningBracket(chr)) {
                window.append(chr);
                continue;
            }

            if (window.length() == 0)
                return false;

            if (!isClosingBracket(window.charAt(window.length() - 1), s.charAt(i)))
                return false;
            window.setLength(window.length() - 1);
        }
        return window.length() == 0;
    }

    public static boolean isOpeningBracket(char chr) {
        return chr == '(' || chr == '{' || chr == '[';
    }

    public static boolean isClosingBracket(char openingBracket,
                                    char closingBracket) {
        if (openingBracket == '(')
            return closingBracket == ')';
        if (openingBracket == '[')
            return closingBracket == ']';
        if (openingBracket == '{')
            return closingBracket == '}';

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
