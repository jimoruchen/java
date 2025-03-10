package leetcode283;

public class Solution1 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int cur = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        for (int i = cur; i < length; i++) {
            nums[i] = 0;
        }
    }
}
