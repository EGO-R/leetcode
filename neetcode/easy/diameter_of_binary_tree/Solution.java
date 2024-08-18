package neetcode.easy.diameter_of_binary_tree;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return deepCount(root)[1];
    }

    private int[] deepCount(TreeNode node) {
        var right = new int[] {0, 0};
        if (node.right != null)
            right = deepCount(node.right);
        var left = new int[] {0, 0};
        if (node.left != null)
            left = deepCount(node.left);
        int lowerMax = Integer.max(right[1], left[1]);
        int maxDepth = Integer.max(right[0], left[0]);
        return new int[] {maxDepth + 1, Integer.max(right[0] + left[0], lowerMax)};
    }
}
