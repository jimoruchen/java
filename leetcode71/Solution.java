package leetcode71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        Stack<String> tmpstack = new Stack<>();
        for (String string : strings) {
            if (string.isEmpty() || string.equals(".")) {
                continue;
            }
            if (!string.equals("..")) {
                stack.push(string);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            tmpstack.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        if (tmpstack.isEmpty()) {
            sb.append('/');
        } else {
            while (!tmpstack.isEmpty()) {
                sb.append('/');
                sb.append(tmpstack.pop());
            }
        }
        return sb.toString();
    }
}

