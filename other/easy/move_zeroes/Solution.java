package other.easy.move_zeroes;

import java.util.Arrays;

/*
https://leetcode.com/problems/move-zeroes/description/

Given an integer array nums, move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        var place = 0;
        var element = 0;
        while (element < nums.length) {
            if (nums[element] != 0) {
                nums[place] = nums[element];
                place++;
            }
            element++;
        }

        while (place < nums.length) {
            nums[place] = 0;
            place++;
        }
    }

    public static void main(String[] args) {
        var ints = new int[]{0,1,0,3,12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
