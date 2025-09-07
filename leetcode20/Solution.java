package leetcode20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(') {
                stack.push('(');
            } else if (chars[i] == '[') {
                stack.push('[');
            } else if (chars[i] == '{') {
                stack.push('{');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.peek();
                    if (chars[i] == ')' && pop == '(' || chars[i] == ']' && pop == '[' || chars[i] == '}' && pop == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
