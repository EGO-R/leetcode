package neetcode.hard.merge_k_sorted_lists;

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
https://leetcode.com/problems/merge-k-sorted-lists/

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length; i = i + step * 2) {
                if (i + step < lists.length)
                    lists[i] = sortTwo(lists[i], lists[i + step]);
                else
                    lists[i] = sortTwo(lists[i], null);
            }
            step *= 2;
        }

        return lists[0];
    }

    private ListNode sortTwo(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        var head = new ListNode();
        var current = head;
        while (current != null) {
            if (list2 == null || list1 != null && list1.val < list2.val) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
            if (list1 != null || list2 != null)
                current.next = new ListNode();
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var list3 = new ListNode(2, new ListNode(6));

        System.out.println(solution.mergeKLists(new ListNode[] {list1, list2, list3}));
    }
}
