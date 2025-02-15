package neetcode.easy.same_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/same-tree/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
