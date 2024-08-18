package neetcode.medium.interval_list_intersections;

import java.util.ArrayList;

/*
https://leetcode.com/problems/interval-list-intersections/

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or
represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPointer = 0;
        int secondPointer = 0;
        var list = new ArrayList<int[]>();

        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int min = Integer.min(firstList[firstPointer][1], secondList[secondPointer][1]);
            int max = Integer.max(firstList[firstPointer][0], secondList[secondPointer][0]);
            if (min >= max)
                list.add(new int[] {max, min});

            if (firstList[firstPointer][1] == min)
                firstPointer++;
            else
                secondPointer++;
        }

        var result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}
