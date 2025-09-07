package leetcode394;

import java.util.Stack;

public class Solution1 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int tmp = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(tmp);
                strStack.push(res);
                res = "";
                tmp = 0;
            } else if (c == ']') {
                StringBuilder ans = new StringBuilder(strStack.pop());
                int count = numStack.pop();
                for (int j = 0; j < count; j++) {       //res = c  stack.pop() = a
                    ans.append(res);
                }
                res = ans.toString();
            } else {
                res += c;
            }
        }
        return res;
    }
}
