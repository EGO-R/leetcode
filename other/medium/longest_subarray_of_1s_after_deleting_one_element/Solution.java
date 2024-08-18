package other.medium.longest_subarray_of_1s_after_deleting_one_element;

/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.
Return 0 if there is no such subarray.
 */
public class Solution {
    public static int longestSubarray(int[] nums) {
        var start = 0;
        var isZeroAtStart = false;
        while (nums[start] == 0) {
            isZeroAtStart = true;
            if (start == nums.length - 1)
                return 0;
            start++;
        }

        var end = start;
        var zeroId = -1;
        while (nums[end] == 1 || zeroId == -1) {
            if (nums[end] == 0)
                zeroId = end;

            if (end == nums.length - 1) {
                if (zeroId != -1 || !isZeroAtStart)
                    return end - start;
                else
                    return end - start + 1;
            }

            end++;
        }

        var result = end - start - 1;
        while (true) {
            start = zeroId + 1;
            zeroId = end;
            end++;
            if (end >= nums.length)
                return result;

            while(nums[end] == 1) {
                if (end == nums.length - 1) {
                    if (end - start > result)
                        result = end - start;
                    return result;
                }
                end++;
            }
            if (end - start - 1 > result)
                result = end - start - 1;
        }
    }

    public static void main(String[] args) {
        var arr = new int[] {1, 1, 0, 1};
        System.out.println(longestSubarray(arr));
    }
}
