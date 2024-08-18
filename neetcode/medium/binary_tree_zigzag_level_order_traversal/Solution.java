package neetcode.medium.binary_tree_zigzag_level_order_traversal;

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root != null) {
            var list = new ArrayList<TreeNode>();
            list.add(root);
            zigzagWalk(list, 0, result);
        }
        return result;
    }

    private void zigzagWalk(List<TreeNode> nodes, int reverse, List<List<Integer>> result) {
        if (nodes.isEmpty())
            return;

        var list = new ArrayList<Integer>();
        var newNodes = new LinkedList<TreeNode>();
        for (var node : nodes) {
            list.add(node.val);

            var arr = new TreeNode[] {node.left, node.right};
            if (arr[reverse] != null)
                newNodes.addFirst(arr[reverse]);
            if (arr[1 - reverse] != null)
                newNodes.addFirst(arr[1 - reverse]);
        }

        result.add(list);
        zigzagWalk(newNodes, 1 - reverse, result);
    }
}
