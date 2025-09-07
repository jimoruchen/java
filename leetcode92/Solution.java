package leetcode92;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = head;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return dummy.next;
    }
}
