package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(n1.left.left.val);
        TreeNode p = new TreeNode(6);
        n1.left = p;
        p.left = n2;
        System.out.println(n1.left.left.val);
        n1.left = n2;
        System.out.println(n1.left.left.val);
    }
}