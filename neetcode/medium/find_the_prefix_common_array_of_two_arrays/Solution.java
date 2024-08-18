package neetcode.medium.find_the_prefix_common_array_of_two_arrays;

import java.util.HashSet;

/*
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or
before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
 */
public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        var set = new HashSet<Integer>();
        int n = A.length;
        var result = new int[n];
        for (int i = 0; i < n; i++) {
            if (set.contains(A[i]))
                result[i]++;
            if (set.contains(B[i]))
                result[i]++;
            if (result[i] == 0 && A[i] == B[i])
                result[i]++;
            if (i != 0)
                result[i] += result[i - 1];

            set.add(A[i]);
            set.add(B[i]);
        }

        return result;
    }
}
