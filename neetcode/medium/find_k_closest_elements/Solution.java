package neetcode.medium.find_k_closest_elements;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var queue = new LinkedList<Integer>();

        for (int i = 0; i < k; i++)
            queue.addLast(arr[i]);

        for (int i = k; i < arr.length; i++) {
            int start = Math.abs(x - queue.getFirst());
            int end = Math.abs(x - arr[i]);
            if (start < end || start == end && queue.getFirst() < arr[i])
                break;

            queue.removeFirst();
            queue.addLast(arr[i]);
        }

        return queue;
    }
}
