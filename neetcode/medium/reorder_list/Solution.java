package neetcode.medium.reorder_list;

import neetcode.easy.reverse_linked_list.ListNode;

import java.util.Stack;

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
https://leetcode.com/problems/reorder-list/

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;

        var stack = new Stack<ListNode>();
        var current = head.next;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        var next = head.next;
        var stackValue = stack.pop();

        while (next != stackValue && current != stackValue) {
            current.next = stackValue;
            stackValue.next = next;
            current = next;
            next = next.next;
            stackValue = stack.pop();
        }

        if (stackValue == next)
            next.next = null;
        else
            stackValue.next = null;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        System.out.println(head);
        solution.reorderList(head);
        System.out.println(head);
    }
}
