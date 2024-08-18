package neetcode.medium.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(elem -> elem[0]));

        var arr = new ArrayList<int[]>();
        arr.add(intervals[0]);

        for (var interval : intervals) {
            var prevInterval = arr.getLast();
            if (interval[0] <= prevInterval[1]) {
                prevInterval[0] = Integer.min(prevInterval[0], interval[0]);
                prevInterval[1] = Integer.max(prevInterval[1], interval[1]);
            } else
                arr.add(interval);
        }

        int[][] result = new int[arr.size()][];

        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
    }
}
