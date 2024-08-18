package neetcode.medium.binary_tree_level_order_traversal;

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Faster, than 1 solution, but fake Breadth-First walk
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        horizontalWalk(root, 0, result);
        return result;
    }

    private void horizontalWalk(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null)
            return;

        if (result.size() - 1 < depth)
            result.add(new ArrayList<>());

        result.get(depth).add(node.val);

        horizontalWalk(node.left, depth + 1, result);
        horizontalWalk(node.right, depth + 1, result);
    }
}
