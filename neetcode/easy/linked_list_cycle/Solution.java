package neetcode.easy.linked_list_cycle;

import neetcode.easy.reverse_linked_list.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        var start = head;
        var end = head.next;
        boolean isMove = false;

        while (end != null && start != end) {
            end = end.next;
            if (isMove)
                start = start.next;
            isMove = !isMove;
        }

        if (end == null)
            return false;
        return true;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var node1 = new ListNode(1);
        var node2 = new ListNode(2, node1);
        node1.next = node2;
        System.out.println(solution.hasCycle(node1));
    }
}
