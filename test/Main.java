package test;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int[] nums = stack.toArray();
        for (int num : nums)
            System.out.println(num);
    }
}