package leetcode328;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode tmp = head.next;
        while (tmp != null && tmp.next != null) {
            prev.next = prev.next.next;
            tmp.next = tmp.next.next;
            prev = prev.next;
            tmp = tmp.next;
        }
        prev.next = cur;
        return dummy.next;
    }
}