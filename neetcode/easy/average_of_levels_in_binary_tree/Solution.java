package neetcode.easy.average_of_levels_in_binary_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.addLast(root);

        var result = new ArrayList<Double>();
        while (!queue.isEmpty()) {
            long sum = 0;
            var len = queue.size();

            for (int i = 0; i < len; i++) {
                var current = queue.removeFirst();
                sum += current.val;

                if (current.left != null)
                    queue.addLast(current.left);
                if (current.right != null)
                    queue.addLast(current.right);
            }

            result.add(sum * 1.0 / len);
        }

        return result;
    }
}
