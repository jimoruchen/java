package leetcode485;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }
}
