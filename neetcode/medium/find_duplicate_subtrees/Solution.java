package neetcode.medium.find_duplicate_subtrees;

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-duplicate-subtrees/

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
 */
public class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        deepSearch(root);
        return result;
    }

    private String deepSearch(TreeNode node) {
        if (node == null)
            return "N";

        var signature = node.val + " " + deepSearch(node.left) + " " + deepSearch(node.right);

        map.put(signature, map.getOrDefault(signature, 0) + 1);

        if (map.get(signature) == 2)
            result.add(node);

        return signature;
    }
}
