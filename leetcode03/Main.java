package leetcode03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("输入字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("无重复字符的最长子串长度为：" + solution.lengthOfLongestSubstring(s));
    }
}
