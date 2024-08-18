package neetcode.hard.reverse_nodes_in_k_group;

import neetcode.easy.reverse_linked_list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode previous = null;
        var current = head;
        var next = head;

        while (next != null) {
            for (int i = 0; i < k - 1; i++) {
                if (next != null)
                    next = next.next;
            }
            if (next == null)
                break;
            reverseWindow(current, next);
            if (previous != null)
                previous.next = next;
            else
                head = next;
            previous = current;
            current = current.next;
            next = current;

        }

        return head;
    }

    private void reverseWindow(ListNode start, ListNode end) {
        if (start == end)
            return;
        ListNode previous = end.next;
        var current = start;
        var next = current.next;
        var endCheck = end.next;

        while (current != endCheck) {
            current.next = previous;
            previous = current;
            current = next;
            if (next != null)
                next = next.next;
        }
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(head);
        System.out.println(solution.reverseKGroup(head, 2));

    }
}
