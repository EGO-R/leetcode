package neetcode.medium.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 /*
 https://leetcode.com/problems/3sum/

 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
  */
public class Solution {
     public static List<List<Integer>> threeSum(int[] nums) {
         var result = new ArrayList<List<Integer>>();
         Arrays.sort(nums);

         int i = 0;
         while (i < nums.length - 2) {
             twoSum(nums, result, i);
             while (i < nums.length - 1 && nums[i + 1] == nums[i])
                 i++;
             i++;
         }
         return result;
     }


     private static void twoSum(int[] nums, List<List<Integer>> result, int start) {
         int target = - nums[start];
         start++;
         var end = nums.length - 1;
         List<Integer> list;
         while (start < end) {
             if (nums[start] + nums[end] == target) {
                 list = new ArrayList<Integer>();
                 list.add(nums[start]);
                 list.add(nums[end]);
                 list.add(-target);
                 result.add(list);

                 while (start < end && nums[start + 1] == nums[start])
                     start++;
                 while (start < end && nums[end - 1] == nums[end])
                     end--;

                 start++;
             }
             else if (nums[start] + nums[end] > target)
                 end--;
             else
                 start++;
         }
     }

     public static void main(String[] args) {
         System.out.println(threeSum(new int[] {1,-1,-1,0}));
     }
}
