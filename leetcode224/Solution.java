package leetcode224;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    tmp = tmp * 10 + s.charAt(i) - '0';
                }
                count = count +  tmp * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(count);
                stack.push(sign);
                count = 0;
                sign = 1;
            } else if (c == ')') {
                int topSign = stack.pop();
                int topNum = stack.pop();
                count = topNum + count * topSign;
            }
        }
        return count;
    }
}
