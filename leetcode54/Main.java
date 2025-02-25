package leetcode54;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] nums = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> list = solution.spiralOrder(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
