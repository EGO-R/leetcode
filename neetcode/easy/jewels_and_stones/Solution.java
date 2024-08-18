package neetcode.easy.jewels_and_stones;

import java.util.HashSet;

/*
https://leetcode.com/problems/jewels-and-stones/

You're given strings jewels representing the types of stones that are jewels,
and stones representing the stones you have. Each character in stones is a type of stone you have.
You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        var set = new HashSet<Character>();
        for (int i = 0; i < jewels.length(); i++)
            set.add(jewels.charAt(i));

        int counter = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i)))
                counter++;
        }

        return counter;
    }
}
