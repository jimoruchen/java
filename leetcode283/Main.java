package leetcode283;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
