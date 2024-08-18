package neetcode.easy.symmetric_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/symmetric-tree/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return equals(root.left, root.right);
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;

        return equals(node1.left, node2.right) && equals(node1.right, node2.left);
    }
}
