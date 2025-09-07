package leetcode19;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        ListNode listNode = solution.removeNthFromEnd(head, 2);
        System.out.println(listNode.val);
    }
}
