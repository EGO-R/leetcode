package neetcode.easy.maximum_depth_of_binary_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the
longest path from the root node down to the farthest leaf node.
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root != null)
            return countDepth(root);
        return 0;
    }

    private int countDepth(TreeNode node) {
        int right = 0;
        if (node.right != null)
            right = countDepth(node.right);
        int left = 0;
        if (node.left != null)
            left = countDepth(node.left);

        return Integer.max(right, left) + 1;
    }
}
