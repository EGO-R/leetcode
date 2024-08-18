package neetcode.easy.palindrome_linked_list;

import neetcode.easy.reverse_linked_list.ListNode;

/*
https://leetcode.com/problems/palindrome-linked-list/

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        var curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head;
        ListNode prev = null;
        var next = curr.next;

        for (int i = 0; i < len / 2; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        var left = prev;
        ListNode right = curr;
        if (len % 2 != 0)
            right = next;

        while (left != null && right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
