package leetcode02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入链表1长度: ");
        int length1 = scanner.nextInt();
        ListNode l1 = new ListNode(scanner.nextInt());
        ListNode p = l1;
        for (int i = 1; i < length1; i++) {
            ListNode newNode = new ListNode(scanner.nextInt());
            p.next = newNode;
            p = newNode;
        }
        System.out.println("请输入链表2长度: ");
        int length2 = scanner.nextInt();
        ListNode l2 = new ListNode(scanner.nextInt());
        ListNode q = l2;
        for (int i = 1; i < length2; i++) {
            ListNode newNode = new ListNode(scanner.nextInt());
            q.next = newNode;
            q = newNode;
        }
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
