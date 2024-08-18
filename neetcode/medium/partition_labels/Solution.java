package neetcode.medium.partition_labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/partition-labels/

You are given a string s. We want to partition the string into as many parts as possible
so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order,
the resultant string should be s.

Return a list of integers representing the size of these parts.
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            last[s.charAt(i)-'a'] = i;
        }

        var result = new ArrayList<Integer>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i > end) {
                result.add(end - start + 1);
                start = i;
                end = i;
            }
            end = Math.max(end, last[s.charAt(i)-'a']);
        }
        result.add(end - start + 1);
        return result;
    }
}
