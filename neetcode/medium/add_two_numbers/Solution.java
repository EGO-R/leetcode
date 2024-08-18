package neetcode.medium.add_two_numbers;

import neetcode.easy.reverse_linked_list.ListNode;

import java.util.Scanner;

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
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var current1 = l1;
        var current2 = l2;
        var head = new ListNode();
        var current = head;
        int adding = 0;
        while (current != null) {
            current.val = adding;
            if (current1 != null) {
                current.val += current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                current.val += current2.val;
                current2 = current2.next;
            }


            if (current.val > 9) {
                adding = 1;
                current.val = current.val % 10;
            } else
                adding = 0;

            if (current1 != null || current2 != null || adding > 0)
                current.next = new ListNode();

            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var head1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var head2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(solution.addTwoNumbers(head1, head2));
    }
}
