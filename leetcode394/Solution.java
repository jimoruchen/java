package leetcode394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<StringBuilder> stack2 = new Stack<>();
        int tmp = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = tmp * 10 + ch - '0';
            } else if (ch >= 'a' && ch <= 'z') {
                res.append(ch);
            } else if (ch == '[') {
                stack1.push(tmp);
                stack2.push(res);
                tmp = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                int count = stack1.pop();
                StringBuilder out = stack2.pop();
                for (int j = 0; j < count; j++) {
                    out.append(res.toString());
                }
                res = out;
            }
        }
        return res.toString();

    }
}
