package leetcode498;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[] list = solution.findDiagonalOrder(nums);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
