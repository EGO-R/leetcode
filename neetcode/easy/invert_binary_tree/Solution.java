package neetcode.easy.invert_binary_tree;

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
https://leetcode.com/problems/invert-binary-tree/

Given the root of a binary tree, invert the tree, and return its root.
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null)
            invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node.left != null)
            invert(node.left);
        if (node.right != null)
            invert(node.right);

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
    }
}
