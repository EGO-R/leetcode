package neetcode.medium.serialize_and_deserialize_BST;

/*
https://leetcode.com/problems/serialize-and-deserialize-bst/

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file
or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another
computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized
to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.
 */

import neetcode.easy.invert_binary_tree.TreeNode;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        var result = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var curr = queue.removeFirst();
                if (curr != null) {
                    result.append(curr.val);
                    result.append(" ");
                    queue.addLast(curr.left);
                    queue.addLast(curr.right);
                } else
                    result.append("n ");

            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var nodes = data.split(" ");
        if (nodes[0].equals("n"))
            return null;

        var queue = new LinkedList<TreeNode>();

        int i = 0;
        queue.addLast(new TreeNode(Integer.parseInt(nodes[i++])));

        var root = queue.getFirst();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                var node = queue.removeFirst();
                var left = nodes[i++];
                var right = nodes[i++];
                if (!left.equals("n")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.addLast(node.left);
                }
                if (!right.equals("n")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.addLast(node.right);
                }
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
