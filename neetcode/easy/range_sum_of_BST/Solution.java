package neetcode.easy.range_sum_of_BST;

import neetcode.easy.invert_binary_tree.TreeNode;

/*
https://leetcode.com/problems/range-sum-of-bst/

Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return sum(root, low, high);
    }

    private int sum(TreeNode node, int low, int high) {
        int sum = 0;
        if (node.val >= low && node.val <= high)
            sum = node.val;

        if (node.left != null)
            sum += sum(node.left, low, high);

        if (node.right != null)
            sum += sum(node.right, low, high);

        return sum;
    }
}
