package neetcode.easy.merge_two_sorted_lists;

import neetcode.easy.reverse_linked_list.ListNode;

/*
https://leetcode.com/problems/merge-two-sorted-lists/

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        var result = new ListNode();
        var head = result;

        while (list1 != null || list2 != null) {
            if (list2 == null || list1 != null && list1.val <= list2.val) {
                result.val = list1.val;
                list1 = list1.next;
            }
            else {
                result.val = list2.val;
                list2 = list2.next;
            }

            if (list1 != null || list2 != null) {
                result.next = new ListNode();
                result = result.next;
            }
        }

        return head;
    }


}
