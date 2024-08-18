package neetcode.medium.lowest_common_ancestor_of_a_binary_tree;


import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q);
    }

    private TreeNode findAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        var left = findAncestor(node.left, p, q);
        var right = findAncestor(node.right, p, q);

        if (left != null && right != null ||
                node == p || node == q)
            return node;
        else if (left != null)
            return left;
        else
            return right;
    }
}
