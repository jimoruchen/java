package leetcode02;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry = carry / 10;
        }
        if(carry > 0)
            p.next = new ListNode(carry);
        return head.next;
    }
}
