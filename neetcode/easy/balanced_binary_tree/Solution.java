package neetcode.easy.balanced_binary_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced
.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;

        var right = maxDepth(node.right);
        if (right == -1)
            return right;

        var left = maxDepth(node.left);
        if (left == -1)
            return left;

        if (Math.abs(left - right) > 1)
            return -1;

        return Integer.max(left, right) + 1;
    }
}
