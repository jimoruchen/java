package leetcode485;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }
}
