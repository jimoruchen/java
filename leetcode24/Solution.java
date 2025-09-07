package leetcode24;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = first.next;
            ListNode third = second.next;
            cur.next = second;
            second.next = first;
            first.next = third;
            cur = first;
        }
        return dummy.next;
    }
}
