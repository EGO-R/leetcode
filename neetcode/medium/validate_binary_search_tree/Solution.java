package neetcode.medium.validate_binary_search_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/validate-binary-search-tree/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    private boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;

        var left = node.left;
        var right = node.right;

        if (left != null && (left.val >= node.val || min != null && left.val <= min) ||
                right != null && (right.val <= node.val || max != null && right.val >= max))
            return false;


        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}
