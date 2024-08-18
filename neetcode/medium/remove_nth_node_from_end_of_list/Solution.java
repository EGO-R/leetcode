package neetcode.medium.remove_nth_node_from_end_of_list;

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
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var current = head;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }

        if (n == len)
            return head.next;

        current = head;
        for (int i = 0; i < len - n - 1; i++)
            current = current.next;

        current.next = current.next.next;
        return head;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(head);
        System.out.println(solution.removeNthFromEnd(head, 2));
    }
}
