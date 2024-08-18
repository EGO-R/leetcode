package neetcode.hard.median_of_two_sorted_arrays;

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int half = n / 2;
        int left = -1, right = n1 - 1;

        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = half - mid1 - 2;

            int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 >= 0)
                l1 = nums1[mid1];
            if (mid1 < nums1.length - 1)
                r1 = nums1[mid1 + 1];
            if (mid2 >= 0)
                l2 = nums2[mid2];
            if (mid2 < nums2.length - 1)
                r2 = nums2[mid2 + 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 != 0)
                    return Math.min(r1, r2) * 1.0;
                else
                    return 1.0 * (Math.min(r1, r2) + Math.max(l1, l2)) / 2;
            }
            if (l1 > r2)
                right = mid1 - 1;
            else
                left = mid1 + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }
}
