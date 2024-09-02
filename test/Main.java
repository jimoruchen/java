package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n8.left = n4;
        n8.right = n12;
        n4.left = n2;
        n4.right = n6;
        n12.left = n10;
        n12.right = n14;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;
        n14.left = n13;
        n14.right = n15;
        remove(6, n8);
        List<Integer> list = levelOrder(n8);
        for (Integer num : list)
            System.out.print(num + " ");
    }

    public static TreeNode search(int num, TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (num < cur.val)
                cur = cur.left;
            else if (num > cur.val)
                cur = cur.right;
            else break;
        }
        return cur;
    }

    public static void insert(int num, TreeNode root) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.val == num)
                return;
            pre = cur;
            if (num < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        TreeNode node = new TreeNode(num);
        if (num > pre.val)
            pre.right = node;
        else
            pre.left = node;
    }

    public static void remove(int num, TreeNode root) {
        if (root == null) return;
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (num == cur.val)
                break;
            pre = cur;
            if (num > cur.val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        if (cur == null)
            return;
        if (cur.left == null || cur.right == null) {
            TreeNode child = cur.left != null ? cur.left : cur.right;
            if (cur != root) {
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            } else {
                root = child;
            }
        } else {
            TreeNode tmp = cur.right;
            while (tmp.left != null)
                tmp = tmp.left;
            remove(tmp.val, root);
            cur.val = tmp.val;
        }

    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}