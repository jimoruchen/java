package leetcode283;

class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == 0) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
}
