package leetcode876;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pre = head, cur = head;
        int length = 0;
        while (pre != null) {
            pre = pre.next;
            length++;
        }
        int tmp = 0;
        while (tmp < length / 2) {
            cur = cur.next;
            tmp++;
        }
        return cur;
    }
}
