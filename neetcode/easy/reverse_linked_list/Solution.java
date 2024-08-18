package neetcode.easy.reverse_linked_list;

public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        while (current != null) {
            current.next = previous;
            previous = current;
            current = next;

            if (next != null)
                next = next.next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode listNode = null;
        for (int i = 0; i < 5; i++) {
            listNode = new ListNode(5 - i, listNode);
        }
        var reversedList = reverseList(listNode);
        while (reversedList != null) {
            System.out.println(reversedList);
            reversedList = reversedList.next;
        }

    }
}
