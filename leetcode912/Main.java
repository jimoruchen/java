package leetcode912;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 3, 1, 2, 6, 9, 12, 24, 2, 0};
        solution.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
