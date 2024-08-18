package neetcode.medium.insert_interval;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var list = new ArrayList<int[]>();
        int i = 0;

        while (i < intervals.length && intervals[i][0] < newInterval[0])
            list.add(intervals[i++]);

        add(list, newInterval);

        while (i < intervals.length)
            add(list, intervals[i++]);

        var result = new int[list.size()][];
        for (int j = 0; j < list.size(); ++j)
            result[j] = list.get(j);

        return result;
    }

    private void add(List<int[]> list, int[] curr) {
        if (list.isEmpty()) {
            list.add(curr);
            return;
        }
        var last = list.getLast();
        if(last[1] >= curr[0])
            last[1] = Math.max(last[1], curr[1]);
        else
            list.add(curr);
    }
}
