package neetcode.easy.sum_of_left_leaves;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/sum-of-left-leaves/

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null && isLeft)
            return node.val;

        return dfs(node.left, true) + dfs(node.right, false);
    }
}
