package neetcode.medium.copy_list_with_random_pointer;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied
list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y,
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes.
Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
or null if it does not point to any node.
Your code will only be given the head of the original linked list.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        var map = new HashMap<Node, Node>();

        var current = head;
        while (current != null) {
            seveNode(map, current);
            current = current.next;
        }

        var newHead = map.get(head);
        current = head.next;
        var newCurrent = newHead;
        while (current != null) {
            newCurrent.next = map.get(current);
            newCurrent = newCurrent.next;
            current = current.next;
        }

        return newHead;
    }

    private void seveNode(Map<Node, Node> map, Node source) {
        if (!map.containsKey(source))
            map.put(source, new Node(source.val));

        if (source.random == null)
            return;

        if (!map.containsKey(source.random))
            map.put(source.random, new Node(source.random.val));

        map.get(source).random = map.get(source.random);
    }

}
