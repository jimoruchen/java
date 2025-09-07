package leetcode19;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = head;
        ListNode cur = dummy;
        int len = 0;
        while (prev != null) {
            prev = prev.next;
            len++;
        }
        for (int i = 0; i < len - n; i++)
            cur = cur.next;
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
