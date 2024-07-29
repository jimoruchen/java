package test;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        insert(n1, 9);
        System.out.println(n1.next.val);
    }
    static void insert(ListNode n1, int val) {
        ListNode n2 = new ListNode(val);
        n2.next = n1.next;
        n1.next = n2;
    }
}