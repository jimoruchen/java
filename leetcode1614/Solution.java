package leetcode1614;

import java.util.Stack;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int tmp = 0, result = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.push('c');
                tmp++;
                result = Math.max(result, tmp);
            } else if (c == ')') {
                stack.pop();
                tmp--;
            }
        }
        return result;
    }
}