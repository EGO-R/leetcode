package other.easy.summary_ranges;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/summary-ranges/description/

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges, and there is no
integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

 */
public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        var ranges = new ArrayList<String>();
        if (nums.length == 0)
            return ranges;
        var start = 0;
        var end = 0;
        while (end < nums.length - 1) {
            if (nums[end + 1] != nums[end] + 1) {
                if (start != end) {
                    ranges.add(nums[start] + "->" + nums[end]);
                } else {
                    ranges.add(nums[end] + "");
                }
                start = end + 1;
            }
            end++;
        }

        if (start != end) {
            ranges.add(nums[start] + "->" + nums[end]);
        } else {
            ranges.add(nums[end] + "");
        }

        return ranges;
    }

    public static void main(String[] args) {
        var arr = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(arr));
    }
}
