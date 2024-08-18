package neetcode.medium.binary_tree_level_order_traversal;

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root != null) {
            var list = new ArrayList<TreeNode>();
            list.add(root);
            horizontalWalk(list, result);
        }
        return result;
    }

    private void horizontalWalk(List<TreeNode> nodes, List<List<Integer>> result) {
        if (nodes.isEmpty())
            return;

        var list = new ArrayList<Integer>();
        var newNodes = new ArrayList<TreeNode>();
        for (var node : nodes) {
            list.add(node.val);

            if (node.left != null)
                newNodes.add(node.left);

            if (node.right != null)
                newNodes.add(node.right);
        }

        result.add(list);
        horizontalWalk(newNodes, result);
    }
}
