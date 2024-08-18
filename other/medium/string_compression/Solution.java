package other.medium.string_compression;

import java.util.Arrays;

/*
https://leetcode.com/problems/string-compression/description/

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead,
be stored in the input character array chars. Note that group lengths
that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
 */
public class Solution {
    public static int compress(char[] chars) {
        int counter = 0;
        var writingIndex = 0;
        for (var i = 0; i < chars.length; i++) {
            counter++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[writingIndex] = chars[i];
                writingIndex++;
                if (counter != 1) {
                    for (char aChar : Integer.toString(counter).toCharArray()) {
                        chars[writingIndex] = aChar;
                        writingIndex++;
                    }
                }
                counter = 0;
            }
        }
        return writingIndex;
    }

    public static void main(String[] args) {
        var chars = new char[]{'a', 'b', 'b', 'a', 'a', 'a'};
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
